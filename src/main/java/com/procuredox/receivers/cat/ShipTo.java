package com.procuredox.receivers.cat;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;


/**
 * Created by ihamouda on 2017-06-27.
 */
public class ShipTo {
    @JacksonXmlProperty(localName = "shipToName")
    private String shipToName;
    @JacksonXmlProperty(localName = "address")
    private Address address;
    @JacksonXmlProperty(localName = "shippingInstructions")
    private String shippingInstructions;
    @JacksonXmlProperty(localName = "accountNum")
    private String accountNum;
    @JacksonXmlProperty(localName = "accountName")
    private String accountName;
    @JacksonXmlProperty(localName = "supplierReference")
    private String supplierReference;
    @JacksonXmlProperty(localName = "shipVia")
    private String shipVia;
    @JacksonXmlProperty(localName = "paymentInstructions")
    private String paymentInstructions;
    @JacksonXmlProperty(localName = "deliveryInstructions")
    private String deliveryLocation;
    @JacksonXmlProperty(localName = "specialInstructions")
    List<SpecialInstruction> specialInstructions;

    public ShipTo(String shipToName, Address address, String shippingInstructions, String accountNum, String accountName, String supplierReference, String shipVia, String paymentInstructions, String deliveryLocation, List<SpecialInstruction> specialInstructions) {
        this.shipToName = shipToName;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.accountNum = accountNum;
        this.accountName = accountName;
        this.supplierReference = supplierReference;
        this.shipVia = shipVia;
        this.paymentInstructions = paymentInstructions;
        this.deliveryLocation = deliveryLocation;
        this.specialInstructions = specialInstructions;
    }

    public ShipTo() {
    }

    public String getShipToName() {
        return shipToName;
    }

    public void setShipToName(String shipToName) {
        this.shipToName = shipToName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions) {
        this.shippingInstructions = shippingInstructions;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public String getShipVia() {
        return shipVia;
    }

    public void setShipVia(String shipVia) {
        this.shipVia = shipVia;
    }

    public String getPaymentInstructions() {
        return paymentInstructions;
    }

    public void setPaymentInstructions(String paymentInstructions) {
        this.paymentInstructions = paymentInstructions;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public List<SpecialInstruction> getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(List<SpecialInstruction> specialInstructions) {
        this.specialInstructions = specialInstructions;
    }
}

