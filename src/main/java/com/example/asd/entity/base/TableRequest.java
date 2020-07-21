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

        private int orderNum;

        private int width;

        private int checked;


        private int isCanSort;

        private String fieldText;

        private List<OptionBean> option;

        public ColumnBean(String columnId, String columnName, int orderNum, int width, int checked, int isCanSort, String fieldText, List<OptionBean> option) {
            this.columnId = columnId;
            this.columnName = columnName;
            this.orderNum = orderNum;
            this.width = width;
            this.checked = checked;
            this.isCanSort = isCanSort;
            this.fieldText = fieldText;
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

        public String getFieldText() {
            return fieldText;
        }

        public void setFieldText(String fieldText) {
            this.fieldText = fieldText;
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

        private int dateType;

        private int maxLength;

        private int minLength;

        private int maxNum;

        private int minNum;

        private String regularText;

        private String dateFormat;

        private String queryFields;

        private String listoffilter;

        private String value;

        private String text;

        private int dateSourceKind;

        private String valueRange;
        private String fieldText;

        public OptionBean(String optionId, int kind, int dateType, int maxLength, int minLength, int maxNum, int minNum, String regularText, String dateFormat, String queryFields, String listoffilter, String value, String text,  int dateSourceKind, String valueRange,String fieldText) {
            this.optionId = optionId;
            this.kind = kind;
            this.dateType = dateType;
            this.maxLength = maxLength;
            this.minLength = minLength;
            this.maxNum = maxNum;
            this.minNum = minNum;
            this.regularText = regularText;
            this.dateFormat = dateFormat;
            this.queryFields = queryFields;
            this.listoffilter = listoffilter;
            this.value = value;
            this.text = text;
            this.dateSourceKind = dateSourceKind;
            this.valueRange = valueRange;
            this.fieldText=fieldText;
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

        public int getDateType() {
            return dateType;
        }

        public void setDateType(int dateType) {
            this.dateType = dateType;
        }

        public int getMaxLength() {
            return maxLength;
        }

        public void setMaxLength(int maxLength) {
            this.maxLength = maxLength;
        }

        public int getMinLength() {
            return minLength;
        }

        public void setMinLength(int minLength) {
            this.minLength = minLength;
        }

        public int getMaxNum() {
            return maxNum;
        }

        public void setMaxNum(int maxNum) {
            this.maxNum = maxNum;
        }

        public int getMinNum() {
            return minNum;
        }

        public void setMinNum(int minNum) {
            this.minNum = minNum;
        }

        public String getRegularText() {
            return regularText;
        }

        public void setRegularText(String regularText) {
            this.regularText = regularText;
        }

        public String getDateFormat() {
            return dateFormat;
        }

        public void setDateFormat(String dateFormat) {
            this.dateFormat = dateFormat;
        }

        public String getQueryFields() {
            return queryFields;
        }

        public void setQueryFields(String queryFields) {
            this.queryFields = queryFields;
        }

        public String getListoffilter() {
            return listoffilter;
        }

        public void setListoffilter(String listoffilter) {
            this.listoffilter = listoffilter;
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

        public int getDateSourceKind() {
            return dateSourceKind;
        }

        public void setDateSourceKind(int dateSourceKind) {
            this.dateSourceKind = dateSourceKind;
        }

        public String getValueRange() {
            return valueRange;
        }

        public void setValueRange(String valueRange) {
            this.valueRange = valueRange;
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
}
