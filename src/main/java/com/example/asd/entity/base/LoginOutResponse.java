package com.example.asd.entity.base;

public class LoginOutResponse {
    private int isCanLogout;

    public LoginOutResponse(int isCanLogout) {
        this.isCanLogout = isCanLogout;
    }

    public int getIsCanLogout() {
        return isCanLogout;
    }

    public void setIsCanLogout(int isCanLogout) {
        this.isCanLogout = isCanLogout;
    }
}
