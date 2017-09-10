package com.procuredox.receivers.custcode;

public class CheckSecKeyResponse {
    private Boolean exists;
    private String vendorName;

    public CheckSecKeyResponse(Boolean exists, String vendorName) {
        this.exists = exists;
        this.vendorName = vendorName;
    }

    public CheckSecKeyResponse() {
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}
