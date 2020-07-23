package com.example.asd.service.impl;

import com.example.asd.dao.TableColumnBtoMapper;
import com.example.asd.entity.TableColumnBto;
import com.example.asd.service.TableColumnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TableColumnImpl implements TableColumnService {
    @Resource
    TableColumnBtoMapper  tableColumnBtoMapper;

    @Override
    public List<TableColumnBto> getTableColumnListById(String tableColumnId) {
        return tableColumnBtoMapper.selectListByPrimaryKey(tableColumnId);
    }

    @Override
    public TableColumnBto getTableColumnById(String tableColumnId) {
        return tableColumnBtoMapper.selectByPrimaryKey(tableColumnId);
    }

    @Override
    public TableColumnBto getTableColumnByColumnId(String columnId) {
        return tableColumnBtoMapper.selectByColumnId(columnId);
    }

    @Override
    public int addTableColumn(TableColumnBto tableColumnBto) {
        return tableColumnBtoMapper.insert(tableColumnBto);
    }

    @Override
    public int updateTableColumn(TableColumnBto tableColumnBto) {
        return tableColumnBtoMapper.updateByPrimaryKey(tableColumnBto);
    }

    @Override
    public int deleteTableColumn(String tableColumnId) {
        return tableColumnBtoMapper.deleteByPrimaryKey(tableColumnId);
    }
}
