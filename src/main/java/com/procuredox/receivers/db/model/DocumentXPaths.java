package com.procuredox.receivers.db.model;

/**
 * @author procuredox on 10/17/16.
 */
public class DocumentXPaths {

    private String senderIdentifierXpath;
    private String receiverIdentifierXpath;
    private String documentTypeXpath;
    private String customerCodeId;

    public String getSenderIdentifierXpath() {
        return senderIdentifierXpath;
    }

    public void setSenderIdentifierXpath(String senderIdentifierXpath) {
        this.senderIdentifierXpath = senderIdentifierXpath;
    }

    public String getReceiverIdentifierXpath() {
        return receiverIdentifierXpath;
    }

    public void setReceiverIdentifierXpath(String receiverIdentifierXpath) {
        this.receiverIdentifierXpath = receiverIdentifierXpath;
    }

    public String getDocumentTypeXpath() {
        return documentTypeXpath;
    }

    public void setDocumentTypeXpath(String documentTypeXpath) {
        this.documentTypeXpath = documentTypeXpath;
    }

    public String getCustomerCodeId() {
        return customerCodeId;
    }

    public void setCustomerCodeId(String customerCodeId) {
        this.customerCodeId = customerCodeId;
    }
}
