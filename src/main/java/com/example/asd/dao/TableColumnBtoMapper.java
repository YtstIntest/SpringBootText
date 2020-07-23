package com.example.asd.dao;

import com.example.asd.entity.TableColumnBto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TableColumnBtoMapper {
    int deleteByPrimaryKey(String tablecolumnId);

    int insert(TableColumnBto record);

    int insertSelective(TableColumnBto record);

    List<TableColumnBto> selectListByPrimaryKey(String tableId);

    TableColumnBto selectByPrimaryKey(String tablecolumnId);

    TableColumnBto selectByColumnId(String columnId);

    int updateByPrimaryKeySelective(TableColumnBto record);

    int updateByPrimaryKey(TableColumnBto record);
}