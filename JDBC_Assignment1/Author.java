package JDBC_Assignment1;

/**
 * POJOs class for the authors table
 */
public class Author {

	private int author_id;
	private String author_name;
	
	/**
	 * unparameterized constructor
	 */
	public Author() {}
	
	/**
	 * parameterized constructor
	 * @param author_id : Unique Id of the author
	 * @param author_name : Name of the author
	 */
	public Author(int author_id, String author_name) {
		
		this.author_id = author_id;
		this.author_name = author_name;
	}

	/**
	 * method to return author_id
	 * @return author_id
	 */
	public int getAuthor_id() {
		return author_id;
	}

	/**
	 * method to set author_id
	 * @param author_id : Integer
	 */
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	/**
	 * method to return author_name
	 * @return author_name
	 */
	public String getAuthor_name() {
		return author_name;
	}

	/**
	 * method to set author_name
	 * @param author_name : String
	 */
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}	
}