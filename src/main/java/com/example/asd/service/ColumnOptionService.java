package com.example.asd.service;

import com.example.asd.entity.ColumnOptionBto;

import java.util.List;

public interface ColumnOptionService {
    List<ColumnOptionBto> getColumnOptionAllById(String columnOptionId);

    ColumnOptionBto getColumnOptionById(String columnOptionId);

    ColumnOptionBto getColumnOptionByOptionId(String optionId);


    int addColumnOption(ColumnOptionBto ColumnOptionBto);

    int updateColumnOption(ColumnOptionBto ColumnOptionBto);

    int deleteColumnOption(String columnOptionId);

    int deleteColumnOptionByOptionId(String optionId);
}
