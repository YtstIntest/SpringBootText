package com.example.asd.service;

import com.example.asd.entity.MeunBto;
import com.example.asd.entity.UserBto;

public interface MeunService {
    MeunBto getMeunById(String menuId);

    int addMeun(MeunBto meunBto);

    int updateMeun(MeunBto meunBto);

    int deleteMeun(String menuId);
}
