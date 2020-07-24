package com.example.asd.dto;

import java.util.List;

public class LoginResponse {
    private int isCanLogin;
    private String token;
    private int failNum;
    private List<MenusItemBean> menus;

    public LoginResponse() {
    }

    public LoginResponse(int isCanLogin, String token, int failNum, List<MenusItemBean> menus) {
        this.isCanLogin = isCanLogin;
        this.token = token;
        this.failNum = failNum;
        this.menus = menus;
    }

    public int getIsCanLogin() {
        return isCanLogin;
    }

    public void setIsCanLogin(int isCanLogin) {
        this.isCanLogin = isCanLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getFailNum() {
        return failNum;
    }

    public void setFailNum(int failNum) {
        this.failNum = failNum;
    }

    public List<MenusItemBean> getMenus() {
        return menus;
    }

    public void setMenus(List<MenusItemBean> menus) {
        this.menus = menus;
    }

    public static class MenusItemBean {
        private String id;
        private boolean isPage;
        private boolean isShow;
        private String link;
        private String pId;
        private String permissionId;
        private String text;
        private List<MenusItemBean> children;

        public MenusItemBean() {
        }

        public MenusItemBean(String id, boolean isPage, boolean isShow, String link, String pId, String permissionId, String text, List<MenusItemBean> children) {
            this.id = id;
            this.isPage = isPage;
            this.isShow = isShow;
            this.link = link;
            this.pId = pId;
            this.permissionId = permissionId;
            this.text = text;
            this.children = children;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isPage() {
            return isPage;
        }

        public void setPage(boolean page) {
            isPage = page;
        }

        public boolean isShow() {
            return isShow;
        }

        public void setShow(boolean show) {
            isShow = show;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getpId() {
            return pId;
        }

        public void setpId(String pId) {
            this.pId = pId;
        }

        public String getPermissionId() {
            return permissionId;
        }

        public void setPermissionId(String permissionId) {
            this.permissionId = permissionId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public List<MenusItemBean> getChildren() {
            return children;
        }

        public void setChildren(List<MenusItemBean> children) {
            this.children = children;
        }
    }
}
