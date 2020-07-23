package com.example.asd.service;

import com.example.asd.entity.MeunBto;
import com.example.asd.entity.UserBto;

import java.util.List;

public interface MeunService {
    MeunBto getMeunById(String menuId);

    List<MeunBto> getMeun();

    int addMeun(MeunBto meunBto);

    int updateMeun(MeunBto meunBto);

    int deleteMeun(String menuId);
}
