package com.example.asd.controller;

import com.example.asd.common.ResponseBean;
import com.example.asd.config.helper.ValidateHelper;
import com.example.asd.dto.LoginResponse;
import com.example.asd.dto.TableEditResponse;
import com.example.asd.entity.*;
import com.example.asd.entity.base.TableRequest;
import com.example.asd.exception.CustomException;
import com.example.asd.service.impl.*;
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


    @RequestMapping(value = "/infota/table/saveTableEdite", method = RequestMethod.POST)
    public ResponseBean saveTableEditMessage(@RequestBody TableRequest tableRequest) {

//        ValidateHelper.validateNull(tableBto, new String[]{"isdelete","columnName", "orderNum", "width"});
//        if (meunImpl.getMeunById(tableBto.getFkMenuId()) == null) {
//            throw new CustomException("该菜单ID不存在！");
//        }
        if (tableRequest.getTableId() != null) {//修改
            TableBto newTableBto = editSaveTableImpl.getTableByID(tableRequest.getTableId());
            if (newTableBto == null) {
                throw new CustomException("该表格ID不存在！");
            }
            if (!newTableBto.getFkMenuId().equals(tableRequest.getMenuId())) {
                throw new CustomException("您输入的菜单ID错误！");
            }
            for (TableRequest.ColumnBean column : tableRequest.getColumn()) {
                if (columnImpl.getColumnById(column.getColumnId()) != null) {
                    ColumnBto columnBto = new ColumnBto(column.getColumnId(), column.getColumnName(), column.getOrderNum(), column.getWidth(), column.getChecked(), column.getIsCanSort());
                    if (columnImpl.updateColumn(columnBto) == 1) {
                        for (TableRequest.OptionBean optionBean : column.getOption()) {
                            if (optionImpl.getOptionById(optionBean.getOptionId()) != null) {
                                OptionBto optionBto = new OptionBto(optionBean.getOptionId(), optionBean.getKind(), optionBean.getDateType(), optionBean.getMaxLength(), optionBean.getMinLength(), optionBean.getMaxNum(), optionBean.getMinNum(), optionBean.getRegularText(), optionBean.getDateFormat(), optionBean.getQueryFields(), optionBean.getListoffilter(), optionBean.getValue(), optionBean.getText(), optionBean.getDateField(), optionBean.getDateSourceKind(), optionBean.getValueRange());
                                if (optionImpl.updateOption(optionBto) != 1) {
                                    throw new CustomException("修改列参数失败！");
                                }
                            } else {
                                throw new CustomException("您输入的列参数ID不存在！");
                            }
                        }
                    } else {
                        throw new CustomException("修改列ID失败！");
                    }
                } else {
                    throw new CustomException("您输入的列ID不存在！");
                }
            }
//            ToolbarBto toolbarBto = toolbarImpl.getToolbarByTableId(tableRequest.getTableId());
//            if (toolbarBto != null) {
//                toolbarBto.setCharecked(tableRequest.getToolbar().isChecked());
//                if (toolbarImpl.updateToolbar(toolbarBto) != 1) {
//                    throw new CustomException("修改列toolbar失败！");
//                }
//            } else {
//                throw new CustomException("您输入toolbar不存在！");
//            }

//            for (TableRequest.ItemBean itemBean : tableRequest.getToolbar().getItems()) {
//
//            }

            return new ResponseBean(1, "修改成功", new TableEditResponse(1));
//            if (editSaveTableImpl.updateTable(tableBto) == 1) {
//                return new ResponseBean(1, "修改成功", new TableEditResponse(1));
//            } else {
//                return new ResponseBean(0, "修改失败", new TableEditResponse(0));
//            }
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
                    OptionBto optionBto = new OptionBto(optionBean.getOptionId(), optionBean.getKind(), optionBean.getDateType(), optionBean.getMaxLength(), optionBean.getMinLength(), optionBean.getMaxNum(), optionBean.getMinNum(), optionBean.getRegularText(), optionBean.getDateFormat(), optionBean.getQueryFields(), optionBean.getListoffilter(), optionBean.getValue(), optionBean.getText(), optionBean.getDateField(), optionBean.getDateSourceKind(), optionBean.getValueRange());
                    if (optionImpl.addOption(optionBto) != 1) {
                        throw new CustomException("存储参数列数据失败！");
                    }
                    ColumnOptionBto columnOptionBto = new ColumnOptionBto(UUID.randomUUID() + "", optionBean.getOptionId(), column.getColumnId());
                    if (columnOptionImpl.addColumnOption(columnOptionBto) != 1) {
                        throw new CustomException("存储列与参数选项关联数据失败！");
                    }
                }
            }
            ToolbarBto toolbarBto = new ToolbarBto(UUID.randomUUID() + "", tableRequest.getToolbar().isChecked(), tableRequest.getRemark(), tableBto.getTableId());
            if (toolbarImpl.addToolbar(toolbarBto) != 1) {
                throw new CustomException("存储toolbar失败！");
            }

            if (editSaveTableImpl.addTable(tableBto) == 1) {
                return new ResponseBean(1, "保存成功", new TableEditResponse(1));
            } else {
                return new ResponseBean(0, "保存失败", new TableEditResponse(0));
            }
        }
    }


}
