package com.example.asd.service;

import com.example.asd.entity.UserBto;

public interface UserService {
    UserBto getUserByname(String name);

    int addUser(UserBto person);

    int updateUser(UserBto person);

    boolean deleteUser(String name);
}
