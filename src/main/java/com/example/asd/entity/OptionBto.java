package com.example.asd.entity;

import java.util.Date;

public class OptionBto {
    private String optionId;

    private Integer kind;

    private Integer dateType;

    private Integer maxLength;

    private Integer minLength;

    private Integer maxNum;

    private Integer minNum;

    private String regularText;

    private String dateFormat;

    private String queryFields;

    private String listoffilter;

    private Integer dateSourceKind;

    private String valueRange;

    private Integer isdelete = 1;

    private Date createat = new Date();

    private String createby = "admin";

    private Date updateat;

    private String updateby;

    private String fieldText;


    public OptionBto(String optionId, Integer kind, Integer dateType, Integer maxLength, Integer minLength, Integer maxNum, Integer minNum, String regularText, String dateFormat, String queryFields, String listoffilter, Integer dateSourceKind, String valueRange, Integer isdelete, Date createat, String createby, Date updateat, String updateby, String fieldText) {
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
        this.dateSourceKind = dateSourceKind;
        this.valueRange = valueRange;
        this.isdelete = isdelete;
        this.createat = createat;
        this.createby = createby;
        this.updateat = updateat;
        this.updateby = updateby;
        this.fieldText = fieldText;
    }

    public OptionBto(String optionId, Integer kind, Integer dateType, Integer maxLength, Integer minLength, Integer maxNum, Integer minNum, String regularText, String dateFormat, String queryFields, String listoffilter,  Integer dateSourceKind, String valueRange, String fieldText) {
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
        this.dateSourceKind = dateSourceKind;
        this.valueRange = valueRange;
        this.fieldText = fieldText;
    }

    @Override
    public String toString() {
        return "OptionBto{" +
                "optionId='" + optionId + '\'' +
                ", kind=" + kind +
                ", dateType=" + dateType +
                ", maxLength=" + maxLength +
                ", minLength=" + minLength +
                ", maxNum=" + maxNum +
                ", minNum=" + minNum +
                ", regularText='" + regularText + '\'' +
                ", dateFormat='" + dateFormat + '\'' +
                ", queryFields='" + queryFields + '\'' +
                ", listoffilter='" + listoffilter + '\'' +
                ", dateSourceKind=" + dateSourceKind +
                ", valueRange='" + valueRange + '\'' +
                ", isdelete=" + isdelete +
                ", createat=" + createat +
                ", createby='" + createby + '\'' +
                ", updateat=" + updateat +
                ", updateby='" + updateby + '\'' +
                ", fieldText='" + fieldText + '\'' +
                '}';
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

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public Integer getDateType() {
        return dateType;
    }

    public void setDateType(Integer dateType) {
        this.dateType = dateType;
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

    public Integer getDateSourceKind() {
        return dateSourceKind;
    }

    public void setDateSourceKind(Integer dateSourceKind) {
        this.dateSourceKind = dateSourceKind;
    }

    public String getValueRange() {
        return valueRange;
    }

    public void setValueRange(String valueRange) {
        this.valueRange = valueRange == null ? null : valueRange.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
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