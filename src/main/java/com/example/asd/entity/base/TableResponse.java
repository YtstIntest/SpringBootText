package com.example.asd.entity.base;

import java.util.List;

public class TableResponse {
    private List<TableBean> data;

    public TableResponse(List<TableBean> data) {
        this.data = data;
    }

    public List<TableBean> getData() {
        return data;
    }

    public void setData(List<TableBean> data) {
        this.data = data;
    }

    public static class TableBean {
        private String tableId;
        private String remark;
        private List<ToolbarBean> toolbar;
        private List<ColumnBean> column;


        public TableBean() {
        }

        public TableBean(String tableId, String remark, List<ToolbarBean> toolbar, List<ColumnBean> column) {
            this.tableId = tableId;
            this.remark = remark;
            this.toolbar = toolbar;
            this.column = column;

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

        public List<ToolbarBean> getToolbar() {
            return toolbar;
        }

        public void setToolbar(List<ToolbarBean> toolbar) {
            this.toolbar = toolbar;
        }

        public List<ColumnBean> getColumn() {
            return column;
        }

        public void setColumn(List<ColumnBean> column) {
            this.column = column;
        }
    }


    public static class ColumnBean {
        private String columnId;
        private String columnName;
        private int orderNum;
        private int width;
        private int checked;
        private int isCanSort;
        private List<OptionBean> option;

        public ColumnBean() {
        }

        public ColumnBean(String columnId, String columnName, int orderNum, int width, int checked, int isCanSort, List<OptionBean> option) {
            this.columnId = columnId;
            this.columnName = columnName;
            this.orderNum = orderNum;
            this.width = width;
            this.checked = checked;
            this.isCanSort = isCanSort;
            this.option = option;
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

        public int getChecked() {
            return checked;
        }

        public void setChecked(int checked) {
            this.checked = checked;
        }

        public int getIsCanSort() {
            return isCanSort;
        }

        public void setIsCanSort(int isCanSort) {
            this.isCanSort = isCanSort;
        }

        public List<OptionBean> getOption() {
            return option;
        }

        public void setOption(List<OptionBean> option) {
            this.option = option;
        }
    }

    public static class OptionBean {
        private String optionId;
        private int kind;
        private String fieldText;


        public OptionBean(String optionId, int kind, String fieldText) {
            this.optionId = optionId;
            this.kind = kind;
            this.fieldText = fieldText;
        }

        public String getOptionId() {
            return optionId;
        }

        public void setOptionId(String optionId) {
            this.optionId = optionId;
        }

        public int getKind() {
            return kind;
        }

        public void setKind(int kind) {
            this.kind = kind;
        }

        public String getFieldText() {
            return fieldText;
        }

        public void setFieldText(String fieldText) {
            this.fieldText = fieldText;
        }
    }

    public static class ToolbarBean {
        private String itemId;
        private String name;
        private String icon;
        private boolean isSelect;


        public ToolbarBean() {
        }

        public ToolbarBean(String itemId, String name, String icon, boolean isSelect) {
            this.itemId = itemId;
            this.name = name;
            this.icon = icon;
            this.isSelect = isSelect;
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

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }
    }
}
