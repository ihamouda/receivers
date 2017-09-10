package com.procuredox.receivers.custcode;

public class DeleteCustCodeRequest {
    private String sekkey;
    private String custCodeId;

    public DeleteCustCodeRequest(String sekkey, String custCodeId) {
        this.sekkey = sekkey;
        this.custCodeId = custCodeId;
    }

    public DeleteCustCodeRequest() {
    }

    public String getSekkey() {
        return sekkey;
    }

    public void setSekkey(String sekkey) {
        this.sekkey = sekkey;
    }

    public String getCustCodeId() {
        return custCodeId;
    }

    public void setCustCodeId(String custCodeId) {
        this.custCodeId = custCodeId;
    }
}
