package com.charter.rewardPoints.controller;

import com.charter.rewardPoints.model.RewardResponse;
import com.charter.rewardPoints.service.RewardService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RewardController.class)
public class RewardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean   
    private RewardService rewardService;

    @Test
    void testGetRewardsSuccess() throws Exception {

        RewardResponse mockResponse =
                new RewardResponse("1", new HashMap<>(), 100);

        when(rewardService.getRewards(
                org.mockito.ArgumentMatchers.eq("1"),
                org.mockito.ArgumentMatchers.any(),
                org.mockito.ArgumentMatchers.any()))
                .thenReturn(mockResponse);

        mockMvc.perform(get("/api/rewards")
                        .param("customerId", "1")
                        .param("startDate", "2024-01-01")
                        .param("endDate", "2026-12-31"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value("1"))
                .andExpect(jsonPath("$.totalPoints").value(100));
    }

    @Test
    void testInvalidCustomer() throws Exception {

        when(rewardService.getRewards(
                org.mockito.ArgumentMatchers.eq(""),
                org.mockito.ArgumentMatchers.any(),
                org.mockito.ArgumentMatchers.any()))
                .thenThrow(new IllegalArgumentException("Invalid customerId"));

        mockMvc.perform(get("/api/rewards")
                        .param("customerId", "")
                        .param("startDate", "2024-01-01")
                        .param("endDate", "2026-12-31"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testInvalidDateRange() throws Exception {

        when(rewardService.getRewards(
                org.mockito.ArgumentMatchers.eq("1"),
                org.mockito.ArgumentMatchers.any(),
                org.mockito.ArgumentMatchers.any()))
                .thenThrow(new IllegalArgumentException("Invalid date"));

        mockMvc.perform(get("/api/rewards")
                        .param("customerId", "1")
                        .param("startDate", "2026-12-31")
                        .param("endDate", "2024-01-01"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testMissingParams() throws Exception {
        mockMvc.perform(get("/api/rewards"))
                .andExpect(status().isBadRequest());
    }
}