package com.example.asd.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("UserBto用户注册对象")
public class UserBto implements Serializable {
    @ApiModelProperty(value = "主键，账户ID")
    private String userId="";

    @ApiModelProperty(value = "登录账号")
    private String loginName="";

    @ApiModelProperty(value = "登录密码")
    private String loginPassword="";

    @ApiModelProperty(value = "加密盐值")
    private String csprng="";

    @ApiModelProperty(value = "姓名")
    private String realName="";

    @ApiModelProperty(value = "工号")
    private String jobNumber="";

    @ApiModelProperty(value = "手机")
    private String mobile="";

    @ApiModelProperty(value = "部门ID")
    private String companyEmail="";

    @ApiModelProperty(value = "性别（0-女 ；1-男；）")
    private Short sex;

    @ApiModelProperty(value = "备注")
    private String note="";

    @ApiModelProperty(value = "账号类型（1-系统用户账户；2-服务账户；）")
    private Short accountKind = 2;

    @ApiModelProperty(value = "上次登录时间")
    private Date lastLoginat;

    @ApiModelProperty(value = "密码重试次数")
    private Integer passwordRetryCount = 5;

    @ApiModelProperty(value = "账户状态（0-冻结；1-启用；）")
    private Short accountStatus = 1;

    @ApiModelProperty(value = "是否删除（1-未删除，0-已删除；）")
    private Short isdelete = 1;

    @ApiModelProperty(value = "创建时间")
    private Date createat;

    @ApiModelProperty(value = "创建人")
    private String createby="";

    @ApiModelProperty(value = "修改时间")
    private Date updateat;

    @ApiModelProperty(value = "修改人")
    private String updateby="";


    public UserBto(String userId, String loginName, String loginPassword, String csprng, String realName, String jobNumber, String mobile, String companyEmail, Short sex, String note, Short accountKind, Date lastLoginat, Integer passwordRetryCount, Short accountStatus, Short isdelete, Date createat, String createby, Date updateat, String updateby) {
        this.userId = userId;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.csprng = csprng;
        this.realName = realName;
        this.jobNumber = jobNumber;
        this.mobile = mobile;
        this.companyEmail = companyEmail;
        this.sex = sex;
        this.note = note;
        this.accountKind = accountKind;
        this.lastLoginat = lastLoginat;
        this.passwordRetryCount = passwordRetryCount;
        this.accountStatus = accountStatus;
        this.isdelete = isdelete;
        this.createat = createat;
        this.createby = createby;
        this.updateat = updateat;
        this.updateby = updateby;
    }

    public UserBto() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getCsprng() {
        return csprng;
    }

    public void setCsprng(String csprng) {
        this.csprng = csprng == null ? null : csprng.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail == null ? null : companyEmail.trim();
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Short getAccountKind() {
        return accountKind;
    }

    public void setAccountKind(Short accountKind) {
        this.accountKind = accountKind;
    }

    public Date getLastLoginat() {
        return lastLoginat;
    }

    public void setLastLoginat(Date lastLoginat) {
        this.lastLoginat = lastLoginat;
    }

    public Integer getPasswordRetryCount() {
        return passwordRetryCount;
    }

    public void setPasswordRetryCount(Integer passwordRetryCount) {
        this.passwordRetryCount = passwordRetryCount;
    }

    public Short getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Short accountStatus) {
        this.accountStatus = accountStatus;
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