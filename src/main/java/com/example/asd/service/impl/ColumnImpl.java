package com.example.asd.service.impl;

import com.example.asd.dao.ColumnBtoMapper;
import com.example.asd.entity.ColumnBto;
import com.example.asd.service.ColumnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ColumnImpl implements ColumnService {

    @Resource
    ColumnBtoMapper columnBtoMapper;

    @Override
    public ColumnBto getColumnById(String columnId) {
        return columnBtoMapper.selectByPrimaryKey(columnId);
    }

    @Override
    public int addColumn(ColumnBto ColumnBto) {
        return columnBtoMapper.insert(ColumnBto);
    }

    @Override
    public int updateColumn(ColumnBto ColumnBto) {
        return columnBtoMapper.updateByPrimaryKey(ColumnBto);
    }

    @Override
    public int deleteColumn(String columnId) {
        return columnBtoMapper.deleteByPrimaryKey(columnId);
    }
}
