package Part_02;

import java.sql.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
        try {
            // Create Name instances
            Name name1 = new Name("Vasco", "Mateus");
            Name name2 = new Name("Matteo", "Fredda");
            Name name3 = new Name("Horithasho", "Siyoma");
            Name name4 = new Name("David", "Black");

            // Create KarateCompetitor instances with 5 scores
            int[] scores1 = {4, 3, 5, 2, 4}; 
            int[] scores2 = {6, 6, 7, 5, 6}; 
            int[] scores3 = {8, 9, 8, 9, 8}; 
            int[] scores4 = {4, 5, 6, 7, 8}; 

            // Create KarateCompetitor instances with full details
            KarateCompetitor competitor1 = new KarateCompetitor(200, name1, "Portugal", scores1);
            KarateCompetitor competitor2 = new KarateCompetitor(201, name2, "Italy", scores2);
            KarateCompetitor competitor3 = new KarateCompetitor(202, name3, "Japan", scores3);
            KarateCompetitor competitor4 = new KarateCompetitor(203, name4, "USA", scores4);

            // Test the methods
            // Insert competitors into the database
            KarateCompetitor.insertCompetitor(competitor1);
            KarateCompetitor.insertCompetitor(competitor2);
            KarateCompetitor.insertCompetitor(competitor3);
            KarateCompetitor.insertCompetitor(competitor4);

            // Retrieve and display competitors from the database
            List<KarateCompetitor> competitorsFromDb = KarateCompetitor.getCompetitors();
            System.out.println("\nCompetitors from the database:");
            for (KarateCompetitor comp : competitorsFromDb) {
                System.out.println(comp.getFullDetails());
                System.out.println(comp.getShortDetails());
            }

        } catch (SQLException e) {
            System.out.println("Error1: " + e.getMessage());
        }
    }

}


