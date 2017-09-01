package com.procuredox.receivers.resend;

/**
 * @author maxim.krestovsky@gmail.com on 9/1/17.
 */
public class DocumentNotFound extends RuntimeException {
    public DocumentNotFound(String message) {
        super(message);
    }
}