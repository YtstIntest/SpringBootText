package com.example.asd.entity;

import java.io.Serializable;
import java.util.Date;

public class TableBto implements Serializable {
    private String tableId="";

    private String fkMenuId="";

    private String remark="";

    private Integer isdelete = 1;

    private Date createat = new Date();

    private String createby = "admin";

    private Date updateat;

    private String updateby="";

    public TableBto(String tableId, String fkMenuId, String remark, Integer isdelete, Date createat, String createby, Date updateat, String updateby) {
        this.tableId = tableId;
        this.fkMenuId = fkMenuId;
        this.remark = remark;
        this.isdelete = isdelete;
        this.createat = createat;
        this.createby = createby;
        this.updateat = updateat;
        this.updateby = updateby;
    }

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