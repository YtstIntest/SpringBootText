package com.example.asd.controller;

import com.example.asd.common.ResponseBean;
import com.example.asd.config.helper.ValidateHelper;
import com.example.asd.dto.LoginResponse;
import com.example.asd.dto.TableEditResponse;
import com.example.asd.entity.ColumnBto;
import com.example.asd.entity.OptionBto;
import com.example.asd.entity.TableBto;
import com.example.asd.exception.CustomException;
import com.example.asd.service.impl.ColumnImpl;
import com.example.asd.service.impl.EditSaveTableImpl;
import com.example.asd.service.impl.MeunImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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


    @RequestMapping(value = "/infota/table/saveTableEdite", method = RequestMethod.POST)
    public ResponseBean saveTableEditMessage(@RequestBody TableBto tableBto) {
//        ValidateHelper.validateNull(tableBto, new String[]{"isdelete","columnName", "orderNum", "width"});
//        if (meunImpl.getMeunById(tableBto.getFkMenuId()) == null) {
//            throw new CustomException("该菜单ID不存在！");
//        }
        tableBto.setCreateat(new Date());
        tableBto.setCreateby("xialiang");
        TableBto newTableBto = editSaveTableImpl.getTableByID(tableBto.getTableId());
        if (tableBto.getTableId() != null) {//修改
            if (newTableBto == null) {
                throw new CustomException("该表格ID不存在！");
            }
            if (!newTableBto.getFkMenuId().equals(tableBto.getFkMenuId())) {
                throw new CustomException("您输入的菜单ID错误！");
            }
            for(ColumnBto column:tableBto.getColumn()){
                if(columnImpl.getColumnById(column.getColumnId())==null){

                }else{

                }
            }
            if (editSaveTableImpl.updateTable(tableBto) == 1) {
                return new ResponseBean(1, "修改成功", new TableEditResponse(1));
            } else {
                return new ResponseBean(0, "修改失败", new TableEditResponse(0));
            }
        } else {//新建
            if (!newTableBto.getFkMenuId().equals(tableBto.getFkMenuId())) {
                throw new CustomException("您输入的菜单ID错误！");
            }
            tableBto.setTableId(UUID.randomUUID() + "");
            if (editSaveTableImpl.addTable(tableBto) == 1) {
                return new ResponseBean(1, "保存成功", new TableEditResponse(1));
            } else {
                return new ResponseBean(0, "保存失败", new TableEditResponse(0));
            }
        }
    }


}
