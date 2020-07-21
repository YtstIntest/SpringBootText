package com.example.asd.entity;

import java.util.Date;

public class ToolbarBto {
    private String toolbarId;

    private int charecked;

    private String remark;

    private int isdelete = 1;

    private Date createat = new Date();

    private String createby = "admin";

    private Date updateat;

    private String updateby;

    private String fkTableId;

    public ToolbarBto(String toolbarId, int charecked, String remark,  String fkTableId) {
        this.toolbarId = toolbarId;
        this.charecked = charecked;
        this.remark = remark;
        this.fkTableId = fkTableId;
    }

    public ToolbarBto() {
        super();
    }

    public String getToolbarId() {
        return toolbarId;
    }

    public void setToolbarId(String toolbarId) {
        this.toolbarId = toolbarId == null ? null : toolbarId.trim();
    }

    public int getCharecked() {
        return charecked;
    }

    public void setCharecked(int charecked) {
        this.charecked = charecked;
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

    public String getFkTableId() {
        return fkTableId;
    }

    public void setFkTableId(String fkTableId) {
        this.fkTableId = fkTableId == null ? null : fkTableId.trim();
    }
}