//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.23 at 11:14:20 AM CEST 
//


package com.procuredox.receivers.ordermessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "internalID"
})
@XmlRootElement(name = "DataAvailableMessage")
public class DataAvailableMessage {

    @XmlElement(name = "InternalID", required = true)
    protected InternalID internalID;

    /**
     * Gets the value of the internalID property.
     * 
     * @return
     *     possible object is
     *     {@link InternalID }
     *     
     */
    public InternalID getInternalID() {
        return internalID;
    }

    /**
     * Sets the value of the internalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalID }
     *     
     */
    public void setInternalID(InternalID value) {
        this.internalID = value;
    }

}
