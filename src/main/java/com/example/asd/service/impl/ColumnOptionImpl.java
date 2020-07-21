package com.example.asd.service.impl;

import com.example.asd.dao.ColumnOptionBtoMapper;
import com.example.asd.entity.ColumnOptionBto;
import com.example.asd.service.ColumnOptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ColumnOptionImpl implements ColumnOptionService {
    @Resource
    ColumnOptionBtoMapper columnOptionBtoMapper;
    @Override
    public ColumnOptionBto getColumnOptionById(String columnOptionId) {
        return columnOptionBtoMapper.selectByPrimaryKey(columnOptionId);
    }

    @Override
    public int addColumnOption(ColumnOptionBto ColumnOptionBto) {
        return columnOptionBtoMapper.insert(ColumnOptionBto);
    }

    @Override
    public int updateColumnOption(ColumnOptionBto ColumnOptionBto) {
        return columnOptionBtoMapper.updateByPrimaryKey(ColumnOptionBto);
    }

    @Override
    public int deleteColumnOption(String columnOptionId) {
        return columnOptionBtoMapper.deleteByPrimaryKey(columnOptionId);
    }
}
