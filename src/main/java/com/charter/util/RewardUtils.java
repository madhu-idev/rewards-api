package com.charter.rewardPoints.util;

import java.math.BigDecimal;

public class RewardUtils {

public static int calculatePoints(BigDecimal amount) {

    int points = 0;

    BigDecimal fifty = new BigDecimal("50");
    BigDecimal hundred = new BigDecimal("100");

    if (amount.compareTo(hundred) > 0) {
        
        BigDecimal overHundred = amount.subtract(hundred);
        points += overHundred.multiply(new BigDecimal("2")).intValue();
        points += 50;

    } else if (amount.compareTo(fifty) > 0) {
        
        BigDecimal overFifty = amount.subtract(fifty);
        points += overFifty.intValue();
    }

    return points;
}
}