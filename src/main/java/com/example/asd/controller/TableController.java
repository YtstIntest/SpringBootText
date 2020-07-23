package com.example.asd.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.asd.common.ResponseBean;
import com.example.asd.config.helper.ValidateHelper;
import com.example.asd.dto.TableEditResponse;
import com.example.asd.entity.*;
import com.example.asd.entity.base.*;
import com.example.asd.exception.CustomException;
import com.example.asd.service.impl.*;
import com.example.asd.util.common.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = {"表格编辑"})
public class TableController {

    @Autowired
    EditSaveTableImpl editSaveTableImpl;

    @Autowired
    MeunImpl meunImpl;

    @Autowired
    ColumnImpl columnImpl;

    @Autowired
    OptionImpl optionImpl;

    @Autowired
    ToolbarImpl toolbarImpl;

    @Autowired
    ItemImpl itemImpl;

    @Autowired
    ColumnOptionImpl columnOptionImpl;

    @Autowired
    ToolbarItemImpl toolbarItemImpl;

    @Autowired
    TableColumnImpl tableColumnImpl;

    @RequestMapping(value = "/api/basic/table/gettoolbar", method = RequestMethod.GET)
    public ResponseBean gettoolbar(String tableId) {
        return null;
    }


    @RequestMapping(value = "/api/basic/table/getmenu", method = RequestMethod.GET)
    public ResponseBean getmenu() {
        List<MeunBto> meunBtos = meunImpl.getMeun();
        List<MenuResponse.MenuItemBean> data = new ArrayList<>();
        for (MeunBto meunBto : meunBtos) {
            MenuResponse.MenuItemBean menuItemBean = new MenuResponse.MenuItemBean(meunBto.getMenuId(), path(meunBto, new StringBuffer()).toString(), meunBto.getMenulink());
            data.add(menuItemBean);
        }
        return new ResponseBean(1, "查询成功", new MenuResponse(data));
    }


    public StringBuffer path(MeunBto meunBto, StringBuffer path) {
        String name = meunBto.getMenudisplayname();
        path.insert(0, name + "/");
        if (StringUtils.isNotEmptyStr(meunBto.getFkMenuId())) {
            path(meunImpl.getMeunById(meunBto.getFkMenuId()), path);
            return path;
        } else {
            return path;
        }
    }

    @RequestMapping(value = "/api/basic/table/gettableinfo", method = RequestMethod.GET)
    public ResponseBean gettableinfo(String menuId) {
        List<TableBto> tableBtoList = editSaveTableImpl.getTableByMenuId(menuId);
        List<TableResponse.TableBean> tableBeanList = new ArrayList<>();
        for (TableBto tableBto : tableBtoList) {
            List<TableColumnBto> tableColumnBtoList = tableColumnImpl.getTableColumnListById(tableBto.getTableId());
            List<TableResponse.ToolbarBean> toolbarBeanList = new ArrayList<>();
            List<TableResponse.ColumnBean> columnBeanList = new ArrayList<>();
            for (TableColumnBto tableColumnBto : tableColumnBtoList) {
                ColumnBto columnBto = columnImpl.getColumnById(tableColumnBto.getFkColumnId());//colum列信息
                List<ColumnOptionBto> columnOptionBtoList = columnOptionImpl.getColumnOptionAllById(columnBto.getColumnId());
                List<TableResponse.OptionBean> optionBeanList = new ArrayList<>();
                for (ColumnOptionBto columnOptionBto : columnOptionBtoList) {
                    OptionBto optionBto = optionImpl.getOptionById(columnOptionBto.getFkOptionId());//option参数信息
                    TableResponse.OptionBean optionBean = new TableResponse.OptionBean(optionBto.getOptionId(), optionBto.getKind(), optionBto.getFieldText());
                    optionBeanList.add(optionBean);
                }
                TableResponse.ColumnBean columnBean = new TableResponse.ColumnBean(columnBto.getColumnId(), columnBto.getColumnName(), columnBto.getOrderNum(), columnBto.getWidth(), columnBto.getChecked(), columnBto.getIscansort(), optionBeanList);
                columnBeanList.add(columnBean);
            }
            List<ItemBto> itemBtoList = itemImpl.getAllItem();
            for (ItemBto itemBto : itemBtoList) {
                ToolbarItemBto toolbarItemBto = toolbarItemImpl.getToolbarItemByItemId(itemBto.getItemId());
                if (toolbarItemBto != null) {
                    TableResponse.ToolbarBean toolbarBean = new TableResponse.ToolbarBean(itemBto.getItemId(), itemBto.getName(), itemBto.getIcon(), true);
                    toolbarBeanList.add(toolbarBean);
                } else {
                    TableResponse.ToolbarBean toolbarBean = new TableResponse.ToolbarBean(itemBto.getItemId(), itemBto.getName(), itemBto.getIcon(), false);
                    toolbarBeanList.add(toolbarBean);
                }

            }
            TableResponse.TableBean tableBean = new TableResponse.TableBean(tableBto.getTableId(), tableBto.getRemark(), toolbarBeanList, columnBeanList);
            tableBeanList.add(tableBean);
        }

        return new ResponseBean(1, "查询成功", new TableResponse(tableBeanList));

    }


