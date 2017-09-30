/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.procuredox.receivers.resource.vendor.in;

/**
 * @author itcandox
 */
public class Document {

    private String xmlbody;
    private String securityKey;
    private String xmlName;
    private String session;

    public void setXmlbody(String xmlbody) {
        this.xmlbody = xmlbody;
    }

    public String getXmlbody() {
        return this.xmlbody;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getSecurityKey() {
        return this.securityKey;
    }

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }

    public String getXmlName() {
        return this.xmlName;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getSession() {
        return this.session;
    }

    @Override
    public String toString() {
        return "Document{" +
                "securityKey='" + securityKey + '\'' +
                ", xmlName='" + xmlName + '\'' +
                ", session='" + session + '\'' +
                '}';
    }
}
