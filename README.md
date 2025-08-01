# 🥋 Karate Competitor Management System

This Java application is designed to manage karate competition data, track competitor performance, and generate summaries and statistics. It uses OOP principles such as encapsulation, composition, and class abstraction to structure data and processes efficiently.

---

## 📦 Project Structure

- **Main**  
  The entry point of the application.

- **Name**  
  Handles competitor first and last names.

- **KarateCompetitors**  
  Represents a karate competitor with ID, name, level, country, and performance scores across 5 rounds.

- **Manager**  
  Provides a user-friendly interface via the command line. Manages the overall flow of the program.

- **CompetitorList**  
  Stores and manages all competitor data and provides data-related functionalities.

---

## 📌 Features

### ✅ Part 01 – Basic Setup
- **Attributes Implemented:**
  - `competitorID`, `Name`, `level`, `country`
- **Current Limitations:**
  - Fixed `getOverallScore()` returning `5`
  - No round scores implemented
  - No name validation
  - Basic exception handling on level

---

### ⚙️ Part 02 – Scoring & Ranking
- **New Attributes:**
  - `int[] scores` for 5 rounds (validated 0–10)
- **Level Assignment Based on Overall Score:**
  - `KYU` → 1–4
  - `DAN` → 5–7
  - `Master` → 8–10

- **Score Calculation:**
  Weighted average formula:
  
