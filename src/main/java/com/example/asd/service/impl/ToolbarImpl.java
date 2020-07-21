package com.example.asd.service.impl;

import com.example.asd.dao.ToolbarBtoMapper;
import com.example.asd.entity.ToolbarBto;
import com.example.asd.service.ToolbarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ToolbarImpl implements ToolbarService {
    @Resource
    ToolbarBtoMapper toolbarBtoMapper;
    @Override
    public ToolbarBto getToolbarById(String toolbarId) {
        return toolbarBtoMapper.selectByPrimaryKey(toolbarId);
    }

    @Override
    public ToolbarBto getToolbarByTableId(String tableId) {
        return toolbarBtoMapper.selectByTableId(tableId);
    }

    @Override
    public int addToolbar(ToolbarBto toolbarBto) {
        return toolbarBtoMapper.insert(toolbarBto);
    }

    @Override
    public int updateToolbar(ToolbarBto toolbarBto) {
        return toolbarBtoMapper.updateByPrimaryKey(toolbarBto);
    }

    @Override
    public int deleteToolbar(String toolbarId) {
        return toolbarBtoMapper.deleteByPrimaryKey(toolbarId);
    }
}
