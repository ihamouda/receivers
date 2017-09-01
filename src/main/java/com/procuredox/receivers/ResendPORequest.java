package com.procuredox.receivers;

/**
 * @author maxim.krestovsky@gmail.com on 9/2/17.
 */
public
class ResendPORequest {
    private String secretKey;
    private int batchNumber;
    private String filename;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}