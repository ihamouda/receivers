//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.23 at 11:18:10 AM CEST 
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
    "timeCard"
})
@XmlRootElement(name = "TimeCardInfoRequest")
public class TimeCardInfoRequest {

    @XmlElement(name = "TimeCard", required = true)
    protected TimeCard timeCard;

    /**
     * Gets the value of the timeCard property.
     * 
     * @return
     *     possible object is
     *     {@link TimeCard }
     *     
     */
    public TimeCard getTimeCard() {
        return timeCard;
    }

    /**
     * Sets the value of the timeCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeCard }
     *     
     */
    public void setTimeCard(TimeCard value) {
        this.timeCard = value;
    }

}