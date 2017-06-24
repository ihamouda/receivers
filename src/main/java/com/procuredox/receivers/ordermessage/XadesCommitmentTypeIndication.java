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
    "xadesCommitmentTypeId",
    "xadesObjectReferenceOrXadesAllSignedDataObjects",
    "xadesCommitmentTypeQualifiers"
})
@XmlRootElement(name = "xades:CommitmentTypeIndication")
public class XadesCommitmentTypeIndication {

    @XmlElement(name = "xades:CommitmentTypeId", required = true)
    protected XadesCommitmentTypeId xadesCommitmentTypeId;
    @XmlElements({
        @XmlElement(name = "xades:ObjectReference", required = true, type = XadesObjectReference.class),
        @XmlElement(name = "xades:AllSignedDataObjects", required = true, type = XadesAllSignedDataObjects.class)
    })
    protected List<Object> xadesObjectReferenceOrXadesAllSignedDataObjects;
    @XmlElement(name = "xades:CommitmentTypeQualifiers")
    protected XadesCommitmentTypeQualifiers xadesCommitmentTypeQualifiers;

    /**
     * Gets the value of the xadesCommitmentTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link XadesCommitmentTypeId }
     *     
     */
    public XadesCommitmentTypeId getXadesCommitmentTypeId() {
        return xadesCommitmentTypeId;
    }

    /**
     * Sets the value of the xadesCommitmentTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link XadesCommitmentTypeId }
     *     
     */
    public void setXadesCommitmentTypeId(XadesCommitmentTypeId value) {
        this.xadesCommitmentTypeId = value;
    }

    /**
     * Gets the value of the xadesObjectReferenceOrXadesAllSignedDataObjects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xadesObjectReferenceOrXadesAllSignedDataObjects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXadesObjectReferenceOrXadesAllSignedDataObjects().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XadesObjectReference }
     * {@link XadesAllSignedDataObjects }
     * 
     * 
     */
    public List<Object> getXadesObjectReferenceOrXadesAllSignedDataObjects() {
        if (xadesObjectReferenceOrXadesAllSignedDataObjects == null) {
            xadesObjectReferenceOrXadesAllSignedDataObjects = new ArrayList<Object>();
        }
        return this.xadesObjectReferenceOrXadesAllSignedDataObjects;
    }

    /**
     * Gets the value of the xadesCommitmentTypeQualifiers property.
     * 
     * @return
     *     possible object is
     *     {@link XadesCommitmentTypeQualifiers }
     *     
     */
    public XadesCommitmentTypeQualifiers getXadesCommitmentTypeQualifiers() {
        return xadesCommitmentTypeQualifiers;
    }

    /**
     * Sets the value of the xadesCommitmentTypeQualifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link XadesCommitmentTypeQualifiers }
     *     
     */
    public void setXadesCommitmentTypeQualifiers(XadesCommitmentTypeQualifiers value) {
        this.xadesCommitmentTypeQualifiers = value;
    }

}
