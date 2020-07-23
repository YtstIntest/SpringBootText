package com.example.asd.dao;

import com.example.asd.entity.ColumnOptionBto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ColumnOptionBtoMapper {
    int deleteByPrimaryKey(String columnoptionId);

    int insert(ColumnOptionBto record);

    int insertSelective(ColumnOptionBto record);

    List<ColumnOptionBto> selectAllByPrimaryKey(String columnoptionId);

    ColumnOptionBto selectByPrimaryKey(String columnoptionId);

    int updateByPrimaryKeySelective(ColumnOptionBto record);

    int updateByPrimaryKey(ColumnOptionBto record);
}