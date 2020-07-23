package com.example.asd.entity.base;

import java.util.List;

public class ColumnItemResponse {
    private String columnId;
    private String title;
    private String dataPropertyName;
    private StyleItemBean style;
    private List<QueryItemBean> queryList;


    public static class StyleItemBean {
        private int orderNum;
        private int width;
        private boolean checked;
        private boolean IsCanSort;
        private boolean sort;

        public StyleItemBean() {
        }

        public StyleItemBean(int orderNum, int width, boolean checked, boolean isCanSort, boolean sort) {
            this.orderNum = orderNum;
            this.width = width;
            this.checked = checked;
            IsCanSort = isCanSort;
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

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public boolean isCanSort() {
            return IsCanSort;
        }

        public void setCanSort(boolean canSort) {
            IsCanSort = canSort;
        }

        public boolean isSort() {
            return sort;
        }

        public void setSort(boolean sort) {
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
        //        private List<> valueRange;
        private String queryFields;
        private int dataType;
        private String dateFormat;
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
