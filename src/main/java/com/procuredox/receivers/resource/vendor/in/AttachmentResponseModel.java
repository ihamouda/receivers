package com.procuredox.receivers.resource.vendor.in;

/**
 * @author procuredox on 2/25/17.
 */
public class AttachmentResponseModel {

    private String message;
    private boolean received;

    public AttachmentResponseModel(String message, boolean received) {
        this.message = message;
        this.received = received;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }
}