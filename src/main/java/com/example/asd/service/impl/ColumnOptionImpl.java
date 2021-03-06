package com.example.asd.service.impl;

import com.example.asd.dao.ColumnOptionBtoMapper;
import com.example.asd.entity.ColumnOptionBto;
import com.example.asd.service.ColumnOptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ColumnOptionImpl implements ColumnOptionService {
    @Resource
    ColumnOptionBtoMapper columnOptionBtoMapper;

    @Override
    public List<ColumnOptionBto> getColumnOptionAllById(String columnId) {
        return columnOptionBtoMapper.selectAllByPrimaryKey(columnId);
    }

    @Override
    public ColumnOptionBto getColumnOptionById(String columnOptionId) {
        return columnOptionBtoMapper.selectByPrimaryKey(columnOptionId);
    }

    @Override
    public ColumnOptionBto getColumnOptionByOptionId(String optionId) {
        return columnOptionBtoMapper.selectByOptionId(optionId);
    }

    @Override
    public int addColumnOption(ColumnOptionBto columnOptionBto) {
        return columnOptionBtoMapper.insert(columnOptionBto);
    }

    @Override
    public int updateColumnOption(ColumnOptionBto columnOptionBto) {
        return columnOptionBtoMapper.updateByPrimaryKey(columnOptionBto);
    }

    @Override
    public int deleteColumnOption(String columnOptionId) {
        return columnOptionBtoMapper.deleteByPrimaryKey(columnOptionId);
    }

    @Override
    public int deleteColumnOptionByOptionId(String optionId) {
        return columnOptionBtoMapper.deleteByOptionId(optionId);
    }
}
