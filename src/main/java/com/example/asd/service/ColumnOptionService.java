package com.example.asd.service;

import com.example.asd.entity.ColumnOptionBto;

public interface ColumnOptionService {
    ColumnOptionBto getColumnOptionById(String columnOptionId);

    int addColumnOption(ColumnOptionBto ColumnOptionBto);

    int updateColumnOption(ColumnOptionBto ColumnOptionBto);

    int deleteColumnOption(String columnOptionId);
}
