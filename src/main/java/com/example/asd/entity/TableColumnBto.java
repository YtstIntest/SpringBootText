package com.example.asd.entity;

import java.io.Serializable;
import java.util.Date;

public class TableColumnBto implements Serializable {
    private String tablecolumnId;

    private String fkTableId;

    private String fkColumnId;

    private Integer orderNum;

    private Integer width;

    private Integer checked;

    private String sort="null";

    private Integer iscansort;

    private Integer isdelete = 1;

    private Date createat = new Date();

    private String createby = "admin";

    private Date updateat;

    private String updateby;

    public TableColumnBto(String tablecolumnId, String fkTableId, String fkColumnId, Integer orderNum, Integer width, Integer checked, String sort, Integer iscansort, Integer isdelete, Date createat, String createby, Date updateat, String updateby) {
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

    public TableColumnBto(String tablecolumnId, String fkTableId, String fkColumnId, Integer orderNum, Integer width, Integer checked,  Integer iscansort) {
        this.tablecolumnId = tablecolumnId;
        this.fkTableId = fkTableId;
        this.fkColumnId = fkColumnId;
        this.orderNum = orderNum;
        this.width = width;
        this.checked = checked;
        this.iscansort = iscansort;
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

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public Integer getIscansort() {
        return iscansort;
    }

    public void setIscansort(Integer iscansort) {
        this.iscansort = iscansort;
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
}