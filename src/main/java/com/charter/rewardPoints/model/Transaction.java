package com.charter.rewardPoints.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Transaction {
    private String customerId;
    private BigDecimal amount;
    private LocalDate date;
}