package com.procuredox.receivers.custcode;

public class Success {
    private Boolean success;
    private String error;

    public Success(Boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public Success() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
