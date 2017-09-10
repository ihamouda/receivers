package com.procuredox.receivers.custcode;

public class CustCodePartnersRequest {
    String secKey;

    public CustCodePartnersRequest(String secKey) {
        this.secKey = secKey;
    }

    public CustCodePartnersRequest() {
    }

    public String getSecKey() {
        return secKey;
    }

    public void setSecKey(String secKey) {
        this.secKey = secKey;
    }
}
