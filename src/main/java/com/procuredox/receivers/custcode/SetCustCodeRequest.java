package com.procuredox.receivers.custcode;

public class SetCustCodeRequest {
    private String secKey;
    private String custCodeId;
    private String custCode;
    private String buyerId;

    public SetCustCodeRequest(String secKey, String custCodeId, String custCode, String buyerId) {
        this.secKey = secKey;
        this.custCodeId = custCodeId;
        this.custCode = custCode;
        this.buyerId = buyerId;
    }

    public SetCustCodeRequest() {
    }

    public String getSecKey() {
        return secKey;
    }

    public void setSecKey(String secKey) {
        this.secKey = secKey;
    }

    public String getCustCodeId() {
        return custCodeId;
    }

    public void setCustCodeId(String custCodeId) {
        this.custCodeId = custCodeId;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}
