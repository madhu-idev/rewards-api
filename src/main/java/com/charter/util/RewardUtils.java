package com.charter.rewardPoints.util;

import java.math.BigDecimal;

public class RewardUtils {

    public static int calculatePoints(BigDecimal amount) {

        int points = 0;
        double amt = amount.doubleValue();

        if (amt > 100) {
            points += (amt - 100) * 2;
            points += 50;
        } else if (amt > 50) {
            points += (amt - 50);
        }

        return points;
    }
}