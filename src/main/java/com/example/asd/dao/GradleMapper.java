package com.example.asd.dao;

import com.example.asd.entity.Gradle;

public interface GradleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gradle record);

    int insertSelective(Gradle record);

    Gradle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gradle record);

    int updateByPrimaryKey(Gradle record);
}