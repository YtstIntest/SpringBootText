package com.example.asd.service.impl;

import com.example.asd.dao.ToolbarItemBtoMapper;
import com.example.asd.entity.ToolbarItemBto;
import com.example.asd.service.ToolbarItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ToolbarItemImpl implements ToolbarItemService {
    @Resource
    ToolbarItemBtoMapper toolbarItemBtoMapper;

    @Override
    public List<ToolbarItemBto> getToolbarAllItemById(String toolbarId) {
        return toolbarItemBtoMapper.selectAllByPrimaryKey(toolbarId);
    }

    @Override
    public ToolbarItemBto getToolbarItemById(String toolbarItemBtoId) {
        return toolbarItemBtoMapper.selectByPrimaryKey(toolbarItemBtoId);
    }

    @Override
    public ToolbarItemBto getToolbarItemByItemId(String ItemId) {
        return toolbarItemBtoMapper.selectByItemId(ItemId);
    }

    @Override
    public int addToolbarItem(ToolbarItemBto toolbarItemBto) {
        return toolbarItemBtoMapper.insert(toolbarItemBto);
    }

    @Override
    public int updateToolbarItem(ToolbarItemBto toolbarItemBto) {
        return toolbarItemBtoMapper.updateByPrimaryKey(toolbarItemBto);
    }

    @Override
    public int deleteToolbarItem(String toolbarItemBtoId) {
        return toolbarItemBtoMapper.deleteByPrimaryKey(toolbarItemBtoId);
    }
}
