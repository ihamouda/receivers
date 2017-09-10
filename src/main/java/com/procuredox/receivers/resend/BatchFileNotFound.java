package com.procuredox.receivers.resend;

/**
 * @author procuredox on 8/31/17.
 */
public class BatchFileNotFound extends RuntimeException {
    public BatchFileNotFound(String message) {
        super(message);
    }
}