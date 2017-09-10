package com.procuredox.receivers.resend;

/**
 * @author procuredox on 8/31/17.
 */
public class PartnerNotFound extends RuntimeException {
    public PartnerNotFound(String message) {
        super(message);
    }
}