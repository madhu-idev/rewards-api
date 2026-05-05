package com.charter.rewardPoints.service;

import com.charter.rewardPoints.model.RewardResponse;
import com.charter.rewardPoints.repository.TransactionRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RewardServiceTest {

    private final RewardService service =
            new RewardService(new TransactionRepository());

    @Test
    void testValidCustomer() {
        RewardResponse response = service.getRewards(
                "1",
                LocalDate.now().minusMonths(3),
                LocalDate.now());

        assertNotNull(response);
        assertTrue(response.getTotalPoints() > 0);
    }

    @Test
    void testCustomerWithNoTransactions() {
        RewardResponse response = service.getRewards(
                "999",
                LocalDate.now().minusMonths(3),
                LocalDate.now());

        assertEquals(0, response.getTotalPoints());
    }

    @Test
    void testInvalidCustomerId() {
        assertThrows(IllegalArgumentException.class, () ->
                service.getRewards("", LocalDate.now(), LocalDate.now()));
    }

    @Test
    void testNullDates() {
        assertThrows(IllegalArgumentException.class, () ->
                service.getRewards("1", null, null));
    }

    @Test
    void testStartDateAfterEndDate() {
        assertThrows(IllegalArgumentException.class, () ->
                service.getRewards("1",
                        LocalDate.now(),
                        LocalDate.now().minusDays(1)));
    }

    @Test
    void testFutureDates() {
        assertThrows(IllegalArgumentException.class, () ->
                service.getRewards("1",
                        LocalDate.now().minusDays(10),
                        LocalDate.now().plusDays(10)));
    }

    @Test
    void testFutureDateValidation() {
        assertThrows(IllegalArgumentException.class, () ->
            service.getRewards("1",
                    LocalDate.now(),
                    LocalDate.now().plusDays(5)));
    }

    @Test
    void testMultipleCustomersData() {
        assertNotNull(service.getRewards(
            "5",
            LocalDate.now().minusMonths(3),
            LocalDate.now()));
    }
}