package com.procuredox.receivers.cat;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by ihamouda on 2017-06-27.
 */
public class Address {
    @JacksonXmlProperty(localName = "street")
    private String street;
    @JacksonXmlProperty(localName = "city")
    private String city;
    @JacksonXmlProperty(localName = "province")
    private String province;
    @JacksonXmlProperty(localName = "postalCode")
    private String postalCode;
    @JacksonXmlProperty(localName = "country")
    private String country;

    public Address(String street, String city, String province, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
