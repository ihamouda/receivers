package com.procuredox.receivers.custcode;

public class CheckSecKeyRequest {
    private String secKey;

    public CheckSecKeyRequest(String secKey) {
        this.secKey = secKey;
    }

    public CheckSecKeyRequest() {
    }

    public String getSecKey() {
        return secKey;
    }

    public void setSecKey(String secKey) {
        this.secKey = secKey;
    }
}
