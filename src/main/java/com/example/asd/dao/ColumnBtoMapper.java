package com.example.asd.dao;

import com.example.asd.entity.ColumnBto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ColumnBtoMapper {
    int deleteByPrimaryKey(String columnId);

    int insert(ColumnBto record);

    int insertSelective(ColumnBto record);

    ColumnBto selectByPrimaryKey(String columnId);

    int updateByPrimaryKeySelective(ColumnBto record);

    int updateByPrimaryKey(ColumnBto record);
}