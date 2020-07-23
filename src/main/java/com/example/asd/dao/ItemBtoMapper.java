package com.example.asd.dao;

import com.example.asd.entity.ItemBto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemBtoMapper {
    int deleteByPrimaryKey(String itemId);

    int insert(ItemBto record);

    int insertSelective(ItemBto record);

    List<ItemBto> selectAll();

    ItemBto selectByPrimaryKey(String itemId);

    int updateByPrimaryKeySelective(ItemBto record);

    int updateByPrimaryKey(ItemBto record);
}