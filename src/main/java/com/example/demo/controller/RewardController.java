package com.example.demo.controller;

import com.example.demo.model.RewardResponse;
import com.example.demo.service.RewardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/rewards")
    public RewardResponse getRewards(
            @RequestParam String  customerId,
            @RequestParam int months) {

        return rewardService.getRewards(customerId, months);
    }
}