package com.example.asd.entity.base;

import java.util.List;

public class OptionResponse {
    private String optionId;
    private int Kind;
    private int dataType;
    private int maxLength;
    private int minLength;
    private int maxNum;
    private int minNum;
    private String regularText;
    private String dateFormat;
    private String queryFields;
    private List<ListFilter> listOfFilter;

    private int dataSourceKind;
    private String valueRange;

    public OptionResponse() {
    }

    public OptionResponse(String optionId, int kind, int dataType, int maxLength, int minLength, int maxNum, int minNum, String regularText, String dateFormat, String queryFields, List<ListFilter> listOfFilter, int dataSourceKind, String valueRange) {
        this.optionId = optionId;
        Kind = kind;
        this.dataType = dataType;
        this.maxLength = maxLength;
        this.minLength = minLength;
        this.maxNum = maxNum;
        this.minNum = minNum;
        this.regularText = regularText;
        this.dateFormat = dateFormat;
        this.queryFields = queryFields;
        this.listOfFilter = listOfFilter;
        this.dataSourceKind = dataSourceKind;
        this.valueRange = valueRange;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public int getKind() {
        return Kind;
    }

    public void setKind(int kind) {
        Kind = kind;
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

    public List<ListFilter> getListOfFilter() {
        return listOfFilter;
    }

    public void setListOfFilter(List<ListFilter> listOfFilter) {
        this.listOfFilter = listOfFilter;
    }

    public int getDataSourceKind() {
        return dataSourceKind;
    }

    public void setDataSourceKind(int dataSourceKind) {
        this.dataSourceKind = dataSourceKind;
    }

    public String getValueRange() {
        return valueRange;
    }

    public void setValueRange(String valueRange) {
        this.valueRange = valueRange;
    }

    public static class ListFilter {
        private String value;
        private String text;

        public ListFilter() {
        }

        public ListFilter(String value, String text) {
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
