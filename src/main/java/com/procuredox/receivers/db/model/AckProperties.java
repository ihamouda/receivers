package com.procuredox.receivers.db.model;

/**
 * @author procuredox on 2/2/17.
 */
public class AckProperties {

    private String documentNumber;
    private String transmitType;
    private String documentPurpose;
    private String soNumber;
    private String poNumber;
    private String invoiceNumber;
    private String ftNumber;
    private String documentType;
    private String batchNumber;
    private String receiverIdentifier;
    private String senderIdentifier;
    private String receiverTransportMethod;
    private String receiverCode;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getTransmitType() {
        return transmitType;
    }

    public void setTransmitType(String transmitType) {
        this.transmitType = transmitType;
    }

    public String getDocumentPurpose() {
        return documentPurpose;
    }

    public void setDocumentPurpose(String documentPurpose) {
        this.documentPurpose = documentPurpose;
    }

    public String getSoNumber() {
        return soNumber;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getFtNumber() {
        return ftNumber;
    }

    public void setFtNumber(String ftNumber) {
        this.ftNumber = ftNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getReceiverIdentifier() {
        return receiverIdentifier;
    }

    public void setReceiverIdentifier(String receiverIdentifier) {
        this.receiverIdentifier = receiverIdentifier;
    }

    public String getSenderIdentifier() {
        return senderIdentifier;
    }

    public void setSenderIdentifier(String senderIdentifier) {
        this.senderIdentifier = senderIdentifier;
    }

    public String getReceiverTransportMethod() {
        return receiverTransportMethod;
    }

    public void setReceiverTransportMethod(String receiverTransportMethod) {
        this.receiverTransportMethod = receiverTransportMethod;
    }

    public String getReceiverCode() {
        return receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode;
    }
}