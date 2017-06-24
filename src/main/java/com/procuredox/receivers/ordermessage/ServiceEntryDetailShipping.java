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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contactOrCarrierIdentifierOrShipmentIdentifierOrDocumentReference"
})
@XmlRootElement(name = "ServiceEntryDetailShipping")
public class ServiceEntryDetailShipping {

    @XmlElements({
        @XmlElement(name = "Contact", type = Contact.class),
        @XmlElement(name = "CarrierIdentifier", type = CarrierIdentifier.class),
        @XmlElement(name = "ShipmentIdentifier", type = ShipmentIdentifier.class),
        @XmlElement(name = "DocumentReference", type = DocumentReference.class)
    })
    protected List<Object> contactOrCarrierIdentifierOrShipmentIdentifierOrDocumentReference;

    /**
     * Gets the value of the contactOrCarrierIdentifierOrShipmentIdentifierOrDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactOrCarrierIdentifierOrShipmentIdentifierOrDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactOrCarrierIdentifierOrShipmentIdentifierOrDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Contact }
     * {@link CarrierIdentifier }
     * {@link ShipmentIdentifier }
     * {@link DocumentReference }
     * 
     * 
     */
    public List<Object> getContactOrCarrierIdentifierOrShipmentIdentifierOrDocumentReference() {
        if (contactOrCarrierIdentifierOrShipmentIdentifierOrDocumentReference == null) {
            contactOrCarrierIdentifierOrShipmentIdentifierOrDocumentReference = new ArrayList<Object>();
        }
        return this.contactOrCarrierIdentifierOrShipmentIdentifierOrDocumentReference;
    }

}
