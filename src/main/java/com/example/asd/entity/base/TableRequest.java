package com.example.asd.entity.base;

import java.util.List;

public class TableRequest {
    private String menuId;
    private String tableId;
    private String remark;
    private List<ColumnBean> column;
    private ToolbarBean toolbar;

    public TableRequest(String menuId, String tableId, String remark, List<ColumnBean> column, ToolbarBean toolbar) {
        this.menuId = menuId;
        this.tableId = tableId;
        this.remark = remark;
        this.column = column;
        this.toolbar = toolbar;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ColumnBean> getColumn() {
        return column;
    }

    public void setColumn(List<ColumnBean> column) {
        this.column = column;
    }

    public ToolbarBean getToolbar() {
        return toolbar;
    }

    public void setToolbar(ToolbarBean toolbar) {
        this.toolbar = toolbar;
    }

    public static class ColumnBean {
        private String columnId;

        private String columnName;

        private String dataPropertyName;

        private int orderNum;

        private int width;

        private boolean isShow;

        private boolean isCanSort;

        private String fieldText;


        public ColumnBean(String columnId, String columnName, int orderNum, int width, boolean isShow, boolean isCanSort, String fieldText,String dataPropertyName) {
            this.columnId = columnId;
            this.columnName = columnName;
            this.orderNum = orderNum;
            this.width = width;
            this.isShow = isShow;
            this.isCanSort = isCanSort;
            this.fieldText = fieldText;
            this.dataPropertyName=dataPropertyName;
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

        public boolean getIsShow() {
            return isShow;
        }

        public void setIsShow(boolean isShow) {
            this.isShow = isShow;
        }

        public boolean getIsCanSort() {
            return isCanSort;
        }

        public void setIsCanSort(boolean isCanSort) {
            this.isCanSort = isCanSort;
        }

        public String getFieldText() {
            return fieldText;
        }

        public void setFieldText(String fieldText) {
            this.fieldText = fieldText;
        }

        public String getDataPropertyName() {
            return dataPropertyName;
        }

        public void setDataPropertyName(String dataPropertyName) {
            this.dataPropertyName = dataPropertyName;
        }
    }

    public static class ToolbarBean {
        private boolean checked;
        private List<ItemBean> items;

        public ToolbarBean(boolean checked, List<ItemBean> items) {
            this.checked = checked;
            this.items = items;
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
    }

    public static class ItemBean {
        private String itemId;
        private boolean isSelect;

        public ItemBean(String itemId, boolean isSelect) {
            this.itemId = itemId;
            this.isSelect = isSelect;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }
    }

    public static class FieldItemBean {
        private String value;
        private String text;

        public FieldItemBean() {
        }

        public FieldItemBean(String value, String text) {
            this.value = value;
            this.text = text;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
