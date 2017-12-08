package com.procuredox.receivers.custcode;

public class CheckDunsRequest {
    private String duns;

    public CheckDunsRequest(String duns) {
        this.duns = duns;
    }

    public CheckDunsRequest() {
    }

    public String getDuns() {
        return duns;
    }

    public void setDuns(String duns) {
        this.duns = duns;
    }
}
