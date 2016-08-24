package JDBC_Assignment1;

/**
 * POJOs class for the books table
 */
public class Books {

	private String title_name;
	private double price;
	private int accession_no;
	private String purchase_date;
	boolean isBookIssued;
	
	/**
	 * unparameterized constructor
	 */
	public Books() {}
	
	/**
	 * parameterized constructor
	 * @param accession_no : Unique ID of the books
	 * @param purchase_date : Date of the purchase of the book
	 * @param price : Price of the book
	 * @param title_name : Name of the book 
	 */
	public Books(int accession_no, String purchase_date, double price, String title_name) {
		
		this.accession_no = accession_no;
		this.purchase_date = purchase_date;
		this.price = price;
		this.title_name = title_name;
	}
	
	/**
	 * method to return accession_no
	 * @return accession_no
	 */
	public int getAccession_no() {
		return accession_no;
	}
	
	/**
	 * method to set accession_no
	 * @param author_id : Integer
	 */
	public void setAccession_no(int accession_no) {
		this.accession_no = accession_no;
	}

	/**
	 * method to return purchase_date
	 * @return purchase_date
	 */
	public String getPurchase_date() {
		return purchase_date;
	}

	/**
	 * method to set purchase_date
	 * @param author_id : String
	 */
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	/**
	 * method to return price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * method to set price
	 * @param author_id : Double
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * method to return title_name
	 * @return title_name
	 */
	public String getTitle_name() {
		return title_name;
	}

	/**
	 * method to set title_name
	 * @param author_id : String
	 */
	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}
	
	/**
	 * method to set book issue status
	 * @param value : Boolean
	 */
	public void setBookIssue(boolean value) {
		
		isBookIssued = value;
	}
	
	/**
	 * method to return book issue status
	 * @return : Boolean
	 */
	public boolean isBookIssued() {
		
		return isBookIssued;
	}
}