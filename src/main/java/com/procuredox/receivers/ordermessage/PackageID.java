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
    "globalIndividualAssetID",
    "returnablePackageID",
    "packageTrackingID"
})
@XmlRootElement(name = "PackageID")
public class PackageID {

    @XmlElement(name = "GlobalIndividualAssetID")
    protected String globalIndividualAssetID;
    @XmlElement(name = "ReturnablePackageID")
    protected String returnablePackageID;
    @XmlElement(name = "PackageTrackingID")
    protected String packageTrackingID;

    /**
     * Gets the value of the globalIndividualAssetID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlobalIndividualAssetID() {
        return globalIndividualAssetID;
    }

    /**
     * Sets the value of the globalIndividualAssetID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlobalIndividualAssetID(String value) {
        this.globalIndividualAssetID = value;
    }

    /**
     * Gets the value of the returnablePackageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnablePackageID() {
        return returnablePackageID;
    }

    /**
     * Sets the value of the returnablePackageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnablePackageID(String value) {
        this.returnablePackageID = value;
    }

    /**
     * Gets the value of the packageTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageTrackingID() {
        return packageTrackingID;
    }

    /**
     * Sets the value of the packageTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageTrackingID(String value) {
        this.packageTrackingID = value;
    }

}
