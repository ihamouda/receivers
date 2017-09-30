package com.procuredox.receivers.db.model;

/**
 * @author procuredox on 10/11/16.
 */
public class WriteResult {

    private String documentId;
    private String messageId;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
