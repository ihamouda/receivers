package com.procuredox.receivers.custcode;

public class CheckCustCodeByIDResponse {
    private Boolean exists;

    public CheckCustCodeByIDResponse(Boolean exists) {
        this.exists = exists;
    }

    public CheckCustCodeByIDResponse() {
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }
}
