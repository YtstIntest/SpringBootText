package com.example.asd.entity;

import java.util.Date;

public class ColumnOptionBto {
    private String columnoptionId;

    private String fkOptionId;

    private String fkColumnId;

    private int intdex = 1;

    private int isdelete = 1;

    private Date createat = new Date();

    private String createby = "admin";

    private Date updateat;

    private String updateby;

    public ColumnOptionBto(String columnoptionId, String fkOptionId, String fkColumnId) {
        this.columnoptionId = columnoptionId;
        this.fkOptionId = fkOptionId;
        this.fkColumnId = fkColumnId;
    }

    public ColumnOptionBto() {
        super();
    }

    public String getColumnoptionId() {
        return columnoptionId;
    }

    public void setColumnoptionId(String columnoptionId) {
        this.columnoptionId = columnoptionId == null ? null : columnoptionId.trim();
    }

    public String getFkOptionId() {
        return fkOptionId;
    }

    public void setFkOptionId(String fkOptionId) {
        this.fkOptionId = fkOptionId == null ? null : fkOptionId.trim();
    }

    public String getFkColumnId() {
        return fkColumnId;
    }

    public void setFkColumnId(String fkColumnId) {
        this.fkColumnId = fkColumnId == null ? null : fkColumnId.trim();
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