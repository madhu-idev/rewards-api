package com.charter.rewardPoints.repository;

import com.charter.rewardPoints.model.Transaction;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public class TransactionRepository {

    public List<Transaction> getAllTransactions() {
    return Arrays.asList(

        // Customer 1
        new Transaction("1", new BigDecimal("120"), LocalDate.now().minusMonths(1)),
        new Transaction("1", new BigDecimal("75"), LocalDate.now().minusMonths(2)),
        new Transaction("1", new BigDecimal("200"), LocalDate.now().minusMonths(3)),

        // Customer 2
        new Transaction("2", new BigDecimal("50"), LocalDate.now().minusMonths(1)),
        new Transaction("2", new BigDecimal("180"), LocalDate.now().minusMonths(2)),

        // Customer 3
        new Transaction("3", new BigDecimal("90"), LocalDate.now().minusMonths(1)),
        new Transaction("3", new BigDecimal("40"), LocalDate.now().minusMonths(2)),

        // Customer 4
        new Transaction("4", new BigDecimal("220"), LocalDate.now().minusMonths(1)),
        new Transaction("4", new BigDecimal("130"), LocalDate.now().minusMonths(3)),

        // Customer 5
        new Transaction("5", new BigDecimal("60"), LocalDate.now().minusMonths(2)),
        new Transaction("5", new BigDecimal("300"), LocalDate.now().minusMonths(3)),

        // Customer 6
        new Transaction("6", new BigDecimal("45"), LocalDate.now().minusMonths(1)),
        new Transaction("6", new BigDecimal("150"), LocalDate.now().minusMonths(2)),

        // Customer 7
        new Transaction("7", new BigDecimal("500"), LocalDate.now().minusMonths(1)),
        new Transaction("7", new BigDecimal("80"), LocalDate.now().minusMonths(3))

    );
}
}