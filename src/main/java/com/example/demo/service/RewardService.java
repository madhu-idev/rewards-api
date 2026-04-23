package com.example.demo.service;

import com.example.demo.model.Transaction;
import com.example.demo.model.RewardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
public class RewardService {

    private static final Logger logger =
            LoggerFactory.getLogger(RewardService.class);

    public int calculatePoints(double amount) {
        int points = 0;

        if (amount > 100) {
            points += (amount - 100) * 2;
            points += 50;
        } else if (amount > 50) {
            points += (amount - 50);
        }

        return points;
    }

    public RewardResponse getRewards(String customerId, int months) {

        logger.info("Calculating rewards for customer {}", customerId);

        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be empty");
        }

        if (months <= 0) {
            throw new IllegalArgumentException("Months must be greater than 0");
        }

        List<Transaction> transactions = getDummyData();

        Map<String, Integer> monthlyPoints = new HashMap<>();
        int totalPoints = 0;

        LocalDate cutoffDate = LocalDate.now().minusMonths(months);

        for (Transaction t : transactions) {

            if (!t.getCustomerId().equals(customerId)) continue;
            if (t.getDate().isBefore(cutoffDate)) continue;

            int points = calculatePoints(t.getAmount());
            String month = t.getDate().getMonth().toString();

            monthlyPoints.put(
                month,
                monthlyPoints.getOrDefault(month, 0) + points
            );

            totalPoints += points;
        }

        return new RewardResponse(customerId, monthlyPoints, totalPoints);
    }

    // Async simulation
    @Async
    public CompletableFuture<RewardResponse> getRewardsAsync(String customerId, int months) {
        return CompletableFuture.completedFuture(getRewards(customerId, months));
    }

    private List<Transaction> getDummyData() {
        return List.of(
            new Transaction("1", 120, LocalDate.now().minusMonths(1)),
            new Transaction("1", 75, LocalDate.now().minusMonths(2)),
            new Transaction("1", 200, LocalDate.now()),
            new Transaction("2", 50, LocalDate.now())
        );
    }
}