# Rewards API

## Overview
Spring Boot API to calculate customer reward points.

## Logic
- >100 → 2 points
- 50–100 → 1 point

## API
GET /api/rewards?customerId=1&months=3

## Features
- Monthly & total rewards
- Input validation
- Exception handling
- Async support
- Logging

## Tech
- Java 8
- Spring Boot
- Maven