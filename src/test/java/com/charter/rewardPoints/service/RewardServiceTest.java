package com.charter.rewardPoints.service;

import com.charter.rewardPoints.util.RewardUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RewardServiceTest {

    @Test
    void testBelow50() {
        assertEquals(0, RewardUtils.calculatePoints(new BigDecimal("40")));
    }

    @Test
    void testBoundary50() {
        assertEquals(0, RewardUtils.calculatePoints(new BigDecimal("50")));
    }

    @Test
    void testBoundary100() {
        assertEquals(50, RewardUtils.calculatePoints(new BigDecimal("100")));
    }

    @Test
    void testAbove100() {
        assertEquals(90, RewardUtils.calculatePoints(new BigDecimal("120")));
    }
}