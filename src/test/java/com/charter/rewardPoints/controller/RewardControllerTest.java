package com.charter.rewardPoints.controller;

import com.charter.rewardPoints.service.RewardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RewardController.class)
class RewardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RewardService service;

    @Test
    void testGetRewards() throws Exception {
        mockMvc.perform(get("/api/rewards")
                .param("customerId", "1")
                .param("startDate", "2026-01-01")
                .param("endDate", "2026-03-01"))
                .andExpect(status().isOk());
    }
}