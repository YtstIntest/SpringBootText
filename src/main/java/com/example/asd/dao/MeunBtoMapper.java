package com.example.asd.dao;

import com.example.asd.entity.MeunBto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeunBtoMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(MeunBto record);

    int insertSelective(MeunBto record);

    MeunBto selectByPrimaryKey(String menuId);

    List<MeunBto> selectAll();

    int updateByPrimaryKeySelective(MeunBto record);

    int updateByPrimaryKey(MeunBto record);
}