package com.example.asd.entity.base;

import java.util.List;

public class ItemsResponse {
    private List<itemBean> items;

    public ItemsResponse(List<itemBean> items) {
        this.items = items;
    }

    public List<itemBean> getItems() {
        return items;
    }

    public void setItems(List<itemBean> items) {
        this.items = items;
    }

    public static class itemBean {
        private String itemId;
        private String name;
        private String icon;

        public itemBean(String itemId, String name, String icon) {
            this.itemId = itemId;
            this.name = name;
            this.icon = icon;
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
