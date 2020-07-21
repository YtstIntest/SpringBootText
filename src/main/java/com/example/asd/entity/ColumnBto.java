package com.example.asd.entity;

import java.util.Date;
import java.util.List;

public class ColumnBto {
    private String columnId;

    private String columnName;

    private int orderNum;

    private int width;

    private int checked;

    private String sort="null";

    private int iscansort;

    private int isdelete=1;

    private Date createat=new Date();

    private String createby="admin";

    private Date updateat;

    private String updateby;


    public ColumnBto(String columnId, String columnName, int orderNum, int width, int checked, int iscansort) {
        this.columnId = columnId;
        this.columnName = columnName;
        this.orderNum = orderNum;
        this.width = width;
        this.checked = checked;
        this.iscansort = iscansort;

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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public int getIscansort() {
        return iscansort;
    }

    public void setIscansort(int iscansort) {
        this.iscansort = iscansort;
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


}