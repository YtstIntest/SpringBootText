package com.example.asd.controller;

import com.example.asd.common.ResponseBean;
import com.example.asd.config.helper.ValidateHelper;
import com.example.asd.dto.LoginResponse;
import com.example.asd.dto.TableEditResponse;
import com.example.asd.entity.*;
import com.example.asd.entity.base.TableRequest;
import com.example.asd.exception.CustomException;
import com.example.asd.service.impl.*;
import com.example.asd.util.common.StringUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(value = "/infota/table/saveTableEdite", method = RequestMethod.POST)
    public ResponseBean saveTableEditMessage(@RequestBody TableRequest tableRequest) {
        ValidateHelper.validateNull(tableRequest, new String[]{"menuId", "toolbar", "column"});
        if (meunImpl.getMeunById(tableRequest.getMenuId()) == null) {
            throw new CustomException("该菜单ID不存在！");
        }
        if (StringUtils.isNotEmptyStr(tableRequest.getTableId())) {//修改
            TableBto newTableBto = editSaveTableImpl.getTableByID(tableRequest.getTableId());
            if (newTableBto == null) {
                throw new CustomException("该表格ID不存在！");
            }
            if (!newTableBto.getFkMenuId().equals(tableRequest.getMenuId())) {
                throw new CustomException("您输入的菜单ID错误！");
            }
            for (TableRequest.ColumnBean column : tableRequest.getColumn()) {
                if (columnImpl.getColumnById(column.getColumnId()) == null) {
                    throw new CustomException("您输入的列ID不存在！");
                }
                ColumnBto columnBto = new ColumnBto(column.getColumnId(), column.getColumnName(), column.getOrderNum(), column.getWidth(), column.getChecked(), column.getIsCanSort());
                if (columnImpl.updateColumn(columnBto) != 1) {
                    throw new CustomException("修改列ID失败！");
                }
                for (TableRequest.OptionBean optionBean : column.getOption()) {
                    if (optionImpl.getOptionById(optionBean.getOptionId()) == null) {
                        throw new CustomException("您输入的列参数ID不存在！");
                    }
                    OptionBto optionBto = new OptionBto(optionBean.getOptionId(), optionBean.getKind(), optionBean.getDateType(), optionBean.getMaxLength(), optionBean.getMinLength(), optionBean.getMaxNum(), optionBean.getMinNum(), optionBean.getRegularText(), optionBean.getDateFormat(), optionBean.getQueryFields(), optionBean.getListoffilter(), optionBean.getValue(), optionBean.getText(), optionBean.getDateSourceKind(), optionBean.getValueRange(), optionBean.getFieldText());
                    if (optionImpl.updateOption(optionBto) != 1) {
                        throw new CustomException("修改列参数失败！");
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

            for (TableRequest.ItemBean itemBean : tableRequest.getToolbar().getItems()) {
                if (itemBean.isSelect()) {
                    ToolbarItemBto toolbarItemBto = new ToolbarItemBto(UUID.randomUUID() + "", toolbarBto.getToolbarId(), itemBean.getItemId());
                    if (toolbarItemImpl.addToolbarItem(toolbarItemBto) != 1) {
                        throw new CustomException("表格工具栏与子项关联失败！");
                    }
                } else {
                    ToolbarItemBto toolbarItemBto = toolbarItemImpl.getToolbarItemById(itemBean.getItemId());
                    toolbarItemImpl.deleteToolbarItem(toolbarItemBto.getToolbaritemId());
                    if (toolbarItemImpl.deleteToolbarItem(toolbarItemBto.getToolbaritemId()) != 1) {
                        throw new CustomException("取消表格工具栏与子项关联失败！");
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
                throw new CustomException("您输入的菜单ID不存在！");
            }
            TableBto tableBto = new TableBto(UUID.randomUUID() + "", tableRequest.getMenuId(), tableRequest.getRemark());
            for (TableRequest.ColumnBean column : tableRequest.getColumn()) {
                ColumnBto columnBto = new ColumnBto(column.getColumnId(), column.getColumnName(), column.getOrderNum(), column.getWidth(), column.getChecked(), column.getIsCanSort());
                if (columnImpl.addColumn(columnBto) != 1) {
                    throw new CustomException("存储列数据失败！");
                }
                for (TableRequest.OptionBean optionBean : column.getOption()) {
                    OptionBto optionBto = new OptionBto(optionBean.getOptionId(), optionBean.getKind(), optionBean.getDateType(), optionBean.getMaxLength(), optionBean.getMinLength(), optionBean.getMaxNum(), optionBean.getMinNum(), optionBean.getRegularText(), optionBean.getDateFormat(), optionBean.getQueryFields(), optionBean.getListoffilter(), optionBean.getValue(), optionBean.getText(), optionBean.getDateSourceKind(), optionBean.getValueRange(), optionBean.getFieldText());
                    if (optionImpl.addOption(optionBto) != 1) {
                        throw new CustomException("存储参数列数据失败！");
                    }
                    ColumnOptionBto columnOptionBto = new ColumnOptionBto(UUID.randomUUID() + "", optionBean.getOptionId(), column.getColumnId());
                    if (columnOptionImpl.addColumnOption(columnOptionBto) != 1) {
                        throw new CustomException("存储列与参数选项关联数据失败！");
                    }
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
                        throw new CustomException("存储工具栏失败！");
                    }
                    ToolbarItemBto toolbarItemBto = new ToolbarItemBto(UUID.randomUUID() + "", toolbarBto.getToolbarId(), itemBean.getItemId());
                    if (toolbarItemImpl.addToolbarItem(toolbarItemBto) != 1) {
                        throw new CustomException("表格工具栏与子项关联失败！");
                    }

                } else {//不关联
                    ItemBto itemBto = new ItemBto(itemBean.getItemId());
                    if (itemImpl.addItem(itemBto) != 1) {
                        throw new CustomException("存储工具栏失败！");
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
