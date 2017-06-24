//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.23 at 11:07:02 AM CEST 
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
    "typeProvider",
    "comments",
    "primitiveTypeOrType"
})
@XmlRootElement(name = "TypeDefinition")
public class TypeDefinition {

    @XmlElement(name = "TypeProvider", required = true)
    protected TypeProvider typeProvider;
    @XmlElement(name = "Comments")
    protected Comments comments;
    @XmlElements({
        @XmlElement(name = "PrimitiveType", required = true, type = PrimitiveType.class),
        @XmlElement(name = "Type", required = true, type = Type.class)
    })
    protected List<Object> primitiveTypeOrType;

    /**
     * Gets the value of the typeProvider property.
     * 
     * @return
     *     possible object is
     *     {@link TypeProvider }
     *     
     */
    public TypeProvider getTypeProvider() {
        return typeProvider;
    }

    /**
     * Sets the value of the typeProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeProvider }
     *     
     */
    public void setTypeProvider(TypeProvider value) {
        this.typeProvider = value;
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

    /**
     * Gets the value of the primitiveTypeOrType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the primitiveTypeOrType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrimitiveTypeOrType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrimitiveType }
     * {@link Type }
     * 
     * 
     */
    public List<Object> getPrimitiveTypeOrType() {
        if (primitiveTypeOrType == null) {
            primitiveTypeOrType = new ArrayList<Object>();
        }
        return this.primitiveTypeOrType;
    }

}
