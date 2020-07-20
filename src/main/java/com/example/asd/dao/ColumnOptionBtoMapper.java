package com.example.asd.dao;

import com.example.asd.entity.ColumnOptionBto;

public interface ColumnOptionBtoMapper {
    int deleteByPrimaryKey(String columnoptionId);

    int insert(ColumnOptionBto record);

    int insertSelective(ColumnOptionBto record);

    ColumnOptionBto selectByPrimaryKey(String columnoptionId);

    int updateByPrimaryKeySelective(ColumnOptionBto record);

    int updateByPrimaryKey(ColumnOptionBto record);
}