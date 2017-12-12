package com.procuredox.receivers.resend;

/**
 * @author maxim.krestovsky@gmail.com on 12/13/17.
 */
public class XpathsData {

    private String senderIdentifier;
    private String receiverIdentifier;
    private String documentType;
    private String hascode;

    public XpathsData(String senderIdentifier, String receiverIdentifier, String documentType, String hascode) {
        this.senderIdentifier = senderIdentifier;
        this.receiverIdentifier = receiverIdentifier;
        this.documentType = documentType;
        this.hascode = hascode;
    }

    public String getSenderIdentifier() {
        return senderIdentifier;
    }

    public void setSenderIdentifier(String senderIdentifier) {
        this.senderIdentifier = senderIdentifier;
    }

    public String getReceiverIdentifier() {
        return receiverIdentifier;
    }

    public void setReceiverIdentifier(String receiverIdentifier) {
        this.receiverIdentifier = receiverIdentifier;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getHascode() {
        return hascode;
    }

    public void setHascode(String hascode) {
        this.hascode = hascode;
    }
}