package com.procuredox.receivers.custcode;

public class SetCustCodeByIDRequest {
    private String vendorId;
    private String custCodeId;
    private String custCode;
    private String buyerId;

    public SetCustCodeByIDRequest(String vendorId, String custCodeId, String custCode, String buyerId) {
        this.vendorId = vendorId;
        this.custCodeId = custCodeId;
        this.custCode = custCode;
        this.buyerId = buyerId;
    }

    public SetCustCodeByIDRequest() {
    }

    public String getvendorId() {
        return vendorId;
    }

    public void setvendorId(String vendorId) {
        this.vendorId = vendorId;
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
