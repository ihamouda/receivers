package com.procuredox.receivers.custcode;

public class CheckCustCodeRequest {
    private String secKey;
    private String custCode;

    public CheckCustCodeRequest(String secKey, String custCode) {
        this.secKey = secKey;
        this.custCode = custCode;
    }

    public CheckCustCodeRequest() {
    }

    public String getSecKey() {
        return secKey;
    }

    public void setSecKey(String secKey) {
        this.secKey = secKey;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }
}
