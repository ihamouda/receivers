package com.procuredox.receivers.custcode;

public class CheckSecKeyResponse {
    private Boolean exists;

    public CheckSecKeyResponse(Boolean exists) {
        this.exists = exists;
    }

    public CheckSecKeyResponse() {
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }
}
