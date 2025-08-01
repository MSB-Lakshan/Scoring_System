package Part_03;

import java.sql.*;



public class Main {
    public static void main(String[] args) throws SQLException {
    	//Adding some values for the data-Base.
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
        KarateCompetitor competitor1 = new KarateCompetitor(204, name1, "Portugal", scores1);
        KarateCompetitor competitor2 = new KarateCompetitor(431, name2, "Italy", scores2);
        KarateCompetitor competitor3 = new KarateCompetitor(198, name3, "Japan", scores3);
        KarateCompetitor competitor4 = new KarateCompetitor(82, name4, "USA", scores4);

        // Test the methods
        // Insert competitors into the database 
        KarateCompetitor.insertCompetitor(competitor1);
        KarateCompetitor.insertCompetitor(competitor2);
        KarateCompetitor.insertCompetitor(competitor3);
        KarateCompetitor.insertCompetitor(competitor4);
        
        //Calling Manager class for getting menu,
        Manager manager = new Manager();
        manager.excute();
    }
}
