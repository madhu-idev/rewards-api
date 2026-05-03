package com.charter.rewardPoints.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class RewardResponse {
    private String customerId;
    private Map<String, Integer> monthlyPoints;
    private int totalPoints;
}