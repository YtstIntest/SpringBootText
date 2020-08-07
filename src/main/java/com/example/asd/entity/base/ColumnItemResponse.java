package com.example.asd.entity.base;

import java.util.List;

public class ColumnItemResponse {
    private String columnId;
    private String title;
    private String dataPropertyName;
    private StyleItemBean style;
    private List<QueryItemBean> queryList;

    public ColumnItemResponse() {
    }

    public ColumnItemResponse(String columnId, String title, String dataPropertyName, StyleItemBean style, List<QueryItemBean> queryList) {
        this.columnId = columnId;
        this.title = title;
        this.dataPropertyName = dataPropertyName;
        this.style = style;
        this.queryList = queryList;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataPropertyName() {
        return dataPropertyName;
    }

    public void setDataPropertyName(String dataPropertyName) {
        this.dataPropertyName = dataPropertyName;
    }

    public StyleItemBean getStyle() {
        return style;
    }

    public void setStyle(StyleItemBean style) {
        this.style = style;
    }

    public List<QueryItemBean> getQueryList() {
        return queryList;
    }

    public void setQueryList(List<QueryItemBean> queryList) {
        this.queryList = queryList;
    }

    public static class StyleItemBean {
        private int orderNum;
        private int width;
        private boolean isShow;
        private boolean IsCanSort;
        private String sort;

        public StyleItemBean() {
        }

        public StyleItemBean(int orderNum, int width, boolean isShow, boolean IsCanSort, String sort) {
            this.orderNum = orderNum;
            this.width = width;
            this.isShow = isShow;
            this.IsCanSort = IsCanSort;
            this.sort = sort;
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

        public boolean getisShow() {
            return isShow;
        }

        public void setisShow(boolean isShow) {
            isShow = isShow;
        }

        public boolean getIsCanSort() {
            return IsCanSort;
        }

        public void setIsCanSort(boolean IsCanSort) {
            this.IsCanSort = IsCanSort;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }
    }

    public static class QueryItemBean<T> {
        private int kind;
        private int index;
        private String queryFields;
        private String optionId;
        private String fieldText;
        private T options;

        public QueryItemBean() {
        }

        public QueryItemBean(int kind, int index, String queryFields, String optionId, String fieldText, T options) {
            this.kind = kind;
            this.index = index;
            this.queryFields = queryFields;
            this.optionId = optionId;
            this.fieldText = fieldText;
            this.options = options;
        }

        public int getKind() {
            return kind;
        }

        public void setKind(int kind) {
            this.kind = kind;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getQueryFields() {
            return queryFields;
        }

        public void setQueryFields(String queryFields) {
            this.queryFields = queryFields;
        }

        public String getOptionId() {
            return optionId;
        }

        public void setOptionId(String optionId) {
            this.optionId = optionId;
        }

        public String getFieldText() {
            return fieldText;
        }

        public void setFieldText(String fieldText) {
            this.fieldText = fieldText;
        }

        public T getOptions() {
            return options;
        }

        public void setOptions(T options) {
            this.options = options;
        }
    }

    public static class OneItemBean {
        private int dataType;
        private int maxLength;
        private int maxNum;
        private int minNum;
        private String regularText;
        private String dateFormat;

        public OneItemBean() {
        }

        public OneItemBean(int dataType, int maxLength, int maxNum, int minNum, String regularText, String dateFormat) {
            this.dataType = dataType;
            this.maxLength = maxLength;
            this.maxNum = maxNum;
            this.minNum = minNum;
            this.regularText = regularText;
            this.dateFormat = dateFormat;
        }

        public int getDataType() {
            return dataType;
        }

        public void setDataType(int dataType) {
            this.dataType = dataType;
        }

        public int getMaxLength() {
            return maxLength;
        }

        public void setMaxLength(int maxLength) {
            this.maxLength = maxLength;
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
    }

    public static class TwoItemBean {
        private List<TwoItemFilterBean> listOfFilter;
        private int dataSourceKind;

        public TwoItemBean() {
        }

        public TwoItemBean(List<TwoItemFilterBean> listOfFilter, int dataSourceKind) {
            this.listOfFilter = listOfFilter;
            this.dataSourceKind = dataSourceKind;
        }

        public List<TwoItemFilterBean> getListOfFilter() {
            return listOfFilter;
        }

        public void setListOfFilter(List<TwoItemFilterBean> listOfFilter) {
            this.listOfFilter = listOfFilter;
        }

        public int getDataSourceKind() {
            return dataSourceKind;
        }

        public void setDataSourceKind(int dataSourceKind) {
            this.dataSourceKind = dataSourceKind;
        }
    }

    public static class ThreeItemBean {
        private List valueRange;
        private String queryFields;
        private int dataType;
        private String dateFormat;

        public ThreeItemBean() {
        }

        public ThreeItemBean(List valueRange, String queryFields, int dataType, String dateFormat) {
            this.valueRange = valueRange;
            this.queryFields = queryFields;
            this.dataType = dataType;
            this.dateFormat = dateFormat;
        }

        public List getValueRange() {
            return valueRange;
        }

        public void setValueRange(List valueRange) {
            this.valueRange = valueRange;
        }

        public String getQueryFields() {
            return queryFields;
        }

        public void setQueryFields(String queryFields) {
            this.queryFields = queryFields;
        }

        public int getDataType() {
            return dataType;
        }

        public void setDataType(int dataType) {
            this.dataType = dataType;
        }

        public String getDateFormat() {
            return dateFormat;
        }

        public void setDateFormat(String dateFormat) {
            this.dateFormat = dateFormat;
        }
    }

    public static class TwoItemFilterBean {
        private String value;
        private String text;

        public TwoItemFilterBean() {
        }

        public TwoItemFilterBean(String value, String text) {
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
