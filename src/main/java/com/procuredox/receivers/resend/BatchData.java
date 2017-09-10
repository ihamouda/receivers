package com.procuredox.receivers.resend;

/**
 * @author procuredox on 9/7/17.
 */
public class BatchData {

    private String vendorCode;
    private String buyerCode;
    private String docType;
    private String msgId;
    private String receiverIndetifier;
    private String senderIdentifier;
    private String documentNumber;
    private String responseForInvoice;

    public BatchData(String vendorCode, String buyerCode, String docType, String msgId, String receiverIndetifier, String senderIdentifier, String documentNumber, String responseForInvoice) {
        this.vendorCode = vendorCode;
        this.buyerCode = buyerCode;
        this.docType = docType;
        this.msgId = msgId;
        this.receiverIndetifier = receiverIndetifier;
        this.senderIdentifier = senderIdentifier;
        this.documentNumber = documentNumber;
        this.responseForInvoice = responseForInvoice;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public String getDocType() {
        return docType;
    }

    public String getMsgId() {
        return msgId;
    }

    public String getReceiverIndetifier() {
        return receiverIndetifier;
    }

    public String getSenderIdentifier() {
        return senderIdentifier;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getResponseForInvoice() {
        return responseForInvoice;
    }
}