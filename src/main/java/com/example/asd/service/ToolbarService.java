package com.example.asd.service;

import com.example.asd.entity.ToolbarBto;

public interface ToolbarService {
    ToolbarBto getToolbarById(String toolbarId);

    ToolbarBto getToolbarByTableId(String tableId);

    int addToolbar(ToolbarBto ToolbarBto);

    int updateToolbar(ToolbarBto ToolbarBto);

    int deleteToolbar(String toolbarId);
}
