package JDBC_Assignment1;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * class to take input from the user
 */
public class ReceiveInput {

	/**
	 * method to take string as an input
	 * @param buffer : BufferedReader object
	 * @return : string
	 */
	public static String inputString(BufferedReader buffer) {
		
		String input = "";
		try {

			while(input.trim().length() == 0) {
			
				input = buffer.readLine();
			}
		} catch(IOException exp) {
			
			input = inputString(buffer);
		}
		return input;
	}
}