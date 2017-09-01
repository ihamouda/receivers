package com.procuredox.receivers;

/**
 * @author maxim.krestovsky@gmail.com on 9/2/17.
 */
public class ResendPOResponse {

    private boolean success;
    private String message;
    private String stackTrace;

    public ResendPOResponse(boolean success, String message, String stackTrace) {
        this.success = success;
        this.message = message;
        this.stackTrace = stackTrace;
    }

    public ResendPOResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
