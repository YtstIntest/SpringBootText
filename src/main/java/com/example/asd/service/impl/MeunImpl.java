package com.example.asd.service.impl;

import com.example.asd.dao.MeunBtoMapper;
import com.example.asd.entity.MeunBto;
import com.example.asd.service.MeunService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MeunImpl implements MeunService {

    @Resource
    MeunBtoMapper meunBtoMapper;

    @Override
    public MeunBto getMeunById(String menuId) {
        return meunBtoMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public List<MeunBto> getMeun() {
        return meunBtoMapper.selectAll();
    }

    @Override
    public int addMeun(MeunBto meunBto) {
        return meunBtoMapper.insert(meunBto);
    }

    @Override
    public int updateMeun(MeunBto meunBto) {
        return meunBtoMapper.updateByPrimaryKey(meunBto);
    }

    @Override
    public int deleteMeun(String menuId) {
        return meunBtoMapper.deleteByPrimaryKey(menuId);
    }
}
