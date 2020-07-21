package com.example.asd.service;

import com.example.asd.entity.OptionBto;

public interface OptionService {
    OptionBto getOptionById(String optionId);

    int addOption(OptionBto OptionBto);

    int updateOption(OptionBto OptionBto);

    int deleteOption(String optionId);
}
