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
    "itemReference",
    "comments"
})
@XmlRootElement(name = "OrderStatusRequestItem")
public class OrderStatusRequestItem {

    @XmlElement(name = "ItemReference", required = true)
    protected ItemReference itemReference;
    @XmlElement(name = "Comments")
    protected Comments comments;

    /**
     * Gets the value of the itemReference property.
     * 
     * @return
     *     possible object is
     *     {@link ItemReference }
     *     
     */
    public ItemReference getItemReference() {
        return itemReference;
    }

    /**
     * Sets the value of the itemReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemReference }
     *     
     */
    public void setItemReference(ItemReference value) {
        this.itemReference = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link Comments }
     *     
     */
    public Comments getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Comments }
     *     
     */
    public void setComments(Comments value) {
        this.comments = value;
    }

}
