package com.example.asd.service;

import com.example.asd.entity.MeunBto;
import com.example.asd.entity.ToolbarItemBto;

import java.util.List;

public interface ToolbarItemService {
    List<ToolbarItemBto> getToolbarAllItemById(String toolbarId);

    ToolbarItemBto getToolbarItemById(String toolbarItemBtoId);

    ToolbarItemBto getToolbarItemByItemId(String ItemId);

    int addToolbarItem(ToolbarItemBto toolbarItemBto);

    int updateToolbarItem(ToolbarItemBto toolbarItemBto);

    int deleteToolbarItem(String toolbarItemBtoId);
}
