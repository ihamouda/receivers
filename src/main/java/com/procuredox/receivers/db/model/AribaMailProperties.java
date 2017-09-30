package com.procuredox.receivers.db.model;

/**
 * @author procuredox on 4/10/17.
 */
public class AribaMailProperties {

    private String senderIdentifier;
    private String msgId;
    private String transmitType;
    private Long total;
    private String currency;
    private String poNumber;
    private String buyerCode;
    private String sellerCode;
    private String documentPurpose;
    private String ftNumber;
    private String soNumber;

    public String getSenderIdentifier() {
        return senderIdentifier;
    }

    public void setSenderIdentifier(String senderIdentifier) {
        this.senderIdentifier = senderIdentifier;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getTransmitType() {
        return transmitType;
    }

    public void setTransmitType(String transmitType) {
        this.transmitType = transmitType;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getDocumentPurpose() {
        return documentPurpose;
    }

    public void setDocumentPurpose(String documentPurpose) {
        this.documentPurpose = documentPurpose;
    }

    public String getFtNumber() {
        return ftNumber;
    }

    public void setFtNumber(String ftNumber) {
        this.ftNumber = ftNumber;
    }

    public String getSoNumber() {
        return soNumber;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber;
    }
}