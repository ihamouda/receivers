//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.23 at 10:57:51 AM CEST 
//


package com.procuredox.receivers.ordermessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "documentReference"
})
@XmlRootElement(name = "ServiceEntryItemReference")
public class ServiceEntryItemReference {

    @XmlAttribute(name = "serviceLineNumber", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String serviceLineNumber;
    @XmlAttribute(name = "serviceEntryID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String serviceEntryID;
    @XmlAttribute(name = "serviceEntryDate")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String serviceEntryDate;
    @XmlElement(name = "DocumentReference", required = true)
    protected DocumentReference documentReference;

    /**
     * Gets the value of the serviceLineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceLineNumber() {
        return serviceLineNumber;
    }

    /**
     * Sets the value of the serviceLineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceLineNumber(String value) {
        this.serviceLineNumber = value;
    }

    /**
     * Gets the value of the serviceEntryID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceEntryID() {
        return serviceEntryID;
    }

    /**
     * Sets the value of the serviceEntryID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceEntryID(String value) {
        this.serviceEntryID = value;
    }

    /**
     * Gets the value of the serviceEntryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceEntryDate() {
        return serviceEntryDate;
    }

    /**
     * Sets the value of the serviceEntryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceEntryDate(String value) {
        this.serviceEntryDate = value;
    }

    /**
     * Gets the value of the documentReference property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReference }
     *     
     */
    public DocumentReference getDocumentReference() {
        return documentReference;
    }

    /**
     * Sets the value of the documentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReference }
     *     
     */
    public void setDocumentReference(DocumentReference value) {
        this.documentReference = value;
    }

}
