package com.procuredox.receivers.custcode;

public class DeleteCustCodeByIDRequest {
    private String vendorId;
    private String custCodeId;

    public DeleteCustCodeByIDRequest(String vendorId, String custCodeId) {
        this.vendorId = vendorId;
        this.custCodeId = custCodeId;
    }

    public DeleteCustCodeByIDRequest() {
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
}
