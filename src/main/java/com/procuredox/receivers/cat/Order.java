package com.procuredox.receivers.cat;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Date;
import java.util.List;

/**
 * Created by ihamouda on 2017-06-23.
 */
@JacksonXmlRootElement(localName="Order")
public class Order {
    @JacksonXmlProperty(localName = "count")
    private Integer count;
    @JacksonXmlProperty(localName = "batchNumber")
    private Integer batchNumber;
    @JacksonXmlProperty(localName = "supplierOrderReference")
    private String supplierOrderReference;
    @JacksonXmlProperty(localName = "totalAmount")
    private Double totalAmount;
    @JacksonXmlProperty(localName = "currency")
    private String currency;
    @JacksonXmlProperty(localName = "expectedDate")
    private Date expectedDate;
    @JacksonXmlProperty(localName = "operationAllowed")
    private String operationAllowed;
    @JacksonXmlProperty(localName = "shipTo")
    private ShipTo shipTo;
    @JacksonXmlProperty(localName = "items")
    private List<Item> items;


    public Order(Integer count, Integer batchNumber, String supplierOrderReference, Double totalAmount, String currency, Date expectedDate, String operationAllowed, ShipTo shipTo, List<Item> items) {
        this.count = count;
        this.batchNumber = batchNumber;
        this.supplierOrderReference = supplierOrderReference;
        this.totalAmount = totalAmount;
        this.currency = currency;
        this.expectedDate = expectedDate;
        this.operationAllowed = operationAllowed;
        this.shipTo = shipTo;
        this.items = items;
    }

    public Order() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getSupplierOrderReference() {
        return supplierOrderReference;
    }

    public void setSupplierOrderReference(String supplierOrderReference) {
        this.supplierOrderReference = supplierOrderReference;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getOperationAllowed() {
        return operationAllowed;
    }

    public void setOperationAllowed(String operationAllowed) {
        this.operationAllowed = operationAllowed;
    }

    public ShipTo getShipTo() {
        return shipTo;
    }

    public void setShipTo(ShipTo shipTo) {
        this.shipTo = shipTo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
