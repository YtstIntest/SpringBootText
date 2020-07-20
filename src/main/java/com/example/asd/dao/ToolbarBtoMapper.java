package com.example.asd.dao;

import com.example.asd.entity.ToolbarBto;

public interface ToolbarBtoMapper {
    int deleteByPrimaryKey(String toolbarId);

    int insert(ToolbarBto record);

    int insertSelective(ToolbarBto record);

    ToolbarBto selectByPrimaryKey(String toolbarId);

    int updateByPrimaryKeySelective(ToolbarBto record);

    int updateByPrimaryKey(ToolbarBto record);
}