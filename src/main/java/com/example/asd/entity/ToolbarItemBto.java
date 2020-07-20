package com.example.asd.entity;

import java.util.Date;

public class ToolbarItemBto {
    private String toolbaritemId;

    private String fkToolbarId;

    private String fkItemId;

    private Short intdex;

    private Short isdelete;

    private Date createat;

    private String createby;

    private Date updateat;

    private String updateby;

    public ToolbarItemBto(String toolbaritemId, String fkToolbarId, String fkItemId, Short intdex, Short isdelete, Date createat, String createby, Date updateat, String updateby) {
        this.toolbaritemId = toolbaritemId;
        this.fkToolbarId = fkToolbarId;
        this.fkItemId = fkItemId;
        this.intdex = intdex;
        this.isdelete = isdelete;
        this.createat = createat;
        this.createby = createby;
        this.updateat = updateat;
        this.updateby = updateby;
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

    public Short getIntdex() {
        return intdex;
    }

    public void setIntdex(Short intdex) {
        this.intdex = intdex;
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