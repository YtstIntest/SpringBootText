package com.example.asd.entity;

import java.util.Date;

public class ItemBto {
    private String itemId;

    private String name;

    private String fkItemId;

    private String remark;

    private Short isdelete;

    private Date createat;

    private String createby;

    private Date updateat;

    private String updateby;

    private String icon;

    public ItemBto(String itemId, String name, String fkItemId, String remark, Short isdelete, Date createat, String createby, Date updateat, String updateby, String icon) {
        this.itemId = itemId;
        this.name = name;
        this.fkItemId = fkItemId;
        this.remark = remark;
        this.isdelete = isdelete;
        this.createat = createat;
        this.createby = createby;
        this.updateat = updateat;
        this.updateby = updateby;
        this.icon = icon;
    }

    public ItemBto() {
        super();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFkItemId() {
        return fkItemId;
    }

    public void setFkItemId(String fkItemId) {
        this.fkItemId = fkItemId == null ? null : fkItemId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}