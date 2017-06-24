package com.procuredox.receivers;

import java.util.List;

/**
 * Created by ihamouda on 2017-06-23.
 */
public class Order {
    private Double totalAmount;
    private String currency;
    private String operationAllowed;
    private List<Item> items;
    private Integer count;

    public Order(Double totalAmount, String currency, String operationAllowed, List<Item> items, Integer count) {
        this.totalAmount = totalAmount;
        this.currency = currency;
        this.operationAllowed = operationAllowed;
        this.items = items;
        this.count = count;
    }

    public Order() {
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOperationAllowed() {
        return operationAllowed;
    }

    public void setOperationAllowed(String operationAllowed) {
        this.operationAllowed = operationAllowed;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
