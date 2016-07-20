/**
 *	Assignment 2: 
 *		
 *		Write a Java program to generate all possible permutations of given letters in string.
 *
 *		Can you make it more generic so that it can generate permutations of any length of string.
 *
 *			List<String> generatePermutations(String input);
 *
 *			Write JUnit for the above program:
 *				1) generatePermutations(“ABC”);
 *					Expected: Return List of string containing following values:
 *						ABC
 *						ACB
 *						BAC
 *						BCA
 *						CBA
 *						CAB
 *
 *				2) generatePermutations(“ABCD”);
 *					Expected: Return List of string containing 24 unique permutations.
 *
 *  author  Amit Kumar
 *  date  18-07-2016
 *  
 */

package Assignment4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PermutationString {

	//this method takes a string and returns the list of combinations
	List<String> permute(String in, List<String> out) {
		
		if(in.length() == 1) {			//if there is only one character in the string then there will be the single result
			
			out.add(in);
		} else if(in.length() > 1){		//if the string consists of more than one character
			
			for(int index=0 ; index<out.size() ; index++) {		//if the string is already present in the list
				
				if(in.equals(out.get(index))) {
				
					return out;
				}
			}
			out.add(in);							//if string is not present then add it to the list
			for(int index=in.length()-1 ; index>0 ; index--) {	//this loop swaps the last two characters of the input string and then calls the permute method recursively
				
				char[] carr = in.toCharArray();
				char tmp = carr[index];
				carr[index] = carr[index-1];
				carr[index-1] = tmp;
				
				permute(new String(carr), out);
			}
		}
		return out;
	}

	public static void main(String[] args) {
		
		PermutationString permutation = new PermutationString();
		Scanner sc = new Scanner(System.in);
		try {
		
			System.out.print("Enter a string:");
			String in = sc.next();
			for(int index=0 ; index<in.length() ; index++) {
				if(in.charAt(index)<65 || (in.charAt(index)>90) && (in.charAt(index)<97) || in.charAt(index)>122) {
					
					throw new InputMismatchException();
				}
			}
			List<String> out = new ArrayList<String>();
			out = permutation.permute(in, out);
			for(String result : out){

				System.out.println(result);
			}
		} catch(InputMismatchException exp) {
			
			System.out.println("The input is invalid!!");
			System.out.print("Please enter a string");
		} catch(Exception exp) {
			
			System.out.println("The input is invalid!!");
			System.out.print("Please enter a string.");
		} finally {
			
			sc.close();
		}
	}
}