    @RequestMapping(value = "/api/basic/table/getquery", method = RequestMethod.GET)
    public ResponseBean getquery(@ApiParam String optionId) {
        if (!StringUtils.isNotEmptyStr(optionId)) {
            throw new CustomException("optionId不能为空！");
        }
        OptionBto optionBto = optionImpl.getOptionById(optionId);
        List<OptionResponse.ListFilter> listFilter = JSONArray.parseArray(optionBto.getListoffilter(), OptionResponse.ListFilter.class);
        OptionResponse optionResponse = new OptionResponse(optionBto.getOptionId(), optionBto.getKind(), optionBto.getDateType(), optionBto.getMaxLength(), optionBto.getMinLength(), optionBto.getMaxNum(), optionBto.getMinNum(), optionBto.getRegularText(), optionBto.getDateFormat(), optionBto.getQueryFields(), listFilter, optionBto.getValue(), optionBto.getText(), optionBto.getDateSourceKind(), optionBto.getValueRange());
        return new ResponseBean(1, "查询成功", optionResponse);

    }

    @RequestMapping(value = "/api/basic/table/savequery", method = RequestMethod.POST)
    public ResponseBean savequery(@RequestBody OptionRequest optionRequest) {
        ValidateHelper.validateNull(optionRequest, new String[]{"optionId"});
        OptionBto optionBto = optionImpl.getOptionById(optionRequest.getOptionId());
        if (optionBto == null) {
            throw new CustomException("该optionId不存在！");
        }
        optionBto.setKind(optionRequest.getKind());
        optionBto.setDateType(optionRequest.getDataType());
        optionBto.setMaxLength(optionRequest.getMaxLength());
        optionBto.setMinLength(optionRequest.getMinLength());
        optionBto.setMaxNum(optionRequest.getMaxNum());
        optionBto.setRegularText(optionRequest.getRegularText());
        optionBto.setDateFormat(optionRequest.getDateFormat());
        optionBto.setQueryFields(optionRequest.getQueryFields());
        optionBto.setListoffilter(JSONArray.toJSONString(optionRequest.getListOfFilter()));
        optionBto.setDateSourceKind(optionRequest.getDataSourceKind());
        optionBto.setValueRange(optionRequest.getValueRange());
        if (optionImpl.updateOption(optionBto) == 1) {
            return new ResponseBean(1, "保存成功", new TableEditResponse(1));
        } else {
            return new ResponseBean(0, "保存失败", new TableEditResponse(0));
        }
    }


