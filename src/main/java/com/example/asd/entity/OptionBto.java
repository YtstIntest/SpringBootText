package com.example.asd.entity;

import java.util.Date;

public class OptionBto {
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

    private int isdelete = 1;

    private Date createat = new Date();

    private String createby = "admin";

    private Date updateat;

    private String updateby;

    private String fieldText;

    public OptionBto(String optionId, int kind, int dateType, int maxLength, int minLength, int maxNum, int minNum, String regularText, String dateFormat, String queryFields, String listoffilter, String value, String text, int dateSourceKind, String valueRange,  String fieldText) {
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
        this.fieldText = fieldText;
    }

    public OptionBto() {
        super();
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId == null ? null : optionId.trim();
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
        this.regularText = regularText == null ? null : regularText.trim();
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat == null ? null : dateFormat.trim();
    }

    public String getQueryFields() {
        return queryFields;
    }

    public void setQueryFields(String queryFields) {
        this.queryFields = queryFields == null ? null : queryFields.trim();
    }

    public String getListoffilter() {
        return listoffilter;
    }

    public void setListoffilter(String listoffilter) {
        this.listoffilter = listoffilter == null ? null : listoffilter.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
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
        this.valueRange = valueRange == null ? null : valueRange.trim();
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public Date getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Date updateat) {
        this.updateat = updateat;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public String getFieldText() {
        return fieldText;
    }

    public void setFieldText(String fieldText) {
        this.fieldText = fieldText == null ? null : fieldText.trim();
    }
}