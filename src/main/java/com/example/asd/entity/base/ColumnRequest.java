package com.example.asd.entity.base;

import java.util.List;

public class ColumnRequest {
    private String tableId="";
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
        private String columnId="";
        private String columnName="";
        private int orderNum;
        private int width;
        private boolean checked;
        private String sort="";
        private boolean IsCanSort;


        public StyleBean() {
        }

        public StyleBean(String columnId, String columnName, int orderNum, int width, boolean checked, String sort, boolean isCanSort) {
            this.columnId = columnId;
            this.columnName = columnName;
            this.orderNum = orderNum;
            this.width = width;
            this.checked = checked;
            this.sort = sort;
            IsCanSort = isCanSort;
        }

        public String getColumnId() {
            return columnId;
        }

        public void setColumnId(String columnId) {
            this.columnId = columnId;
        }

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
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

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public boolean isCanSort() {
            return IsCanSort;
        }

        public void setCanSort(boolean canSort) {
            IsCanSort = canSort;
        }
    }
}
