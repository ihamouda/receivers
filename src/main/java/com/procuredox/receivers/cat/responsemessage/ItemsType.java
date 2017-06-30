
package com.procuredox.receivers.cat.responsemessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for itemsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itemsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="supplierPartId" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="0T0307|CAT"/>
 *               &lt;enumeration value="0R2694|CAT"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="supplierPartAuxiliaryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lineNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="unitPrice" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="15.79"/>
 *               &lt;enumeration value="983.67"/>
 *               &lt;enumeration value="440.97"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="description" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="STUD 0T0307 (CAT) |58826869"/>
 *               &lt;enumeration value="CYL KIT 0R2694 (CAT) |58826869"/>
 *               &lt;enumeration value="CORE DEPOSIT  CYL KIT 0R2694 (CAT) |58826869"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="unitOfMeasure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantity" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="200.0"/>
 *               &lt;enumeration value="1.0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="manufacturerPartId" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="0T0307"/>
 *               &lt;enumeration value="0R2694"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="manufacturerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coreCharge" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="false"/>
 *               &lt;enumeration value="true"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="quantities" type="{}quantitiesType" minOccurs="0"/>
 *         &lt;element name="items" type="{}itemsType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemsType", propOrder = {
    "supplierPartId",
    "supplierPartAuxiliaryId",
    "lineNumber",
    "unitPrice",
    "description",
    "unitOfMeasure",
    "deliveryDate",
    "quantity",
    "comments",
    "manufacturerPartId",
    "manufacturerName",
    "coreCharge",
    "quantities",
    "items"
})
public class ItemsType {

    protected String supplierPartId;
    protected String supplierPartAuxiliaryId;
    protected String lineNumber;
    protected String unitPrice;
    protected String description;
    protected String unitOfMeasure;
    protected String deliveryDate;
    protected String quantity;
    protected String comments;
    protected String manufacturerPartId;
    protected String manufacturerName;
    protected String coreCharge;
    protected QuantitiesType quantities;
    protected List<ItemsType> items;

    /**
     * Gets the value of the supplierPartId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSupplierPartId() {
        return supplierPartId;
    }

    /**
     * Sets the value of the supplierPartId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSupplierPartId(String value) {
        this.supplierPartId = value;
    }

    /**
     * Gets the value of the supplierPartAuxiliaryId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSupplierPartAuxiliaryId() {
        return supplierPartAuxiliaryId;
    }

    /**
     * Sets the value of the supplierPartAuxiliaryId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSupplierPartAuxiliaryId(String value) {
        this.supplierPartAuxiliaryId = value;
    }

    /**
     * Gets the value of the lineNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the value of the lineNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLineNumber(String value) {
        this.lineNumber = value;
    }

    /**
     * Gets the value of the unitPrice property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the value of the unitPrice property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnitPrice(String value) {
        this.unitPrice = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the unitOfMeasure property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Sets the value of the unitOfMeasure property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnitOfMeasure(String value) {
        this.unitOfMeasure = value;
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
     * Gets the value of the comments property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the manufacturerPartId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getManufacturerPartId() {
        return manufacturerPartId;
    }

    /**
     * Sets the value of the manufacturerPartId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setManufacturerPartId(String value) {
        this.manufacturerPartId = value;
    }

    /**
     * Gets the value of the manufacturerName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * Sets the value of the manufacturerName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setManufacturerName(String value) {
        this.manufacturerName = value;
    }

    /**
     * Gets the value of the coreCharge property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCoreCharge() {
        return coreCharge;
    }

    /**
     * Sets the value of the coreCharge property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCoreCharge(String value) {
        this.coreCharge = value;
    }

    /**
     * Gets the value of the quantities property.
     *
     * @return
     *     possible object is
     *     {@link QuantitiesType }
     *
     */
    public QuantitiesType getQuantities() {
        return quantities;
    }

    /**
     * Sets the value of the quantities property.
     *
     * @param value
     *     allowed object is
     *     {@link QuantitiesType }
     *
     */
    public void setQuantities(QuantitiesType value) {
        this.quantities = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemsType }
     * 
     * 
     */
    public List<ItemsType> getItems() {
        if (items == null) {
            items = new ArrayList<ItemsType>();
        }
        return this.items;
    }

}
