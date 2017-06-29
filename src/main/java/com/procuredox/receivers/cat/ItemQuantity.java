package com.procuredox.receivers.cat;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by ihamouda on 2017-06-27.
 */

public class ItemQuantity {
    @JacksonXmlProperty(localName = "quantity")
    private Double quantity;
    @JacksonXmlProperty(localName = "location")
    private String location;

    public ItemQuantity(Double quantity, String location) {
        this.quantity = quantity;
        this.location = location;
    }

    public ItemQuantity() {
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
