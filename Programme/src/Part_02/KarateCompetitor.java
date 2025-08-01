/**
 * This program manages Karate competitors' details.
 * Competitors are evaluated with scores ranging from 0 to 10 across 5 rounds. Everyone participated for all rounds.
 */
package Part_02;

import java.sql.*;
import java.util.*;

public class KarateCompetitor {

    private int competitorID;
    private Name competitorName; // Full Name
    private String level;        // KYU (Level-3), DAN (Level-2), Master (Level-3/Advanced)
    private String country;
    private int[] scores;        // Array of 5 scores

    public KarateCompetitor(int competitorID, Name competitorName, String country, int[] scores) {
        this.competitorID = competitorID;
        this.competitorName = competitorName;
        validateScores(scores);
        this.scores = scores;
        this.level = calculateLevel(); // Automatically calculate level based on scores
        this.country = country;
    }

    public int getCompetitorID() {                        // Getters and Setters - Competitor ID
        return competitorID;
    }

    public void setCompetitorID(int competitorID) {
        this.competitorID = competitorID;
    }

    public Name getCompetitorName() {                    // Getters and Setters - Competitor Name
        return competitorName;
    }

    public void setCompetitorName(Name competitorName) {
        this.competitorName = competitorName;
    }

    public String getLevel() {                            // Getters and Setters - Competitor Level
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCountry() {                        // Getters and Setters - Competitor Country
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int[] getScores() {
        return scores.clone();
    }

    /**
     * Calculate the overall score based on the selected method.
     * Weighted average.
     * Calculate the overall score as the average of all 5 scores.
     */
    public double getOverallScore() {
        int totalWeight = 0;
        int weightedSum = 0;

        // Calculated the weighted sum and total weight.
        for (int i = 0; i < scores.length; i++) {
            int weight = i + 1; // Weight increases with the index.
            weightedSum += scores[i] * weight;
            totalWeight += weight;
        }

        // Calculate the weighted average.
        double overallScore = (double) weightedSum / totalWeight;
        return (double) Math.round(overallScore * 100.0) / 100.0;
    }

    /**
     * Validates scores to ensure they are within the range of 0 to 10.
     */
    private void validateScores(int[] scores) {
        try {
            for (int score : scores) {
                if (score < 0 || score > 10) {
                    throw new IllegalArgumentException("Please enter the score between 0-10.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private String calculateLevel() {
        double overallScore = getOverallScore(); // Use the existing method to calculate the overall score

        if (overallScore >= 1 && overallScore <= 4) {
            return "KYU";
        } else if (overallScore > 4 && overallScore <= 7) {
            return "DAN";
        } else if (overallScore > 7 && overallScore <= 10) {
            return "Master";
        }
        return "Unknown Level";
    }

    // Full details of the competitor
    public String getFullDetails() {
        String scoresStr = Arrays.toString(scores).replaceAll("[\\[\\],]", "");
        return "FULL DETAILS FOR COMPETITOR ID " + getCompetitorID() +
                "\n Competitor ID: " + competitorID + ", Name: " + competitorName.getFullName() +
                ".\n " + competitorName.getFullName() + " is a " + calculateLevel() + " from " + getCountry() + " and received these scores " + scoresStr + "." +
                "\n This gives " + competitorName.getcompititorFName() + " an overall score of " + getOverallScore() + ".\n";
    }

    // Short details of the competitor
    public String getShortDetails() {

        return "SHORT DETAILS FOR COMPETITOR ID " + getCompetitorID() +
                "\n CN: " + competitorID + " (" + competitorName.getWithInitials() + ") is a " + calculateLevel() +
                " player with an overall score of " + getOverallScore() + ".\n";
    }

    // Database connection method for storing competitor details
    public static Connection connectToDatabase() throws SQLException {
        try {
            // Establish a database connection
            String url = "jdbc:mysql://localhost:3306/CompetitionDB";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new SQLException("Error connecting to the database: " + e.getMessage());
        }
    }

    // Insert a competitor into the database
    public static void insertCompetitor(KarateCompetitor competitor) throws SQLException {
        String sql = "INSERT INTO Competitors (competitor_id, full_name, level, country, score1, score2, score3, score4, score5, overall_score) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, competitor.getCompetitorID());
            statement.setString(2, competitor.getCompetitorName().getFullName());
            statement.setString(3, competitor.getLevel());
            statement.setString(4, competitor.getCountry());
            statement.setInt(5, competitor.getScores()[0]);
            statement.setInt(6, competitor.getScores()[1]);
            statement.setInt(7, competitor.getScores()[2]);
            statement.setInt(8, competitor.getScores()[3]);
            statement.setInt(9, competitor.getScores()[4]);
            statement.setDouble(10, competitor.getOverallScore());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error inserting competitor: " + e.getMessage());
        }
    }

    public static List<KarateCompetitor> getCompetitors() throws SQLException {
        List<KarateCompetitor> competitors = new ArrayList<>();
        String sql = "SELECT * FROM Competitors";

        try (Connection connection = connectToDatabase();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int competitorID = resultSet.getInt("competitor_id");
                String fullName = resultSet.getString("full_name");
                String country = resultSet.getString("country");
                int[] scores = {
                        resultSet.getInt("score1"),
                        resultSet.getInt("score2"),
                        resultSet.getInt("score3"),
                        resultSet.getInt("score4"),
                        resultSet.getInt("score5")
                };

                String[] nameParts = fullName.split(" "); // Handles only two parts (First & Last Name)
                Name name = new Name(nameParts[0], nameParts[1]); // Assuming it's just first and last names
                KarateCompetitor competitor = new KarateCompetitor(competitorID, name, country, scores);
                competitors.add(competitor);
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving competitors: " + e.getMessage());
        }
        return competitors;
    }
}
