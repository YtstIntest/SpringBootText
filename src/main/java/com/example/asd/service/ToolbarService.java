package com.example.asd.service;

import com.example.asd.entity.ToolbarBto;

import java.util.List;

public interface ToolbarService {
    ToolbarBto getToolbarById(String toolbarId);

    ToolbarBto getToolbarByTableId(String tableId);

    List<ToolbarBto> getToolbarList();

    int addToolbar(ToolbarBto ToolbarBto);

    int updateToolbar(ToolbarBto ToolbarBto);

    int deleteToolbar(String toolbarId);
}
