package com.example.asd.service;

import com.example.asd.entity.TableColumnBto;

import java.util.List;

public interface TableColumnService {
    List<TableColumnBto> getTableColumnListById(String tableColumnId);

    TableColumnBto getTableColumnById(String tableColumnId);

    TableColumnBto getTableColumnByColumnId(String columnId);

    int addTableColumn(TableColumnBto tableColumnBto);

    int updateTableColumn(TableColumnBto tableColumnBto);

    int deleteTableColumn(String tableColumnId);
}
