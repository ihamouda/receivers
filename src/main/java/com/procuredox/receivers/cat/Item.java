package com.procuredox.receivers.cat;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by ihamouda on 2017-06-23.
 */
public class Item {
    @JacksonXmlProperty(localName = "supplierPartId")
    private String supplierPartId;
    @JacksonXmlProperty(localName = "supplierPartAuxiliaryId")
    private String supplierPartAuxiliaryId;
    @JacksonXmlProperty(localName = "lineNumber")
    private Integer lineNumber;
    @JacksonXmlProperty(localName = "unitPrice")
    private Double unitPrice;
    @JacksonXmlProperty(localName = "description")
    private String description;
    @JacksonXmlProperty(localName = "unitOfMeasure")
    private String unitOfMeasure;
    @JacksonXmlProperty(localName = "deliveryDate")
    private Date deliveryDate;
    @JacksonXmlProperty(localName = "quantity")
    private Double quantity;
    @JacksonXmlProperty(localName = "quantities")
    private List<ItemQuantity> quantities;

    public Item(String supplierPartId, String supplierPartAuxiliaryId, Integer lineNumber, Double unitPrice, String description, String unitOfMeasure, Date deliveryDate, Double quantity, List<ItemQuantity> quantities) {
        this.supplierPartId = supplierPartId;
        this.supplierPartAuxiliaryId = supplierPartAuxiliaryId;
        this.lineNumber = lineNumber;
        this.unitPrice = unitPrice;
        this.description = description;
        this.unitOfMeasure = unitOfMeasure;
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.quantities = quantities;
    }

    public Item() {
    }

    public String getSupplierPartId() {
        return supplierPartId;
    }

    public void setSupplierPartId(String supplierPartId) {
        this.supplierPartId = supplierPartId;
    }

    public String getSupplierPartAuxiliaryId() {
        return supplierPartAuxiliaryId;
    }

    public void setSupplierPartAuxiliaryId(String supplierPartAuxiliaryId) {
        this.supplierPartAuxiliaryId = supplierPartAuxiliaryId;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public List<ItemQuantity> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<ItemQuantity> quantities) {
        this.quantities = quantities;
    }
}
