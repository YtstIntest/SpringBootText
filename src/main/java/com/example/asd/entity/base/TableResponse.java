package com.example.asd.entity.base;

import java.util.Date;
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
        private String dataPropertyName;
        private int width;
        private boolean isShow;
        private boolean isCanSort;
        private List<OptionBean> option;

        public ColumnBean() {
        }

        public ColumnBean(String columnId, String columnName, int orderNum, int width, boolean isShow, boolean isCanSort, List<OptionBean> option,String dataPropertyName) {
            this.columnId = columnId;
            this.columnName = columnName;
            this.orderNum = orderNum;
            this.width = width;
            this.isShow = isShow;
            this.isCanSort = isCanSort;
            this.option = option;
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

        public List<OptionBean> getOption() {
            return option;
        }

        public void setOption(List<OptionBean> option) {
            this.option = option;
        }

        public String getDataPropertyName() {
            return dataPropertyName;
        }

        public void setDataPropertyName(String dataPropertyName) {
            this.dataPropertyName = dataPropertyName;
        }
    }

    public static class OptionBean {
        private String optionId;

        private Integer kind;

        private Integer dataType;

        private Integer maxLength;

        private Integer minLength;

        private Integer maxNum;

        private Integer minNum;

        private String regularText;

        private String dateFormat;

        private String queryFields;

        private List<ListItemFilterBean> listoffilter;

        private Integer dateSourceKind;

        private List valueRange;

        private Integer isdelete;

        private String fieldText;

        public OptionBean() {
        }

        public OptionBean(String optionId, Integer kind, Integer dataType, Integer maxLength, Integer minLength, Integer maxNum, Integer minNum, String regularText, String dateFormat, String queryFields, List<ListItemFilterBean> listoffilter, Integer dateSourceKind, List valueRange, Integer isdelete, String fieldText) {
            this.optionId = optionId;
            this.kind = kind;
            this.dataType = dataType;
            this.maxLength = maxLength;
            this.minLength = minLength;
            this.maxNum = maxNum;
            this.minNum = minNum;
            this.regularText = regularText;
            this.dateFormat = dateFormat;
            this.queryFields = queryFields;
            this.listoffilter = listoffilter;
            this.dateSourceKind = dateSourceKind;
            this.valueRange = valueRange;
            this.isdelete = isdelete;
            this.fieldText = fieldText;
        }

        public String getOptionId() {
            return optionId;
        }

        public void setOptionId(String optionId) {
            this.optionId = optionId;
        }

        public Integer getKind() {
            return kind;
        }

        public void setKind(Integer kind) {
            this.kind = kind;
        }

        public Integer getDataType() {
            return dataType;
        }

        public void setDataType(Integer dataType) {
            this.dataType = dataType;
        }

        public Integer getMaxLength() {
            return maxLength;
        }

        public void setMaxLength(Integer maxLength) {
            this.maxLength = maxLength;
        }

        public Integer getMinLength() {
            return minLength;
        }

        public void setMinLength(Integer minLength) {
            this.minLength = minLength;
        }

        public Integer getMaxNum() {
            return maxNum;
        }

        public void setMaxNum(Integer maxNum) {
            this.maxNum = maxNum;
        }

        public Integer getMinNum() {
            return minNum;
        }

        public void setMinNum(Integer minNum) {
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

        public List<ListItemFilterBean> getListoffilter() {
            return listoffilter;
        }

        public void setListoffilter(List<ListItemFilterBean> listoffilter) {
            this.listoffilter = listoffilter;
        }

        public Integer getDateSourceKind() {
            return dateSourceKind;
        }

        public void setDateSourceKind(Integer dateSourceKind) {
            this.dateSourceKind = dateSourceKind;
        }

        public List getValueRange() {
            return valueRange;
        }

        public void setValueRange(List valueRange) {
            this.valueRange = valueRange;
        }

        public Integer getIsdelete() {
            return isdelete;
        }

        public void setIsdelete(Integer isdelete) {
            this.isdelete = isdelete;
        }

        public String getFieldText() {
            return fieldText;
        }

        public void setFieldText(String fieldText) {
            this.fieldText = fieldText;
        }
    }

    public static class ListItemFilterBean {
        private String value;
        private String text;

        public ListItemFilterBean() {
        }

        public ListItemFilterBean(String value, String text) {
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

        public boolean getIsSelect() {
            return isSelect;
        }

        public void setIsSelect(boolean isSelect) {
            this.isSelect = isSelect;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
