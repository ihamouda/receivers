
package com.procuredox.receivers.cat.responsemessage;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for OrderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="batchNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="supplierOrderReference" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expectedDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operationAllowed" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shipTo" type="{}shipToType"/>
 *         &lt;element name="items" type="{}itemsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderType", propOrder = {
    "count",
    "batchNumber",
    "supplierOrderReference",
    "totalAmount",
    "currency",
    "expectedDate",
    "operationAllowed",
    "shipTo",
    "items"
})
@XmlRootElement(name = "Order")
public class OrderType {

    @XmlElement(required = true)
    protected String count;
    @XmlElement(required = true)
    protected String batchNumber;
    @XmlElement(required = true)
    protected String supplierOrderReference;
    @XmlElement(required = true)
    protected String totalAmount;
    @XmlElement(required = true)
    protected String currency;
    @XmlElement(required = true)
    protected String expectedDate;
    @XmlElement(required = true)
    protected String operationAllowed;
    @XmlElement(required = true)
    protected ShipToType shipTo;
    @XmlElement(required = true)
    protected ItemsType items;

    /**
     * Gets the value of the count property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCount(String value) {
        this.count = value;
    }

    /**
     * Gets the value of the batchNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBatchNumber() {
        return batchNumber;
    }

    /**
     * Sets the value of the batchNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBatchNumber(String value) {
        this.batchNumber = value;
    }

    /**
     * Gets the value of the supplierOrderReference property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSupplierOrderReference() {
        return supplierOrderReference;
    }

    /**
     * Sets the value of the supplierOrderReference property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSupplierOrderReference(String value) {
        this.supplierOrderReference = value;
    }

    /**
     * Gets the value of the totalAmount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTotalAmount(String value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the expectedDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExpectedDate() {
        return expectedDate;
    }

    /**
     * Sets the value of the expectedDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExpectedDate(String value) {
        this.expectedDate = value;
    }

    /**
     * Gets the value of the operationAllowed property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOperationAllowed() {
        return operationAllowed;
    }

    /**
     * Sets the value of the operationAllowed property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOperationAllowed(String value) {
        this.operationAllowed = value;
    }

    /**
     * Gets the value of the shipTo property.
     *
     * @return
     *     possible object is
     *     {@link ShipToType }
     *
     */
    public ShipToType getShipTo() {
        return shipTo;
    }

    /**
     * Sets the value of the shipTo property.
     *
     * @param value
     *     allowed object is
     *     {@link ShipToType }
     *
     */
    public void setShipTo(ShipToType value) {
        this.shipTo = value;
    }

    /**
     * Gets the value of the items property.
     *
     * @return
     *     possible object is
     *     {@link ItemsType }
     *
     */
    public ItemsType getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     *
     * @param value
     *     allowed object is
     *     {@link ItemsType }
     *     
     */
    public void setItems(ItemsType value) {
        this.items = value;
    }

}
