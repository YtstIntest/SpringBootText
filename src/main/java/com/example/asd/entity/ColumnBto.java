package com.example.asd.entity;

import java.util.Date;
import java.util.List;

public class ColumnBto {
    private String columnId;

    private String columnName;

    private Short orderNum;

    private Short width;

    private Short checked;

    private String sort;

    private Short iscansort;

    private Short isdelete;

    private Date createat;

    private String createby;

    private Date updateat;

    private String updateby;

    private List<OptionBto> option;

    public ColumnBto(String columnId, String columnName, Short orderNum, Short width, Short checked, String sort, Short iscansort, Short isdelete, Date createat, String createby, Date updateat, String updateby, List<OptionBto> option) {
        this.columnId = columnId;
        this.columnName = columnName;
        this.orderNum = orderNum;
        this.width = width;
        this.checked = checked;
        this.sort = sort;
        this.iscansort = iscansort;
        this.isdelete = isdelete;
        this.createat = createat;
        this.createby = createby;
        this.updateat = updateat;
        this.updateby = updateby;
        this.option = option;
    }

    public ColumnBto() {
        super();
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId == null ? null : columnId.trim();
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public Short getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Short orderNum) {
        this.orderNum = orderNum;
    }

    public Short getWidth() {
        return width;
    }

    public void setWidth(Short width) {
        this.width = width;
    }

    public Short getChecked() {
        return checked;
    }

    public void setChecked(Short checked) {
        this.checked = checked;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public Short getIscansort() {
        return iscansort;
    }

    public void setIscansort(Short iscansort) {
        this.iscansort = iscansort;
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

    public List<OptionBto> getOption() {
        return option;
    }

    public void setOption(List<OptionBto> option) {
        this.option = option;
    }
}