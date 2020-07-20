package com.example.asd.dao;

import com.example.asd.entity.OptionBto;

public interface OptionBtoMapper {
    int deleteByPrimaryKey(String optionId);

    int insert(OptionBto record);

    int insertSelective(OptionBto record);

    OptionBto selectByPrimaryKey(String optionId);

    int updateByPrimaryKeySelective(OptionBto record);

    int updateByPrimaryKey(OptionBto record);
}