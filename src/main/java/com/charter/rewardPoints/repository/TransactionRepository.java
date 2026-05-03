package com.charter.rewardPoints.repository;

import com.charter.rewardPoints.model.Transaction;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionRepository {

    public List<Transaction> getAllTransactions() {
        return List.of(
            new Transaction("1", new BigDecimal("120"), LocalDate.now().minusMonths(1)),
            new Transaction("1", new BigDecimal("75"), LocalDate.now().minusMonths(2)),
            new Transaction("1", new BigDecimal("200"), LocalDate.now()),
            new Transaction("2", new BigDecimal("50"), LocalDate.now()),
            new Transaction("2", new BigDecimal("180"), LocalDate.now().minusMonths(1)),
            new Transaction("3", new BigDecimal("90"), LocalDate.now().minusMonths(3))
        );
    }
}