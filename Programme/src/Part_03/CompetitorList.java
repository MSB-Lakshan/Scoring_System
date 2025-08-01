package Part_03;

import java.sql.*;
import java.util.*;

/**
 * This class manages a list of KarateCompetitor objects, allowing operations such as loading competitors
 * from the database, generating reports, and finding specific competitors by ID.
 */
public class CompetitorList {
    private List<KarateCompetitor> competitors;


     //Constructor to initialize the CompetitorList.
    public CompetitorList() {
        competitors = new ArrayList<>();
    }

    /**
     * Loads competitors' data from the database into the list.
     * 
     * @throws SQLException if a database access error occurs.
     */
    public void loadFromDatabase() throws SQLException {
        competitors = KarateCompetitor.getCompetitors();
    }

    //Generate a Summary Statistic REPORT
    public void generateReport() {
        /*
         * Report includes:
         * - Table of competitors from the database.
         * - Top performer.
         * - Frequency of scores.
         */
        System.out.printf("%-15s %-25s %-10s %-10s %-15s %-15s\n", 
                          "Competitor ID", "Full Name", "Level", "Country", "Scores", "Overall Score");

        System.out.println("-----------------------------------------------------------------------------------------------");

        for (KarateCompetitor competitor : competitors) {
            // Clean up the Scores column by removing brackets and commas from the array
            String scoresStr = Arrays.toString(competitor.getScores()).replaceAll("[\\[\\],]", "");

            System.out.printf("%-15d %-25s %-10s %-10s %-15s %-15.2f\n", 
                              competitor.getCompetitorID(), 
                              competitor.getCompetitorName().getFullName(), 
                              competitor.getLevel(), 
                              competitor.getCountry(),
                              scoresStr,   // Cleaned-up scores
                              competitor.getOverallScore());
        }

        // Generate summary statistics
        generateSummaryStatistics();

        // Find and display the top performer
        KarateCompetitor topPerformer = getTopPerformer();
        System.out.println("\nTop Performer: ");
        System.out.println(topPerformer.getFullDetails());
    }

    /**
     * Generates summary statistics for the competition, including frequency of scores
     * and the total number of competitors.
     */
    private void generateSummaryStatistics() {
        System.out.println("\nSummary Statistics:");

        // Map to store the frequency for each score
        Map<Integer, Long> scoreFrequency = new HashMap<>();

        // Loop through all competitors and count the frequency of each individual score in their score array
        for (KarateCompetitor competitor : competitors) {
            for (int score : competitor.getScores()) {
                scoreFrequency.put(score, scoreFrequency.getOrDefault(score, 0L) + 1);
            }
        }

        // Get the unique scores and sort them
        List<Integer> sortedScores = new ArrayList<>(scoreFrequency.keySet());
        Collections.sort(sortedScores);

        // Print the scores with spaces
        System.out.print("Score       : ");
        for (int score : sortedScores) {
            System.out.printf("%4d ", score);
        }
        System.out.println();

        // Print the frequencies of the scores
        System.out.print("Frequency   : ");
        for (int score : sortedScores) {
            System.out.printf("%4d ", scoreFrequency.get(score));
        }
        System.out.println();

        // Display the total number of competitors
        System.out.println("\nTotal Competitors: " + competitors.size());
    }

    /**
     * Finds the competitor with the highest overall score.
     * 
     * @return the KarateCompetitor object with the highest score, or null if no competitors exist.
     */
    private KarateCompetitor getTopPerformer() {
        if (competitors.isEmpty()) {
            return null; // Return null if the list is empty
        }

        KarateCompetitor topPerformer = competitors.get(0);
        for (KarateCompetitor competitor : competitors) {
            if (competitor.getOverallScore() > topPerformer.getOverallScore()) {
                topPerformer = competitor;
            }
        }
        return topPerformer;
    }

    /**
     * Searches for a competitor by their unique ID.
     * 
     * @param competitorID the ID of the competitor to search for.
     * @return the KarateCompetitor object if found, or null if no match exists.
     */
    public KarateCompetitor findCompetitorByID(int competitorID) {
        for (KarateCompetitor competitor : competitors) {
            if (competitor.getCompetitorID() == competitorID) {
                return competitor;
            }
        }
        return null; // Return null if no competitor is found
    }
}