    @RequestMapping(value = "/api/basic/table/savetable", method = RequestMethod.POST)
    public ResponseBean savetable(@RequestBody TableRequest tableRequest) {
        ValidateHelper.validateNull(tableRequest, new String[]{"menuId", "toolbar", "column"});
        if (meunImpl.getMeunById(tableRequest.getMenuId()) == null) {
            throw new CustomException("该menuId不存在！");
        }
        if (StringUtils.isNotEmptyStr(tableRequest.getTableId())) {//修改
            TableBto newTableBto = editSaveTableImpl.getTableByID(tableRequest.getTableId());
            if (newTableBto == null) {
                throw new CustomException("该tableID不存在！");
            }
            if (!newTableBto.getFkMenuId().equals(tableRequest.getMenuId())) {
                throw new CustomException("您输入的menuId错误！");
            }
            for (TableRequest.ColumnBean column : tableRequest.getColumn()) {
                if (columnImpl.getColumnById(column.getColumnId()) == null) {
                    throw new CustomException("您输入的columnId不存在！");
                }
                ColumnBto columnBto = new ColumnBto(column.getColumnId(), column.getColumnName(), column.getOrderNum(), column.getWidth(), column.getChecked(), column.getIsCanSort());
                if (columnImpl.updateColumn(columnBto) != 1) {
                    throw new CustomException("修改columnId失败！");
                }
                for (TableRequest.OptionBean optionBean : column.getOption()) {
                    if (optionImpl.getOptionById(optionBean.getOptionId()) == null) {
                        throw new CustomException("您输入的optionId不存在！");
                    }
                    OptionBto optionBto = new OptionBto(optionBean.getOptionId(), optionBean.getKind(), optionBean.getDateType(), optionBean.getMaxLength(), optionBean.getMinLength(), optionBean.getMaxNum(), optionBean.getMinNum(), optionBean.getRegularText(), optionBean.getDateFormat(), optionBean.getQueryFields(), optionBean.getListoffilter(), optionBean.getValue(), optionBean.getText(), optionBean.getDateSourceKind(), optionBean.getValueRange(), optionBean.getFieldText());
                    if (optionImpl.updateOption(optionBto) != 1) {
                        throw new CustomException("修改option失败！");
                    }
                }
                TableColumnBto tableColumnBto = tableColumnImpl.getTableColumnByColumnId(column.getColumnId());
                if (tableColumnBto == null) {
                    throw new CustomException("table_option数据不存在！");
                }
                tableColumnBto.setChecked(column.getChecked());
                tableColumnBto.setIscansort(column.getIsCanSort());
                tableColumnBto.setWidth(column.getWidth());
                tableColumnBto.setOrderNum(column.getOrderNum());
                if (tableColumnImpl.updateTableColumn(tableColumnBto) != 1) {
                    throw new CustomException("修改table_option数据失败！");
                }
            }
            ToolbarBto toolbarBto = toolbarImpl.getToolbarByTableId(tableRequest.getTableId());
            if (toolbarBto == null) {
                throw new CustomException("您输入toolbar不存在！");
            }
            toolbarBto.setCharecked(tableRequest.getToolbar().isChecked() ? 1 : 0);
            if (toolbarImpl.updateToolbar(toolbarBto) != 1) {
                throw new CustomException("修改列toolbar失败！");
            }

            for (TableRequest.ItemBean itemBean : tableRequest.getToolbar().getItems()) {
                if (itemBean.isSelect()) {
                    if (toolbarItemImpl.getToolbarItemByItemId(itemBean.getItemId()) == null) {
                        ToolbarItemBto toolbarItemBto = new ToolbarItemBto(UUID.randomUUID() + "", toolbarBto.getToolbarId(), itemBean.getItemId());
                        if (toolbarItemImpl.addToolbarItem(toolbarItemBto) != 1) {
                            throw new CustomException("toolbar_item失败！");
                        }
                    }
                } else {
                    ToolbarItemBto toolbarItemBto = toolbarItemImpl.getToolbarItemByItemId(itemBean.getItemId());
                    if (toolbarItemBto != null) {
                        if (toolbarItemImpl.deleteToolbarItem(toolbarItemBto.getToolbaritemId()) != 1) {
                            throw new CustomException("取消toolbar_item失败！");
                        }
                    }
                }
            }
            TableBto tableBto = new TableBto(tableRequest.getTableId(), tableRequest.getMenuId(), tableRequest.getRemark());
            if (editSaveTableImpl.updateTable(tableBto) == 1) {
                return new ResponseBean(1, "修改成功", new TableEditResponse(1));
            } else {
                return new ResponseBean(0, "修改失败", new TableEditResponse(0));
            }
        } else {//新建
            if (meunImpl.getMeunById(tableRequest.getMenuId()) == null) {
                throw new CustomException("您输入的menuId不存在！");
            }
            TableBto tableBto = new TableBto(UUID.randomUUID() + "", tableRequest.getMenuId(), tableRequest.getRemark());
            for (TableRequest.ColumnBean column : tableRequest.getColumn()) {
                ColumnBto columnBto = new ColumnBto(column.getColumnId(), column.getColumnName(), column.getOrderNum(), column.getWidth(), column.getChecked(), column.getIsCanSort());
                if (columnImpl.getColumnById(column.getColumnId()) != null) {
                    throw new CustomException("columnId已经存在！");
                }
                if (columnImpl.addColumn(columnBto) != 1) {
                    throw new CustomException("存储column数据失败！");
                }
                for (TableRequest.OptionBean optionBean : column.getOption()) {
                    OptionBto optionBto = new OptionBto(optionBean.getOptionId(), optionBean.getKind(), optionBean.getDateType(), optionBean.getMaxLength(), optionBean.getMinLength(), optionBean.getMaxNum(), optionBean.getMinNum(), optionBean.getRegularText(), optionBean.getDateFormat(), optionBean.getQueryFields(), optionBean.getListoffilter(), optionBean.getValue(), optionBean.getText(), optionBean.getDateSourceKind(), optionBean.getValueRange(), optionBean.getFieldText());
                    if (optionImpl.getOptionById(optionBean.getOptionId()) != null) {
                        throw new CustomException("optionId已经存在！");
                    }
                    if (optionImpl.addOption(optionBto) != 1) {
                        throw new CustomException("存储option数据失败！");
                    }
                    ColumnOptionBto columnOptionBto = new ColumnOptionBto(UUID.randomUUID() + "", optionBean.getOptionId(), column.getColumnId());
                    if (columnOptionImpl.addColumnOption(columnOptionBto) != 1) {
                        throw new CustomException("存储column_option数据失败！");
                    }
                }
                TableColumnBto tableColumnBto = new TableColumnBto(UUID.randomUUID() + "", tableBto.getTableId(), column.getColumnId(), column.getOrderNum(), column.getWidth(), column.getChecked(), column.getIsCanSort());
                if (tableColumnImpl.addTableColumn(tableColumnBto) != 1) {
                    throw new CustomException("存储table_column数据失败！");
                }
            }
            ToolbarBto toolbarBto = new ToolbarBto(UUID.randomUUID() + "", tableRequest.getToolbar().isChecked() ? 1 : 0, tableRequest.getRemark(), tableBto.getTableId());
            if (toolbarImpl.addToolbar(toolbarBto) != 1) {
                throw new CustomException("存储toolbar失败！");
            }
            for (TableRequest.ItemBean itemBean : tableRequest.getToolbar().getItems()) {
                if (itemBean.isSelect()) {//true关联
                    ItemBto itemBto = new ItemBto(itemBean.getItemId());
                    if (itemImpl.addItem(itemBto) != 1) {
                        throw new CustomException("存储items失败！");
                    }
                    ToolbarItemBto toolbarItemBto = new ToolbarItemBto(UUID.randomUUID() + "", toolbarBto.getToolbarId(), itemBean.getItemId());
                    if (toolbarItemImpl.addToolbarItem(toolbarItemBto) != 1) {
                        throw new CustomException("存储toolbar_item失败！");
                    }

                } else {//不关联
                    ItemBto itemBto = new ItemBto(itemBean.getItemId());
                    if (itemImpl.addItem(itemBto) != 1) {
                        throw new CustomException("存储items失败！");
                    }
                }
            }
            if (editSaveTableImpl.addTable(tableBto) == 1) {
                return new ResponseBean(1, "保存成功", new TableEditResponse(1));
            } else {
                return new ResponseBean(0, "保存失败", new TableEditResponse(0));
            }
        }
    }


}
