package com.procuredox.receivers.custcode;

public class CustCodeSearchRequest {
    private String secKey;
    private String search;

    public CustCodeSearchRequest(String secKey, String search) {
        this.secKey = secKey;
        this.search = search;
    }

    public CustCodeSearchRequest() {
    }

    public String getSecKey() {
        return secKey;
    }

    public void setSecKey(String secKey) {
        this.secKey = secKey;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
