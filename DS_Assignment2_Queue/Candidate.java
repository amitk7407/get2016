package DS_Assignment2_Queue;

/**
 * class to enter the data of the students
 */
public class Candidate {

	private int rank;
	private String name;
	
	/**
	 * parameterized constructor
	 * @param name : name of the student
	 * @param rank : rank obtained by the student
	 */
	public Candidate(String name, int rank) {
		
		this.name = name;
		this.rank = rank;
	}
	
	/**
	 * method to get the name of the candidate
	 * @return : name
	 */
	public String getname() {
		
		return name;
	}
	
	/**
	 * method to set the name of the student
	 * @param name : name of the student
	 */
	public void setName(String name) {
		
		this.name = name;
	}
	
	/**
	 * method to get the rank of the student
	 * @return : rank
	 */
	public int getRank() {
		
		return rank;
	}
	
	/**
	 * method to set the rank of the student
	 * @param rank : rank
	 */
	public void setRank(int rank) {
		
		this.rank = rank;
	}
}