package com.procuredox.receivers.custcode;

public class CustCode {
    String custCodeId;
    String vendorCustCode;
    String buyerId;

    public CustCode(String custCodeId, String vendorCustCode, String buyerId) {
        this.custCodeId = custCodeId;
        this.vendorCustCode = vendorCustCode;
        this.buyerId = buyerId;
    }

    public CustCode() {
    }

    public String getCustCodeId() {
        return custCodeId;
    }

    public void setCustCodeId(String custCodeId) {
        this.custCodeId = custCodeId;
    }

    public String getVendorCustCode() {
        return vendorCustCode;
    }

    public void setVendorCustCode(String vendorCustCode) {
        this.vendorCustCode = vendorCustCode;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}
