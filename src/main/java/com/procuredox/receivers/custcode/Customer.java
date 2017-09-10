package com.procuredox.receivers.custcode;

public class Customer {
    private String CustometName;
    private String CustomerId;

    public Customer(String custometName, String customerId) {
        CustometName = custometName;
        CustomerId = customerId;
    }

    public Customer() {
    }

    public String getCustometName() {
        return CustometName;
    }

    public void setCustometName(String custometName) {
        CustometName = custometName;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }
}
