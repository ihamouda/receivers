package com.procuredox.receivers.resend;

/**
 * @author procuredox on 8/31/17.
 */
public class DocumentNotFound extends RuntimeException {
    public DocumentNotFound(String message) {
        super(message);
    }
}