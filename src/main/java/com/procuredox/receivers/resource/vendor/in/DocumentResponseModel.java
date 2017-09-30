package com.procuredox.receivers.resource.vendor.in;

/**
 * @author procuredox on 2/25/17.
 */
public class DocumentResponseModel {

    private String message;
    private Integer batchNumber;
    private boolean received;

    public static DocumentResponseModel success(String message) {
        return new DocumentResponseModel(message, null, true);
    }

    public static DocumentResponseModel success(String message, int batchNumber) {
        return new DocumentResponseModel(message, batchNumber, true);
    }

    public static DocumentResponseModel failed(String message) {
        return new DocumentResponseModel(message, null, true);
    }

    public DocumentResponseModel(String message, Integer batchNumber, boolean received) {
        this.message = message;
        this.batchNumber = batchNumber;
        this.received = received;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber) {
        this.batchNumber = batchNumber;
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }
}