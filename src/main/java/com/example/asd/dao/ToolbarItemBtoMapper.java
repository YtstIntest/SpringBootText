package com.example.asd.dao;

import com.example.asd.entity.ToolbarItemBto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToolbarItemBtoMapper {
    int deleteByPrimaryKey(String toolbaritemId);

    int insert(ToolbarItemBto record);

    int insertSelective(ToolbarItemBto record);

    ToolbarItemBto selectByPrimaryKey(String toolbaritemId);

    ToolbarItemBto selectByItemId(String itemId);

    int updateByPrimaryKeySelective(ToolbarItemBto record);

    int updateByPrimaryKey(ToolbarItemBto record);
}