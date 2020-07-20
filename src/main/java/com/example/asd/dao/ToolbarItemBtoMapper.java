package com.example.asd.dao;

import com.example.asd.entity.ToolbarItemBto;

public interface ToolbarItemBtoMapper {
    int deleteByPrimaryKey(String toolbaritemId);

    int insert(ToolbarItemBto record);

    int insertSelective(ToolbarItemBto record);

    ToolbarItemBto selectByPrimaryKey(String toolbaritemId);

    int updateByPrimaryKeySelective(ToolbarItemBto record);

    int updateByPrimaryKey(ToolbarItemBto record);
}