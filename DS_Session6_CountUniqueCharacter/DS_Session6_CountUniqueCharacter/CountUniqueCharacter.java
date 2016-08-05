package DS_Session6_CountUniqueCharacter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountUniqueCharacter {

	HashMap<String, Integer> hashString = new HashMap<String, Integer>();
	/**
	 * method to count unique character in a string
	 * @param str : string in which unique characters are to be counted
	 * @return : count of unique characters
	 */
	public int countUnique(String str) {
	
		char[] charArray = str.toCharArray();
		List<Character> charList = new ArrayList<Character>();
		
		for(int index = 0 ; index < charArray.length ; index++) {
			
			if(!charList.contains(charArray[index])) {
				
				charList.add(charArray[index]);
			}
		}
		return charList.size();
	}
	
	/**
	 * method to get a whole line and mapping each string with its unique character count
	 * @param str : a line of string
	 */
	public void getString(String str) {
		
		str = str.trim();
		String[] strArray = str.split(" ");
		for(int index = 0 ; index < strArray.length ; index++) {
				
			if(!(hashString.containsKey(str) || strArray[index].equals(""))) {
				
				strArray[index] = strArray[index].trim();
				strArray[index] = strArray[index].toLowerCase();
				hashString.put(strArray[index], countUnique(strArray[index]));
			}
		}
	}
	
	/**
	 * method to display a hash map
	 */
	public void display() {
		
		System.out.println(hashString);
	}
}