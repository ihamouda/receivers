package com.procuredox.receivers;

/**
 * Created by ihamouda on 2017-06-23.
 */
public class Item {
    private String supplierPartId;
    private String supplierPartAuxilaryId;
    private Integer lineNumber;
    private Double unitPrice;
    private String description;
    private String unitOfMeasure;
    private Double quantity;

    public Item(String supplierPartId, String supplierPartAuxilaryId, Integer lineNumber, Double unitPrice, String description, String unitOfMeasure, Double quantity) {
        this.supplierPartId = supplierPartId;
        this.supplierPartAuxilaryId = supplierPartAuxilaryId;
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

    public String getSupplierPartAuxilaryId() {
        return supplierPartAuxilaryId;
    }

    public void setSupplierPartAuxilaryId(String supplierPartAuxilaryId) {
        this.supplierPartAuxilaryId = supplierPartAuxilaryId;
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
