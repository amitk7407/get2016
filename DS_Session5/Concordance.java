package DS_Session5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * class to find concordance of a string
 */
public class Concordance {

	private HashMap<Character, List<Integer>> hash = new HashMap<Character, List<Integer>>();
	
	/**
	 * method to find concordance
	 * @param str : string of which concordance is to find
	 */
	public void concordance(String str) {
		
		str = removeSpace(str);
		char[] charArray = str.toCharArray();
		
		for(int index = 0 ; index < charArray.length ; index++) {
			
			List<Integer> list = new ArrayList<Integer>();
			if(hash.containsKey(charArray[index])) {
				
				list = hash.get(charArray[index]);
				list.add(index);
			} else {
				
				list.add(index);
			}
			
			hash.put(charArray[index], list);
		}
	}
	
	/**
	 * method to remove spaces from a string
	 * @param str : string from which space has to be removed
	 * @return
	 */
	public String removeSpace(String str) {
		
		String[] splittedString = str.split(" ");
		String concat = "";
		for(String string : splittedString) {
			
			concat += string;
		}
		return concat.toLowerCase();
	}
	
	/**
	 * method to print the concordance
	 */
	public void displayConcordance() {
		
		System.out.println(hash);
	}
	
	public static void main(String[] args) {
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter a string :");
		try {

			String str = "";
			while(str.length() == 0) {
				
				str = buffer.readLine();
			}
			
			Concordance con = new Concordance();
			con.concordance(str);
			con.displayConcordance();
			
		} catch(IOException exp) {
			
			System.out.println("IOException");
		}
	}
}