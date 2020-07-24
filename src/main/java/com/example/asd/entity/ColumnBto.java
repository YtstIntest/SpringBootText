package com.example.asd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ColumnBto implements Serializable {
    private String columnId="";

    private String columnName="";

    private Integer orderNum;

    private Integer width = 40;

    private Integer isshow;

    private String sort = "null";

    private Integer iscansort = 0;

    private Integer isdelete = 1;

    private Date createat = new Date();

    private String createby = "admin";

    private Date updateat;

    private String updateby="";


    public ColumnBto(String columnId, String columnName, Integer orderNum, Integer width, Integer isshow, String sort, Integer iscansort, Integer isdelete, Date createat, String createby, Date updateat, String updateby) {
        this.columnId = columnId;
        this.columnName = columnName;
        this.orderNum = orderNum;
        this.width = width;
        this.isshow = isshow;
        this.sort = sort;
        this.iscansort = iscansort;
        this.isdelete = isdelete;
        this.createat = createat;
        this.createby = createby;
        this.updateat = updateat;
        this.updateby = updateby;
    }

    public ColumnBto(String columnId, String columnName, Integer orderNum, Integer width, Integer isshow, Integer iscansort) {
        this.columnId = columnId;
        this.columnName = columnName;
        this.orderNum = orderNum;
        this.width = width;
        this.isshow = isshow;
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

    public Integer getIsshow() {
        return isshow;
    }

    public void setIsshow(Integer isshow) {
        this.isshow = isshow;
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