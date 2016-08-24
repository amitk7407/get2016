package JDBC_Assignment1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class to execute the query on book list
 */
public class BookDAO {

	private Connection con;
	
	/**
	 * parameterized constructor
	 * @param con : Connection object
	 */
	public BookDAO(Connection con) {
	
		this.con = con;
	}
	
	/**
	 * method to execute the query and provide the desired results
	 * @param author : Author object whose book titles has to find
	 * @return : list of Books objects published by the given author
	 * @throws SQLException : throws a SQL Exception
	 * @throws ClassNotFoundException : throws a ClassNotFound Exception
	 */
	public List<Books> selectBooks(Author author) {
		
		Statement stmt = null;
		ResultSet rst = null;
		List<Books> listOfBooks = null;
		try {
			
			stmt = con.createStatement();													//Statement object is created
		
			rst = stmt.executeQuery("SELECT title_name FROM titles t "
											+"INNER JOIN title_author ta ON ta.title_id = t.title_id "
											+"INNER JOIN authors a ON a.author_id = ta.author_id "
											+"WHERE a.author_name = '"+author.getAuthor_name()+"'");
																								//provides the result according to query
		
			listOfBooks = new ArrayList<Books>();										//list of books
		
			while(rst.next()) {
			
				Books book = new Books();															//Books object is created
				book.setTitle_name(rst.getString(1));												//book title is set
				listOfBooks.add(book);																//book is added to the list
			}
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} finally {
			
			try {

				stmt.close();
				rst.close();
			} catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
		}
		
		return listOfBooks;
	}
}