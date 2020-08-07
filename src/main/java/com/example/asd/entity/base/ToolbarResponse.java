package com.example.asd.entity.base;

import java.util.List;

public class ToolbarResponse {
    private String toolId;
    private boolean checked;
    private List<ItemBean> items;

    public ToolbarResponse() {
    }

    public ToolbarResponse(String toolId, boolean checked, List<ItemBean> items) {
        this.toolId = toolId;
        this.checked = checked;
        this.items = items;
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<ItemBean> getItems() {
        return items;
    }

    public void setItems(List<ItemBean> items) {
        this.items = items;
    }

    public static class ItemBean {
        private String itemId;
        private String name;
        private String icon;
        private List<SubItemBean> subItem;

        public ItemBean() {
        }

        public ItemBean(String itemId, String name, String icon) {
            this.itemId = itemId;
            this.name = name;
            this.icon = icon;
        }

        public ItemBean(String itemId, String name, String icon, List<SubItemBean> subItem) {
            this.itemId = itemId;
            this.name = name;
            this.icon = icon;
            this.subItem = subItem;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
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

        public List<SubItemBean> getSubItem() {
            return subItem;
        }

        public void setSubItem(List<SubItemBean> subItem) {
            this.subItem = subItem;
        }
    }

    public static class SubItemBean {
        private String itemId;
        private String name;
        private String icon;

        public SubItemBean(String itemId, String name, String icon) {
            this.itemId = itemId;
            this.name = name;
            this.icon = icon;
        }

        public SubItemBean() {
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
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


}
