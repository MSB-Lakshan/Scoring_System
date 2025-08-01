package Part_03;

import java.sql.*;
import java.util.*;

public class Manager {
    private CompetitorList competitorList;
    private Scanner scanner;

    public Manager() {
        competitorList = new CompetitorList();
        scanner = new Scanner(System.in);
    }

    // Main menu in this Program
    public void excute() {
        try {
            competitorList.loadFromDatabase();
            boolean running = true;
            while (running) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Competitors.");
                System.out.println("2. Find competitor by ID");
                System.out.println("3. Display full competitor report");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  

                switch (choice) {
                	case 1:
                        addCompetitorToCompetition(); //Link to the  addCompetitorToCompetition() for adding competitors.
                        System.out.print("\n");
                        break;                		
                    case 2:
                    	findAndDisplayCompetitor(); //Link to the  findAndDisplayCompetitor() for find competitors using ID.
                        break;

                    case 3:
                        competitorList.generateReport(); //Link to the  generateReport() for generate SUMMERY REPORT.
                        System.out.print("\n");
                        break;

                    case 4:
                        running = false; //End the running programe
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.\n"); //By deafault Choice error
                }
            }
        } catch (SQLException e) {
            System.out.println("DataBase error: " + e.getMessage()); //Exception for other type of errors.
        }
    }

    //Find competitors using their ID's
    private void findAndDisplayCompetitor() {
        System.out.print("Enter competitor ID: ");
        int id = scanner.nextInt();
        KarateCompetitor competitor = competitorList.findCompetitorByID(id);

        if (competitor != null) {
            System.out.println(competitor.getFullDetails());
            System.out.println(competitor.getShortDetails());
        } else {
            System.out.println("Competitor not found.");
        }
    }

    // Add a new competitor to the competition (with ID, name, country, scores)
    private void addCompetitorToCompetition() throws SQLException {
        System.out.println("\nEnter Competitor Details: ");
		System.out.print("Competitor ID: ");
		int competitorID = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		System.out.print("First Name: ");
		String firstName = scanner.nextLine();

		System.out.print("Last Name: ");
		String lastName = scanner.nextLine();

		Name name = new Name(firstName, lastName);

		System.out.print("Country: ");
		String country = scanner.nextLine();
		
		int[] scores = new int[5];
		for (int i = 0; i < 5; i++) {
		    while (true) {
		        try {
		            System.out.print("Score for Round " + (i + 1) + ": ");
		            scores[i] = scanner.nextInt();
		            // Validate the score within the valid range if not return,
		            if (scores[i] < 0 || scores[i] > 10) {
		                throw new IllegalArgumentException("Please enter the score between 0-10.");
		            }
		            break; 
		        } catch (IllegalArgumentException e) {
		            System.out.println(e.getMessage()); 
		            scanner.nextLine(); 
		        }
		    }
		}

		KarateCompetitor newCompetitor = new KarateCompetitor(competitorID, name, country, scores);

		// Insert the new competitor into the database
		KarateCompetitor.insertCompetitor(newCompetitor);
		System.out.println("\nCompetitor added successfully!");
    }
    

  
}