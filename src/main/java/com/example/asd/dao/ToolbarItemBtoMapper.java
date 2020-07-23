package com.example.asd.dao;

import com.example.asd.entity.ToolbarItemBto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToolbarItemBtoMapper {
    int deleteByPrimaryKey(String toolbaritemId);

    int insert(ToolbarItemBto record);

    int insertSelective(ToolbarItemBto record);

    List<ToolbarItemBto> selectAllByPrimaryKey(String toolbarId);

    ToolbarItemBto selectByPrimaryKey(String toolbaritemId);

    ToolbarItemBto selectByItemId(String itemId);

    int updateByPrimaryKeySelective(ToolbarItemBto record);

    int updateByPrimaryKey(ToolbarItemBto record);
}