package com.procuredox.receivers.custcode;

public class CheckDunsResponse {
    private Boolean exists;
    private String vendorName;
    private String vendorId;

    public CheckDunsResponse(Boolean exists, String vendorName, String vendorId) {
        this.exists = exists;
        this.vendorName = vendorName;
        this.vendorId = vendorId;

    }

    public CheckDunsResponse() {
        this.exists = false;
        this.vendorName = "";
        this.vendorId = "";
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

    public String getvendorId() {
        return vendorId;
    }

    public void setvendorId(String vendorId) {
        this.vendorId = vendorId;
    }
}
