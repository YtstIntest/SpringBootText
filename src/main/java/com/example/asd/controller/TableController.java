package com.example.asd.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.asd.common.ResponseBean;
import com.example.asd.config.helper.ValidateHelper;
import com.example.asd.entity.base.TableEditResponse;
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
        if (!StringUtils.isNotEmptyStr(tableId)) {
            throw new CustomException("tableId不能为空！");
        }
        ToolbarBto toolbarBto = toolbarImpl.getToolbarByTableId(tableId);
        if (toolbarBto == null) {
            throw new CustomException("toolbar未找到！");
        }
        List<ToolbarItemBto> toolbarItemBtoList = toolbarItemImpl.getToolbarAllItemById(toolbarBto.getToolbarId());
        if (toolbarItemBtoList.size() == 0 || toolbarItemBtoList == null) {
            throw new CustomException("toolbarItem未找到！");
        }
        List<ItemBto> itemBtoList = new ArrayList<>();
        for (ToolbarItemBto toolbarItemBto : toolbarItemBtoList) {
            ItemBto itemBto = itemImpl.getItemById(toolbarItemBto.getFkItemId());
            if (itemBto == null) {
                throw new CustomException("item未找到！");
            }
            itemBtoList.add(itemBto);
        }
        List<ToolbarResponse.ItemBean> items = new ArrayList<>();
        for (ItemBto itemBto : itemBtoList) {
            List<ToolbarResponse.SubItemBean> subItem = new ArrayList<>();
            ToolbarResponse.ItemBean itemBean = new ToolbarResponse.ItemBean(itemBto.getItemId(), itemBto.getName(), itemBto.getIcon());
            if (StringUtils.isNotEmptyStr(itemBto.getFkItemId())) {
                ItemBto itemBto1 = itemImpl.getItemById(itemBto.getFkItemId());
                ToolbarResponse.SubItemBean subItemBean = new ToolbarResponse.SubItemBean(itemBto1.getItemId(), itemBto1.getName(), itemBto1.getIcon());
                subItem.add(subItemBean);
            }
            itemBean.setSubItem(subItem);
            items.add(itemBean);
        }

        return new ResponseBean(1, "查询成功", new ToolbarResponse(toolbarBto.getToolbarId(), toolbarBto.getCharecked() == 1 ? true : false, items));
    }

    @RequestMapping(value = "/api/basic/table/selectcolumn", method = RequestMethod.POST)
    public ResponseBean getcolumn(@RequestBody ColumnRequest columnRequest) {
        List<ColumnItemResponse> columnItemResponseList = new ArrayList<>();
        if (columnRequest.getStyle() == null || columnRequest.getStyle().size() == 0) {
            List<TableColumnBto> tableColumnBtoList = tableColumnImpl.getTableColumnListById(columnRequest.getTableId());
            for (TableColumnBto tableColumnBto : tableColumnBtoList) {
                ColumnBto columnBto = columnImpl.getColumnById(tableColumnBto.getFkColumnId());
                ColumnItemResponse columnItemResponse = new ColumnItemResponse();
                columnItemResponse.setColumnId(columnBto.getColumnId());
                columnItemResponse.setDataPropertyName(columnBto.getDataPropertyName());
                columnItemResponse.setTitle(columnBto.getColumnName());
                ColumnItemResponse.StyleItemBean styleItemBean = new ColumnItemResponse.StyleItemBean(columnBto.getOrderNum(), columnBto.getWidth(), columnBto.getIsshow() == 1 ? true : false, columnBto.getIscansort() == 1 ? true : false, columnBto.getSort());
                columnItemResponse.setStyle(styleItemBean);
                List<ColumnItemResponse.QueryItemBean> queryList = new ArrayList<>();
                List<ColumnOptionBto> columnOptionBtoList = columnOptionImpl.getColumnOptionAllById(columnBto.getColumnId());
                if (columnOptionBtoList.size() != 0 && columnOptionBtoList != null) {
                    for (ColumnOptionBto columnOptionBto : columnOptionBtoList) {
                        ColumnItemResponse.QueryItemBean queryItemBean = new ColumnItemResponse.QueryItemBean();
                        OptionBto optionBto = optionImpl.getOptionById(columnOptionBto.getFkOptionId());
                        if (optionBto == null) {
                            throw new CustomException("option不存在！");
                        }
                        queryItemBean.setKind(optionBto.getKind());
                        queryItemBean.setIndex(columnOptionBto.getIntdex());
                        queryItemBean.setQueryFields(optionBto.getQueryFields());
                        queryItemBean.setOptionId(optionBto.getOptionId());
                        queryItemBean.setFieldText(optionBto.getFieldText());
                        switch (optionBto.getKind()) {
                            case 1:
                                ColumnItemResponse.OneItemBean oneItemBean = new ColumnItemResponse.OneItemBean();
                                oneItemBean.setDataType(optionBto.getDateType());
                                oneItemBean.setMaxLength(optionBto.getMaxLength());
                                oneItemBean.setMaxNum(optionBto.getMaxNum());
                                oneItemBean.setMinNum(optionBto.getMinNum());
                                oneItemBean.setRegularText(optionBto.getRegularText());
                                oneItemBean.setDateFormat(optionBto.getDateFormat());
                                queryItemBean.setOptions(oneItemBean);
                                break;
                            case 2:
                                ColumnItemResponse.TwoItemBean twoItemBean = new ColumnItemResponse.TwoItemBean();
                                twoItemBean.setDataSourceKind(optionBto.getDateSourceKind());
                                List<ColumnItemResponse.TwoItemFilterBean> listFilter = new ArrayList<>();
                                if (StringUtils.isNotEmptyStr(optionBto.getListoffilter())) {
                                    listFilter = JSONArray.parseArray(optionBto.getListoffilter(), ColumnItemResponse.TwoItemFilterBean.class);
                                }
                                twoItemBean.setListOfFilter(listFilter);
                                queryItemBean.setOptions(twoItemBean);
                                break;
                            case 3:
                                ColumnItemResponse.ThreeItemBean threeItemBean = new ColumnItemResponse.ThreeItemBean();
                                if (StringUtils.isNotEmptyStr(optionBto.getValueRange())) {
                                    threeItemBean.setValueRange(JSONArray.parseArray(optionBto.getValueRange()));
                                } else {
                                    threeItemBean.setValueRange(new ArrayList());
                                }
                                threeItemBean.setDataType(optionBto.getDateType());
                                threeItemBean.setQueryFields(optionBto.getQueryFields());
                                threeItemBean.setDateFormat(optionBto.getDateFormat());
                                queryItemBean.setOptions(threeItemBean);
                                break;
                        }
                        queryList.add(queryItemBean);
                    }
                }
                columnItemResponse.setQueryList(queryList);
                columnItemResponseList.add(columnItemResponse);
            }
        } else {
            for (ColumnRequest.StyleBean styleBean : columnRequest.getStyle()) {
                ColumnBto columnBto = columnImpl.getColumnById(styleBean.getColumnId());
                if (columnBto == null) {
                    throw new CustomException("未找到对应column！");
                }
                columnBto.setOrderNum(styleBean.getOrderNum());
                columnBto.setWidth(styleBean.getWidth());
                columnBto.setIsshow(styleBean.isShow() ? 1 : 0);
                columnBto.setSort(styleBean.getSort());
                if (columnImpl.updateColumn(columnBto) != 1) {
                    throw new CustomException("更新column失败！");
                }
                ColumnItemResponse columnItemResponse = new ColumnItemResponse();
                columnItemResponse.setColumnId(columnBto.getColumnId());
                columnItemResponse.setDataPropertyName(columnBto.getDataPropertyName());
                columnItemResponse.setTitle(columnBto.getColumnName());
                ColumnItemResponse.StyleItemBean styleItemBean = new ColumnItemResponse.StyleItemBean(styleBean.getOrderNum(), styleBean.getWidth(), styleBean.isShow(), columnBto.getIscansort() == 1 ? true : false, styleBean.getSort());
                columnItemResponse.setStyle(styleItemBean);

                List<ColumnItemResponse.QueryItemBean> queryList = new ArrayList<>();
                List<ColumnOptionBto> columnOptionBtoList = columnOptionImpl.getColumnOptionAllById(columnBto.getColumnId());
                if (columnOptionBtoList.size() == 0 || columnOptionBtoList == null) {
                    throw new CustomException("columnOptionImpl不存在！");
                }
                for (ColumnOptionBto columnOptionBto : columnOptionBtoList) {
                    ColumnItemResponse.QueryItemBean queryItemBean = new ColumnItemResponse.QueryItemBean();
                    OptionBto optionBto = optionImpl.getOptionById(columnOptionBto.getFkOptionId());
                    if (optionBto == null) {
                        throw new CustomException("option不存在！");
                    }
                    queryItemBean.setKind(optionBto.getKind());
                    queryItemBean.setIndex(columnOptionBto.getIntdex());
                    queryItemBean.setQueryFields(optionBto.getQueryFields());
                    queryItemBean.setOptionId(optionBto.getOptionId());
                    queryItemBean.setFieldText(optionBto.getFieldText());
                    switch (optionBto.getKind()) {
                        case 1:
                            ColumnItemResponse.OneItemBean oneItemBean = new ColumnItemResponse.OneItemBean();
                            oneItemBean.setDataType(optionBto.getDateType());
                            oneItemBean.setMaxLength(optionBto.getMaxLength());
                            oneItemBean.setMaxNum(optionBto.getMaxNum());
                            oneItemBean.setMinNum(optionBto.getMinNum());
                            oneItemBean.setRegularText(optionBto.getRegularText());
                            oneItemBean.setDateFormat(optionBto.getDateFormat());
                            queryItemBean.setOptions(oneItemBean);
                            break;
                        case 2:
                            ColumnItemResponse.TwoItemBean twoItemBean = new ColumnItemResponse.TwoItemBean();
                            twoItemBean.setDataSourceKind(optionBto.getDateSourceKind());
                            List<ColumnItemResponse.TwoItemFilterBean> listFilter = new ArrayList<>();
                            if (StringUtils.isNotEmptyStr(optionBto.getListoffilter())) {
                                listFilter = JSONArray.parseArray(optionBto.getListoffilter(), ColumnItemResponse.TwoItemFilterBean.class);
                            }
                            twoItemBean.setListOfFilter(listFilter);
                            queryItemBean.setOptions(twoItemBean);
                            break;
                        case 3:
                            ColumnItemResponse.ThreeItemBean threeItemBean = new ColumnItemResponse.ThreeItemBean();
                            if (StringUtils.isNotEmptyStr(optionBto.getValueRange())) {
                                threeItemBean.setValueRange(JSONArray.parseArray(optionBto.getValueRange()));
                            } else {
                                threeItemBean.setValueRange(new ArrayList());
                            }
                            threeItemBean.setDataType(optionBto.getDateType());
                            threeItemBean.setQueryFields(optionBto.getQueryFields());
                            threeItemBean.setDateFormat(optionBto.getDateFormat());
                            queryItemBean.setOptions(threeItemBean);
                            break;
                    }
                    queryList.add(queryItemBean);
                }
                columnItemResponse.setQueryList(queryList);
                columnItemResponseList.add(columnItemResponse);
            }
        }
        return new ResponseBean(1, "查询成功", columnItemResponseList);
    }


    /**
     * 获取全部菜单下拉框列表数据
     *
     * @return
     */
    @RequestMapping(value = "/api/basic/table/getmenu", method = RequestMethod.GET)
    public ResponseBean getmenu() {
        List<MeunBto> meunBtos = meunImpl.getMeun();
        if (meunBtos.size() == 0) {
            return new ResponseBean(1, "查询成功", null);
        }
        List<MenuResponse.MenuItemBean> data = new ArrayList<>();
        for (MeunBto meunBto : meunBtos) {
            MenuResponse.MenuItemBean menuItemBean = new MenuResponse.MenuItemBean(meunBto.getMenuId(), path(meunBto, new StringBuffer()).toString(), meunBto.getMenulink());
            data.add(menuItemBean);
        }
        return new ResponseBean(1, "查询成功", new MenuResponse(data));
    }


    /**
     * 获取一个菜单下的全部表格基本数据
     *
     * @param menuId
     * @return
     */
    @RequestMapping(value = "/api/basic/table/gettableinfo", method = RequestMethod.GET)
    public ResponseBean gettableinfo(String menuId) {
        if (!StringUtils.isNotEmptyStr(menuId)) {
            throw new CustomException("menuId不能为空！");
        }
        List<TableBto> tableBtoList = editSaveTableImpl.getTableByMenuId(menuId);
        List<TableResponse.TableBean> tableBeanList = null;
        if (tableBtoList != null) {
            tableBeanList = new ArrayList<>();
            for (TableBto tableBto : tableBtoList) {
                List<TableColumnBto> tableColumnBtoList = tableColumnImpl.getTableColumnListById(tableBto.getTableId());
                List<TableResponse.ColumnBean> columnBeanList = new ArrayList<>();
                for (TableColumnBto tableColumnBto : tableColumnBtoList) {
                    ColumnBto columnBto = columnImpl.getColumnById(tableColumnBto.getFkColumnId());//colum列信息
                    List<ColumnOptionBto> columnOptionBtoList = columnOptionImpl.getColumnOptionAllById(columnBto.getColumnId());
                    List<TableResponse.OptionBean> optionBeanList = new ArrayList<>();
                    for (ColumnOptionBto columnOptionBto : columnOptionBtoList) {
                        OptionBto optionBto = optionImpl.getOptionById(columnOptionBto.getFkOptionId());//option参数信息
                        List<TableResponse.ListItemFilterBean> listItemFilterBeanList = new ArrayList<>();
                        if (StringUtils.isNotEmptyStr(optionBto.getListoffilter())) {
                            listItemFilterBeanList = JSONArray.parseArray(optionBto.getListoffilter(), TableResponse.ListItemFilterBean.class);
                        }
                        List valueRangeList = new ArrayList();
                        if (StringUtils.isNotEmptyStr(optionBto.getValueRange())) {
                            valueRangeList = JSONArray.parseArray(optionBto.getValueRange());
                        }
                        TableResponse.OptionBean optionBean = new TableResponse.OptionBean(optionBto.getOptionId(), optionBto.getKind(), optionBto.getDateType(), optionBto.getMaxLength(), optionBto.getMinLength(), optionBto.getMaxNum(), optionBto.getMinNum(), optionBto.getRegularText(), optionBto.getDateFormat(), optionBto.getQueryFields(), listItemFilterBeanList, optionBto.getDateSourceKind(), valueRangeList, optionBto.getIsdelete(), optionBto.getFieldText());
                        optionBeanList.add(optionBean);
                    }
                    TableResponse.ColumnBean columnBean = new TableResponse.ColumnBean(columnBto.getColumnId(), columnBto.getColumnName(), columnBto.getOrderNum(), columnBto.getWidth(), columnBto.getIsshow() == 1 ? true : false, columnBto.getIscansort() == 1 ? true : false, optionBeanList, columnBto.getDataPropertyName());
                    columnBeanList.add(columnBean);
                }

                ToolbarBto toolbarBto = toolbarImpl.getToolbarByTableId(tableBto.getTableId());
                List<ToolbarItemBto> toolbarItemBtoList = toolbarItemImpl.getToolbarAllItemById(toolbarBto.getToolbarId());

                List<ItemBto> itemBtoList = itemImpl.getAllItem();
                List<TableResponse.ItemBean> item = new ArrayList<>();
                for (ItemBto itemBto : itemBtoList) {
                    TableResponse.ItemBean itemBean = new TableResponse.ItemBean(itemBto.getItemId(), itemBto.getName(), false, itemBto.getIcon());
                    item.add(itemBean);
                }
                for (TableResponse.ItemBean itemBean : item) {
                    for (ToolbarItemBto toolbarItemBto : toolbarItemBtoList) {
                        if (itemBean.getItemId().equals(toolbarItemBto.getFkItemId())) {
                            itemBean.setIsSelect(true);
                        }
                    }
                }
                TableResponse.ToolbarBean toolbarBean = new TableResponse.ToolbarBean(toolbarBto.getCharecked() == 1 ? true : false, item);

                TableResponse.TableBean tableBean = new TableResponse.TableBean(tableBto.getTableId(), tableBto.getRemark(), toolbarBean, columnBeanList);
                tableBeanList.add(tableBean);
            }
        }
        return new ResponseBean(1, "查询成功", new TableResponse(tableBeanList));

    }

    /**
     * 获取一个查询条件的编辑信息
     *
     * @param optionId
     * @return
     */
    @RequestMapping(value = "/api/basic/table/getquery", method = RequestMethod.GET)
    public ResponseBean getquery(@ApiParam String optionId) {
        if (!StringUtils.isNotEmptyStr(optionId)) {
            throw new CustomException("optionId不能为空！");
        }
        OptionBto optionBto = optionImpl.getOptionById(optionId);
        if (optionBto == null) {
            throw new CustomException("该optionId不存在！");
        }
        List<OptionResponse.ListFilter> listFilter = new ArrayList<>();
        if (StringUtils.isNotEmptyStr(optionBto.getListoffilter())) {
            listFilter = JSONArray.parseArray(optionBto.getListoffilter(), OptionResponse.ListFilter.class);
        }
        OptionResponse optionResponse = new OptionResponse(optionBto.getOptionId(), optionBto.getKind(), optionBto.getDateType(), optionBto.getMaxLength(), optionBto.getMinLength(), optionBto.getMaxNum(), optionBto.getMinNum(), optionBto.getRegularText(), optionBto.getDateFormat(), optionBto.getQueryFields(), listFilter, optionBto.getDateSourceKind(), JSONArray.parseArray(optionBto.getValueRange()), optionBto.getFieldText());
        return new ResponseBean(1, "查询成功", optionResponse);

    }

    /**
     * 保存一个查询条件的编辑信息
     *
     * @param optionRequest
     * @return
     */
    @RequestMapping(value = "/api/basic/table/savequery", method = RequestMethod.POST)
    public ResponseBean savequery(@RequestBody OptionRequest optionRequest) {
        ValidateHelper.validateNull(optionRequest, new String[]{"optionId", "columnId", "Kind"});
        OptionBto optionBto = optionImpl.getOptionById(optionRequest.getOptionId());
        if (optionBto == null) {
            OptionBto optionBto2 = new OptionBto(optionRequest.getOptionId(), optionRequest.getKind(), optionRequest.getDataType(), optionRequest.getMaxLength(), optionRequest.getMinLength(), optionRequest.getMaxNum(), optionRequest.getMinNum(), optionRequest.getRegularText(), optionRequest.getDateFormat(), optionRequest.getQueryFields(), JSONArray.toJSONString(optionRequest.getListOfFilter()), optionRequest.getDataSourceKind(), JSONArray.toJSONString(optionRequest.getValueRange()), optionRequest.getFieldText());
            if (columnOptionImpl.addColumnOption(new ColumnOptionBto(UUID.randomUUID() + "", optionRequest.getOptionId(), optionRequest.getColumnId())) != 1) {
                throw new CustomException("存储columnOption失败！");
            }
            if (optionImpl.addOption(optionBto2) == 1) {
                return new ResponseBean(1, "保存成功", new TableEditResponse(1));
            } else {
                return new ResponseBean(0, "保存失败", new TableEditResponse(0));
            }
        } else {
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
            optionBto.setValueRange(JSONArray.toJSONString(optionRequest.getValueRange()));
            if (optionImpl.updateOption(optionBto) == 1) {
                return new ResponseBean(1, "修改成功", new TableEditResponse(1));
            } else {
                return new ResponseBean(0, "修改失败", new TableEditResponse(0));
            }
        }
    }


    /**
     * 删除一个查询条件的编辑信息
     *
     * @param optionId
     * @return
     */
    @RequestMapping(value = "/api/basic/table/deletequery", method = RequestMethod.GET)
    public ResponseBean deletequery(@ApiParam String optionId) {
        if (!StringUtils.isNotEmptyStr(optionId)) {
            throw new CustomException("optionId不能为空！");
        }
        if (optionImpl.getOptionById(optionId) != null) {
            if (optionImpl.deleteOption(optionId) != 1) {
                throw new CustomException("删除optionId失败！");
            }
            ColumnOptionBto columnOptionBto = columnOptionImpl.getColumnOptionByOptionId(optionId);
            if (columnOptionBto != null) {
                if (columnOptionImpl.deleteColumnOption(columnOptionBto.getColumnoptionId()) != 1) {
                    throw new CustomException("删除columnOption失败！");
                }
            }
        }
        return new ResponseBean(1, "保存成功", null);

    }

    /**
     * 新建一个表格数据信息
     *
     * @param tableRequest
     * @return
     */
    @RequestMapping(value = "/api/basic/table/savetable", method = RequestMethod.POST)
    public ResponseBean savetable(@RequestBody TableRequest tableRequest) {
        ValidateHelper.validateNull(tableRequest, new String[]{"menuId", "toolbar", "column"});
        if (meunImpl.getMeunById(tableRequest.getMenuId()) == null) {
            throw new CustomException("该menuId不存在！");
        }
        if (StringUtils.isNotEmptyStr(tableRequest.getTableId())) {
            throw new CustomException("tableId要为空！");
        }
        TableBto tableBto = new TableBto(UUID.randomUUID() + "", tableRequest.getMenuId(), tableRequest.getRemark());
        for (TableRequest.ColumnBean column : tableRequest.getColumn()) {
            ValidateHelper.validateNull(column, new String[]{"columnId", "columnName"});
            ColumnBto columnBto = new ColumnBto(column.getColumnId(), column.getColumnName(), column.getDataPropertyName(), column.getOrderNum(), column.getWidth(), column.getIsShow() ? 1 : 0, column.getIsCanSort() ? 1 : 0);
            if (columnImpl.getColumnById(column.getColumnId()) != null) {
                throw new CustomException("columnId已经存在！");
            }
            if (columnImpl.addColumn(columnBto) != 1) {
                throw new CustomException("存储column数据失败！");
            }
            TableColumnBto tableColumnBto = new TableColumnBto(UUID.randomUUID() + "", tableBto.getTableId(), column.getColumnId(), column.getOrderNum(), column.getWidth(), column.getIsShow() ? 1 : 0, column.getIsCanSort() ? 1 : 0);
            if (tableColumnImpl.addTableColumn(tableColumnBto) != 1) {
                throw new CustomException("存储table_column数据失败！");
            }
        }
        ToolbarBto toolbarBto = new ToolbarBto(UUID.randomUUID() + "", tableRequest.getToolbar().isChecked() ? 1 : 0, tableRequest.getRemark(), tableBto.getTableId());
        if (toolbarImpl.addToolbar(toolbarBto) != 1) {
            throw new CustomException("存储toolbar失败！");
        }
        for (TableRequest.ItemBean itemBean : tableRequest.getToolbar().getItems()) {
            ValidateHelper.validateNull(itemBean, new String[]{"itemId"});
            ItemBto itemBto = itemImpl.getItemById(itemBean.getItemId());
            if (itemBto == null) {
                throw new CustomException("该itemId不存在！");
            }
            if (itemBean.isSelect()) {//true关联
                ToolbarItemBto toolbarItemBto = new ToolbarItemBto(UUID.randomUUID() + "", toolbarBto.getToolbarId(), itemBean.getItemId());
                if (toolbarItemImpl.addToolbarItem(toolbarItemBto) != 1) {
                    throw new CustomException("存储toolbar_item失败！");
                }
            }
        }
        if (editSaveTableImpl.addTable(tableBto) == 1) {
            return new ResponseBean(1, "保存成功", new TableEditResponse(1));
        } else {
            return new ResponseBean(0, "保存失败", new TableEditResponse(0));
        }
    }

    /**
     * 修改一个表格数据信息
     *
     * @param tableRequest
     * @return
     */
    @RequestMapping(value = "/api/basic/table/revisetable", method = RequestMethod.POST)
    public ResponseBean revisetable(@RequestBody TableRequest tableRequest) {
        ValidateHelper.validateNull(tableRequest, new String[]{"menuId", "toolbar", "column"});
        if (meunImpl.getMeunById(tableRequest.getMenuId()) == null) {
            throw new CustomException("该menuId不存在！");
        }
        TableBto newTableBto = editSaveTableImpl.getTableByID(tableRequest.getTableId());
        if (newTableBto == null) {
            throw new CustomException("该tableID不存在！");
        }
        for (TableRequest.ColumnBean column : tableRequest.getColumn()) {
            ValidateHelper.validateNull(column, new String[]{"columnId", "columnName"});
            ColumnBto columnBto = new ColumnBto(column.getColumnId(), column.getColumnName(), column.getDataPropertyName(), column.getOrderNum(), column.getWidth() == 0 ? 40 : column.getWidth(), column.getIsShow() ? 1 : 0, column.getIsCanSort() ? 1 : 0);
            if (columnImpl.getColumnById(column.getColumnId()) == null) {
                if (columnImpl.addColumn(columnBto) != 1) {
                    throw new CustomException("存储column数据失败！");
                }
                TableColumnBto tableColumnBto = new TableColumnBto(UUID.randomUUID() + "", tableRequest.getTableId(), column.getColumnId(), column.getOrderNum(), column.getWidth(), column.getIsShow() ? 1 : 0, column.getIsCanSort() ? 1 : 0);
                if (tableColumnImpl.addTableColumn(tableColumnBto) != 1) {
                    throw new CustomException("存储table_column数据失败！");
                }
            } else {
                if (columnImpl.updateColumn(columnBto) != 1) {
                    throw new CustomException("修改columnId失败！");
                }
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
        List<ToolbarItemBto> toolbarItemBtoList = toolbarItemImpl.getToolbarAllItemById(toolbarBto.getToolbarId());
        for (ToolbarItemBto toolbarItemBto : toolbarItemBtoList) {
            toolbarItemImpl.deleteToolbarItem(toolbarItemBto.getToolbaritemId());
        }
        for (TableRequest.ItemBean itemBean : tableRequest.getToolbar().getItems()) {
            if (itemBean.isSelect()) {//true关联
                ToolbarItemBto toolbarItemBto = new ToolbarItemBto(UUID.randomUUID() + "", toolbarBto.getToolbarId(), itemBean.getItemId());
                if (toolbarItemImpl.addToolbarItem(toolbarItemBto) != 1) {
                    throw new CustomException("存储toolbar_item失败！");
                }
            }
        }
        TableBto tableBto = new TableBto(tableRequest.getTableId(), tableRequest.getMenuId(), tableRequest.getRemark(), newTableBto.getCreateat());
        if (editSaveTableImpl.updateTable(tableBto) == 1) {
            return new ResponseBean(1, "修改成功", new TableEditResponse(1));
        } else {
            return new ResponseBean(0, "修改失败", new TableEditResponse(0));
        }
    }

    /**
     * 删除一个表格的列信息
     *
     * @param columnId
     * @return
     */
    @RequestMapping(value = "/api/basic/table/deletecolumn", method = RequestMethod.GET)
    public ResponseBean deletecolumn(@ApiParam String columnId) {
        if (!StringUtils.isNotEmptyStr(columnId)) {
            throw new CustomException("columnId不能为空！");
        }
        if (columnImpl.getColumnById(columnId) == null) {
            throw new CustomException("columnId不存在！");
        }
        if (columnImpl.deleteColumn(columnId) != 1) {
            throw new CustomException("删除column信息失败！");
        }
        TableColumnBto tableColumnBto = tableColumnImpl.getTableColumnByColumnId(columnId);
        if (tableColumnBto == null) {
            throw new CustomException("tableColumn不存在！");
        }
        if (tableColumnImpl.deleteTableColumn(tableColumnBto.getTablecolumnId()) != 1) {
            throw new CustomException("删除tableColumn失败！");
        }
        List<ColumnOptionBto> columnOptionBtoList = columnOptionImpl.getColumnOptionAllById(columnId);
        if (columnOptionBtoList.size() > 0 || columnOptionBtoList != null) {
            for (ColumnOptionBto columnOptionBto : columnOptionBtoList) {
                if (columnOptionImpl.deleteColumnOption(columnOptionBto.getColumnoptionId()) != 1) {
                    throw new CustomException("删除columnOption失败！");
                }
                if (optionImpl.deleteOption(columnOptionBto.getFkOptionId()) != 1) {
                    throw new CustomException("删除option失败！");
                }
            }
        }
        return new ResponseBean(1, "删除成功", null);
    }

    @RequestMapping(value = "/api/basic/table/new", method = RequestMethod.GET)
    public ResponseBean news() {
        List<ItemBto> itemBtoList = itemImpl.getAllItem();
        List<ItemsResponse.itemBean> items = new ArrayList<>();
        if (itemBtoList == null || itemBtoList.size() == 0) {
            throw new CustomException("数据库未保存item值！");
        }
        for (ItemBto itemBto : itemBtoList) {
            ItemsResponse.itemBean itemBean = new ItemsResponse.itemBean(itemBto.getItemId(), itemBto.getName(), itemBto.getIcon());
            items.add(itemBean);
        }
        return new ResponseBean(1, "成功", new ItemsResponse(items));

    }

    @RequestMapping(value = "/api/basic/table/delete", method = RequestMethod.GET)
    public ResponseBean deleteTable(String tableId) {
        if (editSaveTableImpl.getTableByID(tableId) == null) {
            throw new CustomException("该tableId不存在！");
        }
        if (editSaveTableImpl.deleteTable(tableId) != 1) {
            throw new CustomException("删除表格失败！");
        }

        List<TableColumnBto> tableColumnBtoList = tableColumnImpl.getTableColumnListById(tableId);
        for (TableColumnBto tableColumnBto : tableColumnBtoList) {
            if (tableColumnImpl.deleteTableColumn(tableColumnBto.getTablecolumnId()) != 1) {
                throw new CustomException("删除table_column失败！");
            }
            if (columnImpl.deleteColumn(tableColumnBto.getFkColumnId()) != 1) {
                throw new CustomException("删除column失败！");
            }

            List<ColumnOptionBto> columnOptionBtoList = columnOptionImpl.getColumnOptionAllById(tableColumnBto.getFkColumnId());
            if (columnOptionBtoList != null && columnOptionBtoList.size() > 0) {
                for (ColumnOptionBto columnOptionBto : columnOptionBtoList) {
                    OptionBto optionBto = optionImpl.getOptionById(columnOptionBto.getFkOptionId());
                    optionImpl.deleteOption(optionBto.getOptionId());
                    columnOptionImpl.deleteColumnOptionByOptionId(optionBto.getOptionId());
                }
            }
        }
        ToolbarBto toolbarBto = toolbarImpl.getToolbarByTableId(tableId);
        toolbarImpl.deleteToolbar(toolbarBto.getToolbarId());
        List<ToolbarItemBto> toolbarItemBtos = toolbarItemImpl.getToolbarAllItemById(toolbarBto.getToolbarId());
        for (ToolbarItemBto toolbarItemBto : toolbarItemBtos) {
            toolbarItemImpl.deleteToolbarItem(toolbarItemBto.getToolbaritemId());
        }
        return new ResponseBean(1, "成功", new DeleteTableResponse(true, ""));

    }

    public StringBuffer path(MeunBto meunBto, StringBuffer path) {
        String name = meunBto.getMenudisplayname();
        path.insert(0, name + "/");
        if (StringUtils.isNotEmptyStr(meunBto.getFkMenuId())) {
            MeunBto fatherMeun = meunImpl.getMeunById(meunBto.getFkMenuId());
            if (fatherMeun == null) {
                throw new CustomException("未找到上层MenuId！");
            }
            path(meunImpl.getMeunById(meunBto.getFkMenuId()), path);
            return path;
        } else {
            return path;
        }
    }


}
