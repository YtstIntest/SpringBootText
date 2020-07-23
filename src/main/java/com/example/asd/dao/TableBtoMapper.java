package com.example.asd.dao;

import com.example.asd.entity.TableBto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TableBtoMapper {
    int deleteByPrimaryKey(String tableId);

    int insert(TableBto record);

    int insertSelective(TableBto record);

    TableBto selectByPrimaryKey(String tableId);

    List<TableBto> selectByMenuId(String menuId);

    List<TableBto> getAllTable();

    int updateByPrimaryKeySelective(TableBto record);

    int updateByPrimaryKey(TableBto record);
}