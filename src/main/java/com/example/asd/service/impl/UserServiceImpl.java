package com.example.asd.service.impl;

import com.example.asd.dao.UserBtoMapper;
import com.example.asd.entity.UserBto;
import com.example.asd.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserBtoMapper userBtoMapper;

    @Override
    public UserBto getUserByname(String name) {
        return userBtoMapper.selectByName(name);
    }

    @Override
    public int addUser(UserBto userBto) {
        return userBtoMapper.insert(userBto);
    }

    @Override
    public int updateUser(UserBto userBto) {
        return userBtoMapper.updateByPrimaryKey(userBto);
    }

    @Override
    public boolean deleteUser(String name) {
        return false;
    }
}
