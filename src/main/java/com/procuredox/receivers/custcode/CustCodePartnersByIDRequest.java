package com.procuredox.receivers.custcode;

public class CustCodePartnersByIDRequest {
    String vendorId;

    public CustCodePartnersByIDRequest(String vendorId) {
        this.vendorId = vendorId;
    }

    public CustCodePartnersByIDRequest() {
    }

    public String getvendorId() {
        return vendorId;
    }

    public void setvendorId(String vendorId) {
        this.vendorId = vendorId;
    }
}
