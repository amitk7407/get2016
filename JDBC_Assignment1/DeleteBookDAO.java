package JDBC_Assignment1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class to execute the query on delete book not issue in 1 year
 */
public class DeleteBookDAO {

	private Connection con;
	
	/**
	 * parameterized constructor
	 * @param con : Connection object
	 */
	public DeleteBookDAO(Connection con) {
	
		this.con = con;
	}
	
	/**
	 * method to execute query and provide the desired results
	 * @return : Count of the books deleted
	 * @throws SQLException : throws a SQL Exception
	 * @throws ClassNotFoundException : throws a ClassNotFound Exception
	 */
	public int deleteBook() {
		
		Statement stmt = null;
		ResultSet rst = null;
		List<Books> listOfBooks = null;
		try {

			stmt = con.createStatement();																//Statement object is created
		
			rst = stmt.executeQuery("SELECT b.accession_no FROM books b LEFT JOIN book_issue bi "
										+"ON b.accession_no = bi.accession_no LEFT JOIN book_return br "
										+"ON bi.accession_no = br.accession_no AND bi.member_id = br.member_id "
										+"AND bi.issue_date = br.issue_date WHERE DATEDIFF(CURRENT_TIMESTAMP, "
										+"IFNULL(bi.issue_date, purchase_date)) >= 365");
																											//provides the result according to query 
		
			listOfBooks = new ArrayList<Books>();													//list of books
			while(rst.next()) {
			
				Books book = new Books();																		//Books object is created
				book.setAccession_no(rst.getInt(1));															//book title is set
				listOfBooks.add(book);																			//book is added to the list
			}
		
			if(listOfBooks.size() > 0) {																		//executed if there are books to be deleted

				for(Books b : listOfBooks) {																	//loop to delete all the books that are not issued in 1 year
			
					stmt.executeUpdate("DELETE bi.* From book_issue bi WHERE bi.accession_no = "+b.getAccession_no());	//data deleted from the book_issue table
					stmt.executeUpdate("DELETE br.* From book_return br WHERE br.accession_no = "+b.getAccession_no());	//data deleted from the book_return table
					stmt.executeUpdate("DELETE b.* From books b WHERE b.accession_no = "+b.getAccession_no());			//data deleted from the books table
				}
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
	
		return listOfBooks.size();
	}
}