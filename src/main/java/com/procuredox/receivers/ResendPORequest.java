package com.procuredox.receivers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author maxim.krestovsky@gmail.com on 9/2/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResendPORequest {
    private int batchNumber;

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }
}