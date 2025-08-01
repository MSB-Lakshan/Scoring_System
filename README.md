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
  
- The formula emphasizes later rounds.

---

### 🧠 Part 03 – Data Management

- **Manager Class:**
- Manages program flow
- Provides menu options
- Interacts with `CompetitorList`

- **CompetitorList Class:**
- Stores a list of `KarateCompetitor` objects
- Allows:
  - Adding competitors
  - Finding by ID
  - Loading from a database
  - Generating summary statistics
  - Identifying top performer

---

## 🐞 Known Bugs & Limitations

- `getOverallScore()` is functional only from Part 2 onwards.
- No validation on name formatting.
- Assumes all round scores are entered.
- No handling for score input mistakes or missing entries.
- No timestamp or competition metadata.
- Database uses root credentials without password – **not production-safe**.
- Top performer is selected as the first in case of a tie (no tie-breaking logic).

---

## 🧪 Testing Methods

### Option 1: Add Competitor
Allows input of competitor data including 5 round scores.

### Option 2: Find by ID
Searches and displays competitor based on their unique ID.

### Option 3: Generate Summary
Displays all competitors with their full details, calculated level, and score summary.

---

## 🧰 Technologies Used

- Java (OOP Principles)
- Scanner (CLI input)
- File/Database connection (planned)
- UML Class Design

---

## 📊 UML Class Diagram

![UML Diagram](./Class%20Diagram.png)

---

## 🚀 Future Enhancements

- Full database integration
- Front-end GUI
- Competition-specific metadata
- Score history logs and timestamps
- Tie-breaking logic
- Name and score validations with user-friendly error prompts

---
[📄 View Full Documentation (Word)](docs/Report.docx)

## 🙏 Thank You

This project was developed to demonstrate OOP design and a scoring-based logic system for managing sports competitions. Contributions and feedback are welcome.


