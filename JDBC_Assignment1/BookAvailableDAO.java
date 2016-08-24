package JDBC_Assignment1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DAO class to execute the query on book availability
 */
public class BookAvailableDAO {

	private Connection con;
	
	/**
	 * parameterized constructor
	 * @param con : Connection object
	 */
	public BookAvailableDAO(Connection con) {
	
		this.con = con;
	}
	
	/**
	 * method to execute query and provide the desired results
	 * @param book : Books objects whose availability is to be checked
	 * @throws SQLException : throws a SQL Exception
	 * @throws ClassNotFoundException : throws a ClassNotFound Exception
	 */
	public void bookAvailable(Books book) {

		Statement stmt = null;
		ResultSet rst = null;
		try {
			
			stmt = con.createStatement();												//Statement object is created
		
			rst = stmt.executeQuery("SELECT COUNT(b.accession_no) AS books_not_issued FROM titles t "
											+"INNER JOIN books b ON b.title_id = t.title_id WHERE "
											+"title_name = '"+book.getTitle_name()+"' AND b.accession_no "
											+"NOT IN (SELECT bi.accession_NO FROM book_issue bi "
											+"LEFT JOIN book_return br ON bi.accession_no = br.accession_no "
											+"AND bi.member_id = br.member_id AND bi.issue_date = br.issue_date "
											+"WHERE br.return_date IS NULL)");
																							//provides the result according to query 
		
			while(rst.next()) {
			
				if(rst.getInt(1) > 0) {															//if books are available the setBookIssue method is called and value is set to true else false
					
					book.setBookIssue(true);
				} else {
				
					book.setBookIssue(false);
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
	}
}