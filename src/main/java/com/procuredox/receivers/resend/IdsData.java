package com.procuredox.receivers.resend;

/**
 * @author procuredox on 12/14/17.
 */
public class IdsData {

    private final String documentId;
    private final String batchId;
    private final String msgId;

    public IdsData(String documentId, String batchId, String msgId) {
        this.documentId = documentId;
        this.batchId = batchId;
        this.msgId = msgId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getBatchId() {
        return batchId;
    }

    public String getMsgId() {
        return msgId;
    }
}
