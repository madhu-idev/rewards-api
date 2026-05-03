package com.charter.rewardPoints.controller;

import com.charter.rewardPoints.model.RewardResponse;
import com.charter.rewardPoints.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RewardController {

    private final RewardService service;

    @GetMapping("/rewards")
    public RewardResponse getRewards(
            @RequestParam String customerId,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        return service.getRewards(
                customerId,
                LocalDate.parse(startDate),
                LocalDate.parse(endDate)
        );
    }
}