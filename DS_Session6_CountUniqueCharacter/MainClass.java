package DS_Session6_CountUniqueCharacter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class to check for the unique characters in a string
 */
public class MainClass {

	public static void main(String[] args) {
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		CountUniqueCharacter count = new CountUniqueCharacter();
		MainClass main = new MainClass();
		char repeat = 'y';
		
		while(repeat == 'y' || repeat == 'Y') {

			System.out.println("Please enter a string line : ");
			String str = "";
			try {

				while(str.length() == 0) {
			
					str = buffer.readLine();
				}
				
				count.getString(str);
				System.out.println("Do you want to enter more strings(y) : ");
				repeat = main.charInput(buffer);
				
			} catch(IOException exp) {
			
				exp.printStackTrace();
			}
		}
		count.display();
	}
	
	/**
	 * method to take character as an input
	 * @param buffer : Buffered Reader
	 * @return : character
	 */
	public char charInput(BufferedReader buffer) {
		
		String str = "";
		try {
			
			while(str.length() == 0) {
				
				str = buffer.readLine();
			}	
		}
		catch(IOException exp) {
			
			charInput(buffer);
		} catch(Exception exp) {
			
			charInput(buffer);
		}
		return str.charAt(0);
	}
}