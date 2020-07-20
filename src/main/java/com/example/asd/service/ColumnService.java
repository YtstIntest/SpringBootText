package com.example.asd.service;

import com.example.asd.entity.ColumnBto;

public interface ColumnService {
    ColumnBto getColumnById(String columnId);

    int addColumn(ColumnBto ColumnBto);

    int updateColumn(ColumnBto ColumnBto);

    int deleteColumn(String columnId);
}
