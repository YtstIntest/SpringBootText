package com.example.asd.entity;

import java.util.Date;

public class TableBto {
    private String tableId;

    private String fkMenuId;

    private String remark;

    private int isdelete = 1;

    private Date createat = new Date();

    private String createby = "admin";

    private Date updateat;

    private String updateby;


    public TableBto(String tableId, String fkMenuId, String remark) {
        this.tableId = tableId;
        this.fkMenuId = fkMenuId;
        this.remark = remark;
    }

    public TableBto() {
        super();
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId == null ? null : tableId.trim();
    }

    public String getFkMenuId() {
        return fkMenuId;
    }

    public void setFkMenuId(String fkMenuId) {
        this.fkMenuId = fkMenuId == null ? null : fkMenuId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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