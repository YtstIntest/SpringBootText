package com.example.asd.dto;

public class LoginResponse {
    private int isCanLogin;
    private String token;
    private int failNum;

    public LoginResponse(int isCanLogin, String token, int failNum) {
        this.isCanLogin = isCanLogin;
        this.token = token;
        this.failNum = failNum;
    }

    public int getIsCanLogin() {
        return isCanLogin;
    }

    public void setIsCanLogin(int isCanLogin) {
        this.isCanLogin = isCanLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getFailNum() {
        return failNum;
    }

    public void setFailNum(int failNum) {
        this.failNum = failNum;
    }
}
