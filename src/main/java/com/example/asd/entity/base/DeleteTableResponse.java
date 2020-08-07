package com.example.asd.entity.base;

public class DeleteTableResponse {
    private boolean data;
    private String errorMessage;

    public DeleteTableResponse(boolean data, String errorMessage) {
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
