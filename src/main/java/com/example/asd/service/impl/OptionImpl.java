package com.example.asd.service.impl;

import com.example.asd.dao.OptionBtoMapper;
import com.example.asd.entity.OptionBto;
import com.example.asd.service.OptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OptionImpl implements OptionService {
    @Resource
    OptionBtoMapper optionBtoMapper;
    @Override
    public OptionBto getOptionById(String optionId) {
        return optionBtoMapper.selectByPrimaryKey(optionId);
    }

    @Override
    public int addOption(OptionBto OptionBto) {
        return optionBtoMapper.insert(OptionBto);
    }

    @Override
    public int updateOption(OptionBto OptionBto) {
        return optionBtoMapper.updateByPrimaryKey(OptionBto);
    }

    @Override
    public int deleteOption(String optionId) {
        return optionBtoMapper.deleteByPrimaryKey(optionId);
    }
}
