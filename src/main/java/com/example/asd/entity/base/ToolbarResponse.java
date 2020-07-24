package com.example.asd.entity.base;

import java.util.List;

public class ToolbarResponse {
    private List<ToolbarItem> toolbar;
    private List<StyleItem> style;
    private List<ToolbarItem> subItem;

    public ToolbarResponse() {
    }

    public ToolbarResponse(List<ToolbarItem> toolbar, List<StyleItem> style, List<ToolbarItem> subItem) {
        this.toolbar = toolbar;
        this.style = style;
        this.subItem = subItem;
    }

    public List<ToolbarItem> getToolbar() {
        return toolbar;
    }

    public void setToolbar(List<ToolbarItem> toolbar) {
        this.toolbar = toolbar;
    }

    public List<StyleItem> getStyle() {
        return style;
    }

    public void setStyle(List<StyleItem> style) {
        this.style = style;
    }

    public List<ToolbarItem> getSubItem() {
        return subItem;
    }

    public void setSubItem(List<ToolbarItem> subItem) {
        this.subItem = subItem;
    }

    public static class ToolbarItem {
        private String toolId="";
        private String name="";
        private String icon="";


        public ToolbarItem() {
        }

        public ToolbarItem(String toolId, String name, String icon) {
            this.toolId = toolId;
            this.name = name;
            this.icon = icon;
        }

        public String getToolId() {
            return toolId;
        }

        public void setToolId(String toolId) {
            this.toolId = toolId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class StyleItem {
        private boolean checked;

        public StyleItem() {
        }

        public StyleItem(boolean checked) {
            this.checked = checked;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }
    }
}
