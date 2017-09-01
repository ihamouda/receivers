package com.procuredox.receivers.resend;

/**
 * @author maxim.krestovsky@gmail.com on 9/1/17.
 */
public class PartnerNotFound extends RuntimeException {
    public PartnerNotFound(String message) {
        super(message);
    }
}