//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.23 at 10:57:51 AM CEST 
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
    "route",
    "shippingContractNumber",
    "shippingInstructions"
})
@XmlRootElement(name = "TransportInformation")
public class TransportInformation {

    @XmlElement(name = "Route")
    protected Route route;
    @XmlElement(name = "ShippingContractNumber")
    protected String shippingContractNumber;
    @XmlElement(name = "ShippingInstructions")
    protected ShippingInstructions shippingInstructions;

    /**
     * Gets the value of the route property.
     * 
     * @return
     *     possible object is
     *     {@link Route }
     *     
     */
    public Route getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     * @param value
     *     allowed object is
     *     {@link Route }
     *     
     */
    public void setRoute(Route value) {
        this.route = value;
    }

    /**
     * Gets the value of the shippingContractNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShippingContractNumber() {
        return shippingContractNumber;
    }

    /**
     * Sets the value of the shippingContractNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShippingContractNumber(String value) {
        this.shippingContractNumber = value;
    }

    /**
     * Gets the value of the shippingInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link ShippingInstructions }
     *     
     */
    public ShippingInstructions getShippingInstructions() {
        return shippingInstructions;
    }

    /**
     * Sets the value of the shippingInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingInstructions }
     *     
     */
    public void setShippingInstructions(ShippingInstructions value) {
        this.shippingInstructions = value;
    }

}
