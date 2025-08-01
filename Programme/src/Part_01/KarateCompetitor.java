/**
 * This program manages Karate competitors details.
 * Competitors are evaluated with scores ranging from 0 to 10 across 5 rounds.
 */
package Part_01;

public class KarateCompetitor {

    private int competitorID;
    private Name competitorName; // Full Name
    private String level; // KYU (Beginner), DAN (Intermediate), Master (Advanced)
    private String country;

    /**
     * Constructor for KarateCompetitor class.
     * competitorID ID of the competitor.
     * competitorName Name object representing the competitor's full name.
     * level Competition, level: KYU, DAN, Master.
     * country Country of the competitor.
     */
    public KarateCompetitor(int competitorID, Name competitorName, String level, String country) {
        this.competitorID = competitorID;
        this.competitorName = competitorName;
        setLevel(level); // Validate level
        this.country = country;
    }

    // Getters and Setters - Competitor ID
    public int getCompetitorID() {
        return competitorID;
    }

    public void setCompetitorID(int competitorID) {
        this.competitorID = competitorID;
    }
    // Getters and Setters - Competitor Name
    public Name getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(Name competitorName) {
        this.competitorName = competitorName;
    }

    // Getters and Setters - Competitor Level
    public String getLevel() {
        return level;
    }

    /**
     * Sets the competition level and validates it.
     * Level of the competition.
     * Only the part one,  In partt 2 it will calculate base on OVERALL scores.
     */
    public void setLevel(String level) {
        if (!level.equals("KYU") && !level.equals("DAN") && !level.equals("Master")) {
            throw new IllegalArgumentException("Invalid level. Allowed values are KYU, DAN, Master.");
        }
        this.level = level;
    }
    
    
    // Getters and Setters - Competitor Country
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Placeholder method to return the overall score.
     * Fixed overall score of 5.
     */
    public double getOverallScore() {
        return 5;
    }

    
     //Full details of the competitor.
     
    public String getFullDetails() {
        return "Competitor ID: " + competitorID + ", Name: " + competitorName.getFullName() + ", Country: " + country + ".\n" +
                competitorName.getFullName() + " is a " + level + " player and has an overall score of " + getOverallScore() + ".";
    }

     //Short details of the competitor.  
    public String getShortDetails() {
        return "CN: " + competitorID + " (" + competitorName.getWithInitials() + ") has overall score " + getOverallScore() + ".";
    }

    // Main method for testing
    public static void main(String[] args) {
        try {
            // Create Name instances
            Name name1 = new Name("Vasco", "Mateus");
            Name name2 = new Name("Matteo", "Fredda");
            Name name3 = new Name("Horithasho", "Siyoma");

            // Create KarateCompetitor instances
            KarateCompetitor competitor1 = new KarateCompetitor(200, name1, "KYU", "Portugal");
            KarateCompetitor competitor2 = new KarateCompetitor(201, name2, "DAN", "Italy");
            KarateCompetitor competitor3 = new KarateCompetitor(202, name3, "Master", "Japan");

            // Test the methods
            System.out.println(competitor1.getFullDetails());
            System.out.println(competitor1.getShortDetails());

            System.out.println();
            System.out.println(competitor2.getFullDetails());
            System.out.println(competitor2.getShortDetails());

            System.out.println();
            System.out.println(competitor3.getFullDetails());
            System.out.println(competitor3.getShortDetails());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
