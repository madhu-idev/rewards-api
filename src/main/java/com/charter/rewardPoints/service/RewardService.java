package com.charter.rewardPoints.service;

import com.charter.rewardPoints.model.*;
import com.charter.rewardPoints.repository.TransactionRepository;
import com.charter.rewardPoints.util.RewardUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RewardService {

    private final TransactionRepository repository;

    public RewardResponse getRewards(String customerId,
                                     LocalDate startDate,
                                     LocalDate endDate) {

        if (customerId == null || customerId.isEmpty())
            throw new IllegalArgumentException("Invalid customerId");

        if (startDate == null || endDate == null)
            throw new IllegalArgumentException("Dates cannot be null");

        if (startDate.isAfter(endDate))
            throw new IllegalArgumentException("Start date must be before end date");

        if (endDate.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Future dates not allowed");

        List<Transaction> transactions = repository.getAllTransactions();

        Map<String, Integer> monthlyPoints = new HashMap<>();
        int totalPoints = 0;

        for (Transaction t : transactions) {

            if (!t.getCustomerId().equals(customerId)) continue;
            if (t.getDate().isBefore(startDate) || t.getDate().isAfter(endDate)) continue;

            int points = RewardUtils.calculatePoints(t.getAmount());
            String month = t.getDate().getMonth().toString();

            monthlyPoints.put(month,
                    monthlyPoints.getOrDefault(month, 0) + points);

            totalPoints += points;
        }

        return new RewardResponse(customerId, monthlyPoints, totalPoints);
    }
}