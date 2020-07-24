package com.example.asd.entity;

import java.io.Serializable;
import java.util.Date;

public class ToolbarBto implements Serializable {
    private String toolbarId="";

    private Integer charecked;

    private String remark="";

    private Integer isdelete = 1;

    private Date createat = new Date();

    private String createby = "admin";

    private Date updateat;

    private String updateby="";

    private String fkTableId="";

    public ToolbarBto(String toolbarId, Integer charecked, String remark, Integer isdelete, Date createat, String createby, Date updateat, String updateby, String fkTableId) {
        this.toolbarId = toolbarId;
        this.charecked = charecked;
        this.remark = remark;
        this.isdelete = isdelete;
        this.createat = createat;
        this.createby = createby;
        this.updateat = updateat;
        this.updateby = updateby;
        this.fkTableId = fkTableId;
    }

    public ToolbarBto(String toolbarId, Integer charecked, String remark, String fkTableId) {
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

    public Integer getCharecked() {
        return charecked;
    }

    public void setCharecked(Integer charecked) {
        this.charecked = charecked;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getFkTableId() {
        return fkTableId;
    }

    public void setFkTableId(String fkTableId) {
        this.fkTableId = fkTableId == null ? null : fkTableId.trim();
    }
}