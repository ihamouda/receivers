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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "itemID",
    "shipNoticeItemDetail",
    "unitOfMeasure",
    "packaging",
    "hazard",
    "batchOrSupplierBatchID",
    "assetInfo",
    "termsOfDelivery",
    "orderedQuantity",
    "shipNoticeItemIndustry",
    "componentConsumptionDetails",
    "extrinsic"
})
@XmlRootElement(name = "ShipNoticeItem")
public class ShipNoticeItem {

    @XmlAttribute(name = "quantity", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String quantity;
    @XmlAttribute(name = "lineNumber", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String lineNumber;
    @XmlAttribute(name = "parentLineNumber")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String parentLineNumber;
    @XmlAttribute(name = "shipNoticeLineNumber")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String shipNoticeLineNumber;
    @XmlAttribute(name = "itemType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String itemType;
    @XmlAttribute(name = "compositeItemType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String compositeItemType;
    @XmlElement(name = "ItemID")
    protected ItemID itemID;
    @XmlElement(name = "ShipNoticeItemDetail")
    protected ShipNoticeItemDetail shipNoticeItemDetail;
    @XmlElement(name = "UnitOfMeasure", required = true)
    protected UnitOfMeasure unitOfMeasure;
    @XmlElement(name = "Packaging")
    protected List<Packaging> packaging;
    @XmlElement(name = "Hazard")
    protected List<Hazard> hazard;
    @XmlElements({
        @XmlElement(name = "Batch", type = Batch.class),
        @XmlElement(name = "SupplierBatchID", type = SupplierBatchID.class)
    })
    protected List<Object> batchOrSupplierBatchID;
    @XmlElement(name = "AssetInfo")
    protected List<AssetInfo> assetInfo;
    @XmlElement(name = "TermsOfDelivery")
    protected TermsOfDelivery termsOfDelivery;
    @XmlElement(name = "OrderedQuantity")
    protected OrderedQuantity orderedQuantity;
    @XmlElement(name = "ShipNoticeItemIndustry")
    protected ShipNoticeItemIndustry shipNoticeItemIndustry;
    @XmlElement(name = "ComponentConsumptionDetails")
    protected List<ComponentConsumptionDetails> componentConsumptionDetails;
    @XmlElement(name = "Extrinsic")
    protected List<Extrinsic> extrinsic;

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantity(String value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the lineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the value of the lineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineNumber(String value) {
        this.lineNumber = value;
    }

    /**
     * Gets the value of the parentLineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentLineNumber() {
        return parentLineNumber;
    }

    /**
     * Sets the value of the parentLineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentLineNumber(String value) {
        this.parentLineNumber = value;
    }

    /**
     * Gets the value of the shipNoticeLineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipNoticeLineNumber() {
        return shipNoticeLineNumber;
    }

    /**
     * Sets the value of the shipNoticeLineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipNoticeLineNumber(String value) {
        this.shipNoticeLineNumber = value;
    }

    /**
     * Gets the value of the itemType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * Sets the value of the itemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemType(String value) {
        this.itemType = value;
    }

    /**
     * Gets the value of the compositeItemType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompositeItemType() {
        return compositeItemType;
    }

    /**
     * Sets the value of the compositeItemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompositeItemType(String value) {
        this.compositeItemType = value;
    }

    /**
     * Gets the value of the itemID property.
     * 
     * @return
     *     possible object is
     *     {@link ItemID }
     *     
     */
    public ItemID getItemID() {
        return itemID;
    }

    /**
     * Sets the value of the itemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemID }
     *     
     */
    public void setItemID(ItemID value) {
        this.itemID = value;
    }

    /**
     * Gets the value of the shipNoticeItemDetail property.
     * 
     * @return
     *     possible object is
     *     {@link ShipNoticeItemDetail }
     *     
     */
    public ShipNoticeItemDetail getShipNoticeItemDetail() {
        return shipNoticeItemDetail;
    }

    /**
     * Sets the value of the shipNoticeItemDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipNoticeItemDetail }
     *     
     */
    public void setShipNoticeItemDetail(ShipNoticeItemDetail value) {
        this.shipNoticeItemDetail = value;
    }

    /**
     * Gets the value of the unitOfMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link UnitOfMeasure }
     *     
     */
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Sets the value of the unitOfMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitOfMeasure }
     *     
     */
    public void setUnitOfMeasure(UnitOfMeasure value) {
        this.unitOfMeasure = value;
    }

    /**
     * Gets the value of the packaging property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packaging property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackaging().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Packaging }
     * 
     * 
     */
    public List<Packaging> getPackaging() {
        if (packaging == null) {
            packaging = new ArrayList<Packaging>();
        }
        return this.packaging;
    }

    /**
     * Gets the value of the hazard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hazard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHazard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Hazard }
     * 
     * 
     */
    public List<Hazard> getHazard() {
        if (hazard == null) {
            hazard = new ArrayList<Hazard>();
        }
        return this.hazard;
    }

    /**
     * Gets the value of the batchOrSupplierBatchID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the batchOrSupplierBatchID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBatchOrSupplierBatchID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Batch }
     * {@link SupplierBatchID }
     * 
     * 
     */
    public List<Object> getBatchOrSupplierBatchID() {
        if (batchOrSupplierBatchID == null) {
            batchOrSupplierBatchID = new ArrayList<Object>();
        }
        return this.batchOrSupplierBatchID;
    }

    /**
     * Gets the value of the assetInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assetInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssetInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssetInfo }
     * 
     * 
     */
    public List<AssetInfo> getAssetInfo() {
        if (assetInfo == null) {
            assetInfo = new ArrayList<AssetInfo>();
        }
        return this.assetInfo;
    }

    /**
     * Gets the value of the termsOfDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link TermsOfDelivery }
     *     
     */
    public TermsOfDelivery getTermsOfDelivery() {
        return termsOfDelivery;
    }

    /**
     * Sets the value of the termsOfDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link TermsOfDelivery }
     *     
     */
    public void setTermsOfDelivery(TermsOfDelivery value) {
        this.termsOfDelivery = value;
    }

    /**
     * Gets the value of the orderedQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link OrderedQuantity }
     *     
     */
    public OrderedQuantity getOrderedQuantity() {
        return orderedQuantity;
    }

    /**
     * Sets the value of the orderedQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderedQuantity }
     *     
     */
    public void setOrderedQuantity(OrderedQuantity value) {
        this.orderedQuantity = value;
    }

    /**
     * Gets the value of the shipNoticeItemIndustry property.
     * 
     * @return
     *     possible object is
     *     {@link ShipNoticeItemIndustry }
     *     
     */
    public ShipNoticeItemIndustry getShipNoticeItemIndustry() {
        return shipNoticeItemIndustry;
    }

    /**
     * Sets the value of the shipNoticeItemIndustry property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipNoticeItemIndustry }
     *     
     */
    public void setShipNoticeItemIndustry(ShipNoticeItemIndustry value) {
        this.shipNoticeItemIndustry = value;
    }

    /**
     * Gets the value of the componentConsumptionDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the componentConsumptionDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponentConsumptionDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComponentConsumptionDetails }
     * 
     * 
     */
    public List<ComponentConsumptionDetails> getComponentConsumptionDetails() {
        if (componentConsumptionDetails == null) {
            componentConsumptionDetails = new ArrayList<ComponentConsumptionDetails>();
        }
        return this.componentConsumptionDetails;
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
