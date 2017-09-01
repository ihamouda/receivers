package com.procuredox.receivers.resend;

/**
 * @author maxim.krestovsky@gmail.com on 9/1/17.
 */
public class BatchFileNotFound extends RuntimeException {
    public BatchFileNotFound(String message) {
        super(message);
    }
}