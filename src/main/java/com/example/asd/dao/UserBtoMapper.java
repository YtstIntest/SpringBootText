package com.example.asd.dao;

import com.example.asd.entity.UserBto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBtoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserBto record);

    int insertSelective(UserBto record);

    UserBto selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserBto record);

    int updateByPrimaryKey(UserBto record);

    UserBto selectByName(String name);

}