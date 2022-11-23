package com.techelevator.model;

import java.math.BigDecimal;

public class Sale {

    private int saleId;
    private BigDecimal total;
    private boolean delivery;
    private Integer customerId; // Integer rather than int, because it may be null

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return String.format("Sale %d: $%s (%s)", getSaleId(), getTotal(), isDelivery()? "delivery": "carryout");
    }
}
