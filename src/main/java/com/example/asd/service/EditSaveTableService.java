package com.example.asd.service;

import com.example.asd.entity.TableBto;

public interface EditSaveTableService {
    TableBto getTableByID(String tableID);

    int addTable(TableBto tableBto);

    int updateTable(TableBto tableBto);

    int deleteTable(String tableID);
}
