package com.procuredox.receivers.custcode;

public class CheckCustCodeByIDRequest {
    private String vendorId;
    private String custCode;

    public CheckCustCodeByIDRequest(String vendorId, String custCode) {
        this.vendorId = vendorId;
        this.custCode = custCode;
    }

    public CheckCustCodeByIDRequest() {
    }

    public String getvendorId() {
        return vendorId;
    }

    public void setvendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }
}
