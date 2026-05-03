package com.charter.rewardPoints.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private String customerId;
    private BigDecimal amount;
    private LocalDate date;

    public Transaction() {}

    public Transaction(String customerId, BigDecimal amount, LocalDate date) {
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}