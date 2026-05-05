# 🎯 Rewards API (Java 8 | Spring Boot)

A RESTful API that calculates **customer reward points** based on transactions over a configurable time period.

This project demonstrates clean architecture, proper validation, testing, and real-world API design.

---

# 📌 Features

✔ Calculate reward points for a customer
✔ Supports dynamic date range (`startDate`, `endDate`)
✔ Monthly + total reward breakdown
✔ Input validation & error handling
✔ In-memory repository (no hardcoded service logic)


---

# 🧠 Reward Calculation Logic

| Amount Range | Points Earned                         |
| ------------ | ------------------------------------- |
| ≤ $50        | 0                                     |
| $50 – $100   | 1 point per $1 over $50               |
| > $100       | 2 points per $1 over $100 + 50 points |

### Example:

* $120 → (120-100)*2 + 50 = **90 points**
* $80 → (80-50) = **30 points**

---

# 🏗️ Tech Stack

* Java 8
* Spring Boot
* Maven
* JUnit
* MockMvc

---

# 📂 Project Structure

```text id="struct01"
src/main/java/com/charter/rewardPoints/
│
├── controller/      # REST API layer
├── service/         # Business logic
├── repository/      # In-memory data
├── model/           # DTOs
├── util/            # Reward calculation logic
├── exception/       # Global exception handling
```

---

# 🚀 Getting Started

## 1️⃣ Clone Repository

```
git clone https://github.com/madhu-idev/rewards-api.git
cd rewards-api
```

---

## 2️⃣ Build Project

```bash id="build01"
mvn clean install
```

✔ Expected output:

```text id="build02"
BUILD SUCCESS
```

---

## 3️⃣ Run Application

```
mvn spring-boot:run
```

---

## 4️⃣ Access API

```
https://jubilant-system-969qwppj69qrfggr-8080.app.github.dev/api/rewards
```

---

# 📡 API Details

## 🔹 Endpoint

```
GET /api/rewards
```

---

## 🔹 Query Parameters

| Parameter  | Required | Description        |
| ---------- | -------- | ------------------ |
| customerId | Yes      | Customer ID        |
| startDate  | No       | Format: yyyy-MM-dd |
| endDate    | No       | Format: yyyy-MM-dd |

---

## ✅ Sample Request

```
https://jubilant-system-969qwppj69qrfggr-8080.app.github.dev/api/rewards?customerId=7&startDate=2025-03-01&endDate=2026-04-27

```

---

## ✅ Sample Response

```
{
  "customerId": "7",
  "monthlyPoints": {
    "FEBRUARY": 30,
    "APRIL": 850
  },
  "totalPoints": 880
}
```

---

# ⚠️ Validation Rules

* ❌ customerId must not be empty
* ❌ startDate must be before endDate
* ❌ Dates cannot be in the future
* ❌ Invalid date format → error response

---

# 🧪 Testing

## Run Tests

```
mvn test
```

---

## ✔ Test Coverage

* Service layer unit tests
* Boundary tests ($50, $100)
* Error scenarios
* Happy path scenarios
* BigDecimal precision tests

---

# 📊 Test Scenarios

| Scenario                    | Status |
| --------------------------- | ------ |
| Valid request               | ✅      |
| Invalid customer            | ✅      |
| Missing params              | ✅      |
| Invalid date range          | ✅      |
| Future date validation      | ✅      |
| Boundary values ($50, $100) | ✅      |
| High amount transactions    | ✅      |

---

# 📸 Test Evidence

Screenshots available in:

```
TestEvidence/
```

