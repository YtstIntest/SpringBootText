package com.example.asd.dao;

import com.example.asd.entity.ItemBto;

public interface ItemBtoMapper {
    int deleteByPrimaryKey(String itemId);

    int insert(ItemBto record);

    int insertSelective(ItemBto record);

    ItemBto selectByPrimaryKey(String itemId);

    int updateByPrimaryKeySelective(ItemBto record);

    int updateByPrimaryKey(ItemBto record);
}