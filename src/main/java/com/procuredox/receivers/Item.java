package com.procuredox.receivers;

/**
 * Created by ihamouda on 2017-06-23.
 */
public class Item {
    private String supplierPartId;
    private String getSupplierPartAuxilaryId;
    private Integer lineNumber;
    private Double unitPrice;
    private String description;
    private String unitOfMeasure;
    private Double quantity;

    public Item(String supplierPartId, String getSupplierPartAuxilaryId, Integer lineNumber, Double unitPrice, String description, String unitOfMeasure, Double quantity) {
        this.supplierPartId = supplierPartId;
        this.getSupplierPartAuxilaryId = getSupplierPartAuxilaryId;
        this.lineNumber = lineNumber;
        this.unitPrice = unitPrice;
        this.description = description;
        this.unitOfMeasure = unitOfMeasure;
        this.quantity = quantity;
    }

    public Item() {
    }

    public String getSupplierPartId() {
        return supplierPartId;
    }

    public void setSupplierPartId(String supplierPartId) {
        this.supplierPartId = supplierPartId;
    }

    public String getGetSupplierPartAuxilaryId() {
        return getSupplierPartAuxilaryId;
    }

    public void setGetSupplierPartAuxilaryId(String getSupplierPartAuxilaryId) {
        this.getSupplierPartAuxilaryId = getSupplierPartAuxilaryId;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
