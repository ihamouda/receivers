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
    "comments",
    "extrinsic"
})
@XmlRootElement(name = "ComponentConsumptionHeader")
public class ComponentConsumptionHeader {

    @XmlAttribute(name = "consumptionID", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String consumptionID;
    @XmlAttribute(name = "operation", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String operation;
    @XmlAttribute(name = "referenceDocumentID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String referenceDocumentID;
    @XmlAttribute(name = "creationDate")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String creationDate;
    @XmlAttribute(name = "lastChangeDate")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String lastChangeDate;
    @XmlElement(name = "Comments")
    protected List<Comments> comments;
    @XmlElement(name = "Extrinsic")
    protected List<Extrinsic> extrinsic;

    /**
     * Gets the value of the consumptionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsumptionID() {
        return consumptionID;
    }

    /**
     * Sets the value of the consumptionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsumptionID(String value) {
        this.consumptionID = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the referenceDocumentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceDocumentID() {
        return referenceDocumentID;
    }

    /**
     * Sets the value of the referenceDocumentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceDocumentID(String value) {
        this.referenceDocumentID = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDate(String value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the lastChangeDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastChangeDate() {
        return lastChangeDate;
    }

    /**
     * Sets the value of the lastChangeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastChangeDate(String value) {
        this.lastChangeDate = value;
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
