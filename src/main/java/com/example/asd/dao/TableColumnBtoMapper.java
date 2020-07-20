package com.example.asd.dao;

import com.example.asd.entity.TableColumnBto;

public interface TableColumnBtoMapper {
    int deleteByPrimaryKey(String tablecolumnId);

    int insert(TableColumnBto record);

    int insertSelective(TableColumnBto record);

    TableColumnBto selectByPrimaryKey(String tablecolumnId);

    int updateByPrimaryKeySelective(TableColumnBto record);

    int updateByPrimaryKey(TableColumnBto record);
}