package com.example.asd.entity;

import java.util.Date;

public class ToolbarItemBto {
    private String toolbaritemId;

    private String fkToolbarId;

    private String fkItemId;

    private int intdex = 1;

    private int isdelete = 1;

    private Date createat = new Date();

    private String createby = "admin";

    private Date updateat;

    private String updateby;

    public ToolbarItemBto(String toolbaritemId, String fkToolbarId, String fkItemId) {
        this.toolbaritemId = toolbaritemId;
        this.fkToolbarId = fkToolbarId;
        this.fkItemId = fkItemId;
    }

    public ToolbarItemBto() {
        super();
    }

    public String getToolbaritemId() {
        return toolbaritemId;
    }

    public void setToolbaritemId(String toolbaritemId) {
        this.toolbaritemId = toolbaritemId == null ? null : toolbaritemId.trim();
    }

    public String getFkToolbarId() {
        return fkToolbarId;
    }

    public void setFkToolbarId(String fkToolbarId) {
        this.fkToolbarId = fkToolbarId == null ? null : fkToolbarId.trim();
    }

    public String getFkItemId() {
        return fkItemId;
    }

    public void setFkItemId(String fkItemId) {
        this.fkItemId = fkItemId == null ? null : fkItemId.trim();
    }

    public int getIntdex() {
        return intdex;
    }

    public void setIntdex(int intdex) {
        this.intdex = intdex;
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