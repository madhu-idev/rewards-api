package com.example.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RewardServiceTest {

    RewardService service = new RewardService();

    @Test
    void testBelow50() {
        assertEquals(0, service.calculatePoints(40));
    }

    @Test
    void testBetween50And100() {
        assertEquals(25, service.calculatePoints(75));
    }

    @Test
    void testAbove100() {
        assertEquals(90, service.calculatePoints(120));
    }

    @Test
    void testInvalidMonths() {
        assertThrows(IllegalArgumentException.class,
                () -> service.getRewards("1", 0)) ;
    }
}