package com.example.asd.dao;

import com.example.asd.entity.OptionBto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionBtoMapper {
    int deleteByPrimaryKey(String optionId);

    int insert(OptionBto record);

    int insertSelective(OptionBto record);

    OptionBto selectByPrimaryKey(String optionId);

    int updateByPrimaryKeySelective(OptionBto record);

    int updateByPrimaryKey(OptionBto record);
}