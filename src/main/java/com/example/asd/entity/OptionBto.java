package com.example.asd.entity;

import java.util.Date;

public class OptionBto {
    private String optionId;

    private Short kind;

    private Short dateType;

    private Short maxLength;

    private Short minLength;

    private Short maxNum;

    private Short minNum;

    private String regularText;

    private String dateFormat;

    private String queryFields;

    private String listoffilter;

    private String value;

    private String text;

    private String dateField;

    private Short dateSourceKind;

    private String valueRange;

    private Short isdelete;

    private Date createat;

    private String createby;

    private Date updateat;

    private String updateby;

    public OptionBto(String optionId, Short kind, Short dateType, Short maxLength, Short minLength, Short maxNum, Short minNum, String regularText, String dateFormat, String queryFields, String listoffilter, String value, String text, String dateField, Short dateSourceKind, String valueRange, Short isdelete, Date createat, String createby, Date updateat, String updateby) {
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
        this.dateField = dateField;
        this.dateSourceKind = dateSourceKind;
        this.valueRange = valueRange;
        this.isdelete = isdelete;
        this.createat = createat;
        this.createby = createby;
        this.updateat = updateat;
        this.updateby = updateby;
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

    public Short getKind() {
        return kind;
    }

    public void setKind(Short kind) {
        this.kind = kind;
    }

    public Short getDateType() {
        return dateType;
    }

    public void setDateType(Short dateType) {
        this.dateType = dateType;
    }

    public Short getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Short maxLength) {
        this.maxLength = maxLength;
    }

    public Short getMinLength() {
        return minLength;
    }

    public void setMinLength(Short minLength) {
        this.minLength = minLength;
    }

    public Short getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Short maxNum) {
        this.maxNum = maxNum;
    }

    public Short getMinNum() {
        return minNum;
    }

    public void setMinNum(Short minNum) {
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

    public String getDateField() {
        return dateField;
    }

    public void setDateField(String dateField) {
        this.dateField = dateField == null ? null : dateField.trim();
    }

    public Short getDateSourceKind() {
        return dateSourceKind;
    }

    public void setDateSourceKind(Short dateSourceKind) {
        this.dateSourceKind = dateSourceKind;
    }

    public String getValueRange() {
        return valueRange;
    }

    public void setValueRange(String valueRange) {
        this.valueRange = valueRange == null ? null : valueRange.trim();
    }

    public Short getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Short isdelete) {
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
}