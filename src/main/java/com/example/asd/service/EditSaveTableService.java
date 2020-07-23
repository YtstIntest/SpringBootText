package com.example.asd.service;

import com.example.asd.entity.TableBto;

import java.util.List;

public interface EditSaveTableService {
    TableBto getTableByID(String tableID);

    List<TableBto> getTableByMenuId(String menuId);

    List<TableBto> getAllTable();

    int addTable(TableBto tableBto);

    int updateTable(TableBto tableBto);

    int deleteTable(String tableID);
}
