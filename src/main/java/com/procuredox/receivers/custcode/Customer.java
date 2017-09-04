package com.procuredox.receivers.custcode;

public class Customer {
    private String CustomerName;
    private String CustomerId;

    public Customer(String customerId, String customerName) {
        CustomerName = customerName;
        CustomerId = customerId;
    }

    public Customer() {
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }
}
