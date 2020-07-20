package com.example.asd.entity;

import java.util.Date;

public class TableColumnBto {
    private String tablecolumnId;

    private String fkTableId;

    private String fkColumnId;

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

    public TableColumnBto(String tablecolumnId, String fkTableId, String fkColumnId, Short orderNum, Short width, Short checked, String sort, Short iscansort, Short isdelete, Date createat, String createby, Date updateat, String updateby) {
        this.tablecolumnId = tablecolumnId;
        this.fkTableId = fkTableId;
        this.fkColumnId = fkColumnId;
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
    }

    public TableColumnBto() {
        super();
    }

    public String getTablecolumnId() {
        return tablecolumnId;
    }

    public void setTablecolumnId(String tablecolumnId) {
        this.tablecolumnId = tablecolumnId == null ? null : tablecolumnId.trim();
    }

    public String getFkTableId() {
        return fkTableId;
    }

    public void setFkTableId(String fkTableId) {
        this.fkTableId = fkTableId == null ? null : fkTableId.trim();
    }

    public String getFkColumnId() {
        return fkColumnId;
    }

    public void setFkColumnId(String fkColumnId) {
        this.fkColumnId = fkColumnId == null ? null : fkColumnId.trim();
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
}