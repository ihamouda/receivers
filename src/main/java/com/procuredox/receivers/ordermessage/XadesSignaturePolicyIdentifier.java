//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.23 at 10:57:51 AM CEST 
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
    "xadesSignaturePolicyIdOrXadesSignaturePolicyImplied"
})
@XmlRootElement(name = "xades:SignaturePolicyIdentifier")
public class XadesSignaturePolicyIdentifier {

    @XmlElements({
        @XmlElement(name = "xades:SignaturePolicyId", required = true, type = XadesSignaturePolicyId.class),
        @XmlElement(name = "xades:SignaturePolicyImplied", required = true, type = XadesSignaturePolicyImplied.class)
    })
    protected List<Object> xadesSignaturePolicyIdOrXadesSignaturePolicyImplied;

    /**
     * Gets the value of the xadesSignaturePolicyIdOrXadesSignaturePolicyImplied property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xadesSignaturePolicyIdOrXadesSignaturePolicyImplied property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXadesSignaturePolicyIdOrXadesSignaturePolicyImplied().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XadesSignaturePolicyId }
     * {@link XadesSignaturePolicyImplied }
     * 
     * 
     */
    public List<Object> getXadesSignaturePolicyIdOrXadesSignaturePolicyImplied() {
        if (xadesSignaturePolicyIdOrXadesSignaturePolicyImplied == null) {
            xadesSignaturePolicyIdOrXadesSignaturePolicyImplied = new ArrayList<Object>();
        }
        return this.xadesSignaturePolicyIdOrXadesSignaturePolicyImplied;
    }

}
