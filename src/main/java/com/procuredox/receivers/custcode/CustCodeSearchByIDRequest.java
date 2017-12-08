package com.procuredox.receivers.custcode;

public class CustCodeSearchByIDRequest {
    private String vendorId;
    private String search;

    public CustCodeSearchByIDRequest(String vendorId, String search) {
        this.vendorId = vendorId;
        this.search = search;
    }

    public CustCodeSearchByIDRequest() {
    }

    public String getvendorId() {
        return vendorId;
    }

    public void setvendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
