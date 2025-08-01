package Part_03;
 
	/**
	 * 	Inner Class for Competitor Name
	 * 	Constructor for the Name class.
	 *	competitorFName First name of the competitor.
	 * 	competitorLName Last name of the competitor.
	 */
	public class Name {
	    private String competitorFName;
	    private String competitorLName;
	    
	    public String getcompititorFName() { //Getting the first Name
	    	return competitorFName;
	    }
	    
	    public String getcompititorLName() { //Getting the second Name
	    	return competitorLName;
	    }
	    
	
	  //Exception for Entering Empty or nuLL VALUE
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

  //Full name (First Name + Second Name)
    public String getFullName() {
        return competitorFName + " " + competitorLName;
    }


     //initials of the competitor in the format
    public String getWithInitials() {
        return competitorFName.charAt(0) + " " + competitorLName.charAt(0) + "";
    }


}
