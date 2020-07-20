package com.example.asd.entity;

import java.util.Date;

public class MeunBto {
    private String menuId;

    private String fkMenuId;

    private String menudisplayname;

    private String menulink;

    private String icon;

    private Short isshow;

    private Short ispage;

    private Short orderno;

    private String note;

    private Short isdelete;

    private Date createat;

    private String createby;

    private Date updateat;

    private String updateby;

    public MeunBto(String menuId, String fkMenuId, String menudisplayname, String menulink, String icon, Short isshow, Short ispage, Short orderno, String note, Short isdelete, Date createat, String createby, Date updateat, String updateby) {
        this.menuId = menuId;
        this.fkMenuId = fkMenuId;
        this.menudisplayname = menudisplayname;
        this.menulink = menulink;
        this.icon = icon;
        this.isshow = isshow;
        this.ispage = ispage;
        this.orderno = orderno;
        this.note = note;
        this.isdelete = isdelete;
        this.createat = createat;
        this.createby = createby;
        this.updateat = updateat;
        this.updateby = updateby;
    }

    public MeunBto() {
        super();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getFkMenuId() {
        return fkMenuId;
    }

    public void setFkMenuId(String fkMenuId) {
        this.fkMenuId = fkMenuId == null ? null : fkMenuId.trim();
    }

    public String getMenudisplayname() {
        return menudisplayname;
    }

    public void setMenudisplayname(String menudisplayname) {
        this.menudisplayname = menudisplayname == null ? null : menudisplayname.trim();
    }

    public String getMenulink() {
        return menulink;
    }

    public void setMenulink(String menulink) {
        this.menulink = menulink == null ? null : menulink.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Short getIsshow() {
        return isshow;
    }

    public void setIsshow(Short isshow) {
        this.isshow = isshow;
    }

    public Short getIspage() {
        return ispage;
    }

    public void setIspage(Short ispage) {
        this.ispage = ispage;
    }

    public Short getOrderno() {
        return orderno;
    }

    public void setOrderno(Short orderno) {
        this.orderno = orderno;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
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