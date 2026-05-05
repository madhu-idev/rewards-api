package com.charter.rewardPoints.util;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class RewardUtilsTest {

    @Test
    void testBelow50() {
        assertEquals(0, RewardUtils.calculatePoints(new BigDecimal("30")));
    }

    @Test
    void testExactly50() {
        assertEquals(0, RewardUtils.calculatePoints(new BigDecimal("50")));
    }

    @Test
    void testBetween50And100() {
        assertEquals(20, RewardUtils.calculatePoints(new BigDecimal("70")));
    }

    @Test
    void testExactly100() {
        assertEquals(50, RewardUtils.calculatePoints(new BigDecimal("100")));
    }

    @Test
    void testAbove100() {
        assertEquals(90, RewardUtils.calculatePoints(new BigDecimal("120")));
    }

    @Test
    void testBigDecimalPrecision() {
        assertEquals(90,RewardUtils.calculatePoints(new BigDecimal("120")));
    }
    
    @Test
    void testHighAmount() {
        assertEquals(250, RewardUtils.calculatePoints(new BigDecimal("200")));
    }

    @Test
    void testZeroAmount() {
        assertEquals(0, RewardUtils.calculatePoints(new BigDecimal("0")));
    }

    @Test
    void testNegativeAmount() {
        assertEquals(0, RewardUtils.calculatePoints(new BigDecimal("-10")));
    }
}