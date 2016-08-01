package DS_Assignment2_Queue;

/**
 * class to enter the data of the colleges
 */
public class College {

	private int rank;
	private String name;
	private int seats;
	
	/**
	 * parameterized constructor
	 * @param name : name of the college
	 * @param rank : rank obtained by the college
	 * @param seats : seats available in the college
	 */
	public College(String name, int rank, int seats) {
		
		this.name = name;
		this.rank = rank;
		this.seats = seats;
	}
	
	/**
	 * method to get the name of the college
	 * @return : name
	 */
	public String getName() {
		
		return name;
	}
	
	/**
	 * method to set the name of the college
	 * @param name : name of the college
	 */
	public void setName(String name) {
		
		this.name = name;
	}

	/**
	 * method to get the rank of the college
	 * @return : rank
	 */
	public int getRank() {
		
		return rank;
	}
	
	/**
	 * method to set the rank of the college
	 * @param rank : rank
	 */
	public void setRank(int rank) {
		
		this.rank = rank;
	}
	
	/**
	 * method to get the total seats available in the college
	 * @return : seats
	 */
	public int getSeats() {
		
		return seats;
	}
	
	/**
	 * method to set the available seats in the college
	 * @param seats : seats to be made available
	 */
	public void setSeats(int seats) {
		
		this.seats = seats;
	}
}