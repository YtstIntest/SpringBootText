package com.example.asd.dto;

public class LoginOutDto {
    private int isCanLogout;

    public LoginOutDto(int isCanLogout) {
        this.isCanLogout = isCanLogout;
    }

    public int getIsCanLogout() {
        return isCanLogout;
    }

    public void setIsCanLogout(int isCanLogout) {
        this.isCanLogout = isCanLogout;
    }
}
