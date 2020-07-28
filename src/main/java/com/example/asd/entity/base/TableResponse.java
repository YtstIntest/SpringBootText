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
        private ToolbarBean toolbar;
        private List<ColumnBean> column;


        public TableBean() {
        }

        public TableBean(String tableId, String remark, ToolbarBean toolbar, List<ColumnBean> column) {
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

        public ToolbarBean getToolbar() {
            return toolbar;
        }

        public void setToolbar(ToolbarBean toolbar) {
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
        private boolean isShow;
        private boolean isCanSort;
        private List<OptionBean> option;

        public ColumnBean() {
        }

        public ColumnBean(String columnId, String columnName, int orderNum, int width, boolean isShow, boolean isCanSort, List<OptionBean> option) {
            this.columnId = columnId;
            this.columnName = columnName;
            this.orderNum = orderNum;
            this.width = width;
            this.isShow = isShow;
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
        private boolean checked;
        private List<ItemBean> items;

        public ToolbarBean() {
        }

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
        private String name;
        private boolean isSelect;
        private String icon;

        public ItemBean() {
        }

        public ItemBean(String itemId, String name, boolean isSelect, String icon) {
            this.itemId = itemId;
            this.name = name;
            this.isSelect = isSelect;
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

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }
        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
