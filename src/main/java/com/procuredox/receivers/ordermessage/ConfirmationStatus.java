//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.23 at 11:18:10 AM CEST 
//


package com.procuredox.receivers.ordermessage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "unitOfMeasure",
    "itemInOrUnitPriceOrTaxOrShipping",
    "supplierBatchID",
    "comments",
    "extrinsic"
})
@XmlRootElement(name = "ConfirmationStatus")
public class ConfirmationStatus {

    @XmlAttribute(name = "quantity", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String quantity;
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "shipmentDate")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String shipmentDate;
    @XmlAttribute(name = "deliveryDate")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String deliveryDate;
    @XmlElement(name = "UnitOfMeasure", required = true)
    protected UnitOfMeasure unitOfMeasure;
    @XmlElements({
        @XmlElement(name = "ItemIn", type = ItemIn.class),
        @XmlElement(name = "UnitPrice", type = UnitPrice.class),
        @XmlElement(name = "Tax", type = Tax.class),
        @XmlElement(name = "Shipping", type = Shipping.class)
    })
    protected List<Object> itemInOrUnitPriceOrTaxOrShipping;
    @XmlElement(name = "SupplierBatchID")
    protected SupplierBatchID supplierBatchID;
    @XmlElement(name = "Comments")
    protected List<Comments> comments;
    @XmlElement(name = "Extrinsic")
    protected List<Extrinsic> extrinsic;

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantity(String value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the shipmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipmentDate() {
        return shipmentDate;
    }

    /**
     * Sets the value of the shipmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipmentDate(String value) {
        this.shipmentDate = value;
    }

    /**
     * Gets the value of the deliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the value of the deliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryDate(String value) {
        this.deliveryDate = value;
    }

    /**
     * Gets the value of the unitOfMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link UnitOfMeasure }
     *     
     */
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Sets the value of the unitOfMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitOfMeasure }
     *     
     */
    public void setUnitOfMeasure(UnitOfMeasure value) {
        this.unitOfMeasure = value;
    }

    /**
     * Gets the value of the itemInOrUnitPriceOrTaxOrShipping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemInOrUnitPriceOrTaxOrShipping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemInOrUnitPriceOrTaxOrShipping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemIn }
     * {@link UnitPrice }
     * {@link Tax }
     * {@link Shipping }
     * 
     * 
     */
    public List<Object> getItemInOrUnitPriceOrTaxOrShipping() {
        if (itemInOrUnitPriceOrTaxOrShipping == null) {
            itemInOrUnitPriceOrTaxOrShipping = new ArrayList<Object>();
        }
        return this.itemInOrUnitPriceOrTaxOrShipping;
    }

    /**
     * Gets the value of the supplierBatchID property.
     * 
     * @return
     *     possible object is
     *     {@link SupplierBatchID }
     *     
     */
    public SupplierBatchID getSupplierBatchID() {
        return supplierBatchID;
    }

    /**
     * Sets the value of the supplierBatchID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierBatchID }
     *     
     */
    public void setSupplierBatchID(SupplierBatchID value) {
        this.supplierBatchID = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Comments }
     * 
     * 
     */
    public List<Comments> getComments() {
        if (comments == null) {
            comments = new ArrayList<Comments>();
        }
        return this.comments;
    }

    /**
     * Gets the value of the extrinsic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extrinsic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtrinsic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extrinsic }
     * 
     * 
     */
    public List<Extrinsic> getExtrinsic() {
        if (extrinsic == null) {
            extrinsic = new ArrayList<Extrinsic>();
        }
        return this.extrinsic;
    }

}
