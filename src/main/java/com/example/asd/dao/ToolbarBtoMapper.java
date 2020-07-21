package com.example.asd.dao;

import com.example.asd.entity.ToolbarBto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToolbarBtoMapper {
    int deleteByPrimaryKey(String toolbarId);

    int insert(ToolbarBto record);

    int insertSelective(ToolbarBto record);

    ToolbarBto selectByPrimaryKey(String toolbarId);

    ToolbarBto selectByTableId(String tableId);

    int updateByPrimaryKeySelective(ToolbarBto record);

    int updateByPrimaryKey(ToolbarBto record);
}