package JDBC_Assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

/**
 * class to check for the query and display the result
 */
public class Library {

	public static void main(String[] args) {
		
		DatabaseConnection db = null;
		try {
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			db = DatabaseConnection.getInstance();
		
			System.out.println("Q1. Fetch all the books published by author, given the name of the author. "
											+"Return the books data (List of Titles).");
			System.out.println("Please enter the author's name :");
			String authorName = ReceiveInput.inputString(buffer);
			Author author = new Author();
			author.setAuthor_name(authorName);
		
			BookDAO bookDAO = new BookDAO(db.createConnection());
			List<Books> listOfBooks = bookDAO.selectBooks(author);
			if(listOfBooks.size() > 0) {

				System.out.println("The list of books published by '"+authorName+"' are:");
				for(Books b : listOfBooks) {
					
					System.out.println(b.getTitle_name());
				}
			} else {
			
				System.out.println("There is no book published by "+authorName);
			}
			System.out.println();
			System.out.println();
		
		
			System.out.println("Q2. Given the name of the book, to be issued by an existing member. "
								+"Return flag to indicate whether the  the book has been issued or not.");
			System.out.println("Please enter the book's name :");
			String bookName = ReceiveInput.inputString(buffer);
			Books book = new Books();
			book.setTitle_name(bookName);
			
			BookAvailableDAO bookAvailable = new BookAvailableDAO(db.createConnection());
			bookAvailable.bookAvailable(book);
			if(book.isBookIssued()) {
			
				System.out.println("'"+bookName+"' is available to be issued.");
			} else {
			
				System.out.println("'"+bookName+"' is not available.");
			}
			System.out.println();
			System.out.println();
		
		
			System.out.println("Q3. Delete all those books which were not issued in last 1 year. "
												+"Return the number of books deleted.");
		
			DeleteBookDAO deleteBook = new DeleteBookDAO(db.createConnection());
			int count = deleteBook.deleteBook();
			System.out.println("Total count of books deleted which were not issued for more than 1 year is : "+count);
			
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			
			System.out.println("Error Loading Driver : "+cnfe);
		} finally {
			
			db.closeConnection();
		}
	}
}