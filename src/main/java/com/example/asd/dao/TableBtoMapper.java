package com.example.asd.dao;

import com.example.asd.entity.TableBto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TableBtoMapper {
    int deleteByPrimaryKey(String tableId);

    int insert(TableBto record);

    int insertSelective(TableBto record);

    TableBto selectByPrimaryKey(String tableId);

    int updateByPrimaryKeySelective(TableBto record);

    int updateByPrimaryKey(TableBto record);
}