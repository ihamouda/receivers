package com.procuredox.receivers.db.model;

/**
 * @author procuredox on 2/27/17.
 */
public class ReversePartnershipProps {

    private String senderIdentifier;
    private String receiverIdentifier;

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
}