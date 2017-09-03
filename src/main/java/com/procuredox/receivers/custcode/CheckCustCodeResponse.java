package com.procuredox.receivers.custcode;

public class CheckCustCodeResponse {
    private Boolean exists;

    public CheckCustCodeResponse(Boolean exists) {
        this.exists = exists;
    }

    public CheckCustCodeResponse() {
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }
}
