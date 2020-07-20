package com.example.asd.dao;

import com.example.asd.entity.MeunBto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MeunBtoMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(MeunBto record);

    int insertSelective(MeunBto record);

    MeunBto selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(MeunBto record);

    int updateByPrimaryKey(MeunBto record);
}