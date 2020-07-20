package com.example.asd.service.impl;

import com.example.asd.dao.TableBtoMapper;
import com.example.asd.entity.TableBto;
import com.example.asd.service.EditSaveTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EditSaveTableImpl implements EditSaveTableService {

    @Resource
    TableBtoMapper tableBtoMapper;

    @Override
    public TableBto getTableByID(String tableID) {
        return tableBtoMapper.selectByPrimaryKey(tableID);
    }

    @Override
    public int addTable(TableBto tableBto) {
        return tableBtoMapper.insert(tableBto);
    }

    @Override
    public int updateTable(TableBto tableBto) {
        return tableBtoMapper.updateByPrimaryKey(tableBto);
    }

    @Override
    public int deleteTable(String tableID) {
        return tableBtoMapper.deleteByPrimaryKey(tableID);
    }
}
