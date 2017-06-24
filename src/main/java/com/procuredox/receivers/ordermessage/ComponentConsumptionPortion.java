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
    "orderReference",
    "masterAgreementReferenceOrMasterAgreementIDInfo",
    "componentConsumptionItem",
    "extrinsic"
})
@XmlRootElement(name = "ComponentConsumptionPortion")
public class ComponentConsumptionPortion {

    @XmlElement(name = "OrderReference", required = true)
    protected OrderReference orderReference;
    @XmlElements({
        @XmlElement(name = "MasterAgreementReference", type = MasterAgreementReference.class),
        @XmlElement(name = "MasterAgreementIDInfo", type = MasterAgreementIDInfo.class)
    })
    protected List<Object> masterAgreementReferenceOrMasterAgreementIDInfo;
    @XmlElement(name = "ComponentConsumptionItem")
    protected List<ComponentConsumptionItem> componentConsumptionItem;
    @XmlElement(name = "Extrinsic")
    protected List<Extrinsic> extrinsic;

    /**
     * Gets the value of the orderReference property.
     * 
     * @return
     *     possible object is
     *     {@link OrderReference }
     *     
     */
    public OrderReference getOrderReference() {
        return orderReference;
    }

    /**
     * Sets the value of the orderReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderReference }
     *     
     */
    public void setOrderReference(OrderReference value) {
        this.orderReference = value;
    }

    /**
     * Gets the value of the masterAgreementReferenceOrMasterAgreementIDInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the masterAgreementReferenceOrMasterAgreementIDInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMasterAgreementReferenceOrMasterAgreementIDInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MasterAgreementReference }
     * {@link MasterAgreementIDInfo }
     * 
     * 
     */
    public List<Object> getMasterAgreementReferenceOrMasterAgreementIDInfo() {
        if (masterAgreementReferenceOrMasterAgreementIDInfo == null) {
            masterAgreementReferenceOrMasterAgreementIDInfo = new ArrayList<Object>();
        }
        return this.masterAgreementReferenceOrMasterAgreementIDInfo;
    }

    /**
     * Gets the value of the componentConsumptionItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the componentConsumptionItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponentConsumptionItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComponentConsumptionItem }
     * 
     * 
     */
    public List<ComponentConsumptionItem> getComponentConsumptionItem() {
        if (componentConsumptionItem == null) {
            componentConsumptionItem = new ArrayList<ComponentConsumptionItem>();
        }
        return this.componentConsumptionItem;
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
