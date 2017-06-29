
package com.procuredox.receivers.responsemessage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ordermessage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Order_QNAME = new QName("", "Order");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ordermessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderType }
     * 
     */
    public OrderType createOrderType() {
        return new OrderType();
    }

    /**
     * Create an instance of {@link QuantitiesType }
     *
     */
    public QuantitiesType createQuantitiesType() {
        return new QuantitiesType();
    }

    /**
     * Create an instance of {@link AddressType }
     *
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link ItemsType }
     *
     */
    public ItemsType createItemsType() {
        return new ItemsType();
    }

    /**
     * Create an instance of {@link ShipToType }
     *
     */
    public ShipToType createShipToType() {
        return new ShipToType();
    }

    /**
     * Create an instance of {@link SpecialInstructionsType }
     *
     */
    public SpecialInstructionsType createSpecialInstructionsType() {
        return new SpecialInstructionsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Order")
    public JAXBElement<OrderType> createOrder(OrderType value) {
        return new JAXBElement<OrderType>(_Order_QNAME, OrderType.class, null, value);
    }

}
