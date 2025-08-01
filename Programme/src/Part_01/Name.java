package Part_01;
 
	/**
	 * 	Inner Class for Competitor Name
	 * 	Constructor for the Name class.
	 *	competitorFName First name of the competitor.
	 * 	competitorLName Last name of the competitor.
	 */
	public class Name {
	    private String competitorFName;
	    private String competitorLName;
	

    public Name(String competitorFName, String competitorLName) {
        if (competitorFName == null || competitorFName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty or null.");
        }
        if (competitorLName == null || competitorLName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty or null.");
        }
        this.competitorFName = competitorFName;
        this.competitorLName = competitorLName;
    }

  //Full name
    public String getFullName() {
        return competitorFName + " " + competitorLName;
    }


     //initials of the competitor in the format

    public String getWithInitials() {
        return competitorFName.charAt(0) + " " + competitorLName.charAt(0) + "";
    }
}
