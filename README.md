# Rewards API

## Overview
This project is a Spring Boot REST API that calculates reward points for customers based on their transactions.

The API allows users to retrieve reward points for a specific customer within a given date range.

---

## Tech Stack

- Java 8
- Spring Boot 2.7.18
- Maven
- Lombok
- JUnit 5 (Testing)

---



##  Build & Run Instructions

###  Prerequisites
- Java 8 installed
- Maven installed

---

### Build Project


mvn clean install


---

### Run Application


mvn spring-boot:run


---

### Application URL


https://jubilant-system-969qwppj69qrfggr-8080.app.github.dev


---

##  API Documentation

###  Endpoint


GET /api/rewards


---

###  Query Parameters

| Parameter   | Type   | Description |
|------------|--------|------------|
| customerId | String | Customer ID |
| startDate  | String | Start date (YYYY-MM-DD) |
| endDate    | String | End date (YYYY-MM-DD) |

---

###  Sample Request


https://jubilant-system-969qwppj69qrfggr-8080.app.github.dev/api/rewards?customerId=1&startDate=2024-01-01&endDate=2026-12-31

---

###  Sample Response

```json
{
  "customerId": "1",
  "monthlyPoints": {
    "JANUARY": 120,
    "FEBRUARY": 90
  },
  "totalPoints": 210
}
 # Reward Calculation Logic
No points for amount ≤ $50
1 point for every dollar spent between $50–$100
2 points for every dollar spent above $100
Example:
$120 → 90 points
$75 → 25 points