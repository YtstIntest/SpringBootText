package com.example.asd.entity.base;

import java.util.List;

public class ColumnRequest {
    private String tableId;
    private List<StyleBean> style;

    public ColumnRequest() {
    }

    public ColumnRequest(String tableId, List<StyleBean> style) {
        this.tableId = tableId;
        this.style = style;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public List<StyleBean> getStyle() {
        return style;
    }

    public void setStyle(List<StyleBean> style) {
        this.style = style;
    }

    public static class StyleBean {
        private String columnId;
        private int orderNum;
        private int width;
        private boolean isShow;
        private String sort;


        public StyleBean() {
        }

        public StyleBean(String columnId, int orderNum, int width, boolean isShow, String sort) {
            this.columnId = columnId;
            this.orderNum = orderNum;
            this.width = width;
            this.isShow = isShow;
            this.sort = sort;
        }

        public String getColumnId() {
            return columnId;
        }

        public void setColumnId(String columnId) {
            this.columnId = columnId;
        }


        public int getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public boolean isShow() {
            return isShow;
        }

        public void setShow(boolean show) {
            isShow = show;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

    }
}
