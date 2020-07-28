package com.example.asd.entity.base;

import java.util.List;

public class MenuResponse {
    private List<MenuItemBean> data;

    public MenuResponse(List<MenuItemBean> data) {
        this.data = data;
    }

    public List<MenuItemBean> getData() {
        return data;
    }

    public void setData(List<MenuItemBean> data) {
        this.data = data;
    }

    public static class MenuItemBean {
        private String menuId;
        private String menuPath;
        private String menuLink;

        public MenuItemBean() {
        }

        public MenuItemBean(String menuId, String menuPath, String menuLink) {
            this.menuId = menuId;
            this.menuPath = menuPath;
            this.menuLink = menuLink;
        }

        public String getMenuId() {
            return menuId;
        }

        public void setMenuId(String menuId) {
            this.menuId = menuId;
        }

        public String getMenuPath() {
            return menuPath;
        }

        public void setMenuPath(String menuPath) {
            this.menuPath = menuPath;
        }

        public String getMenuLink() {
            return menuLink;
        }

        public void setMenuLink(String menuLink) {
            this.menuLink = menuLink;
        }
    }
}
