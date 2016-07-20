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

public class StringPermutation {

	public List<String> getPermutations(String input,List<String> outputList) {
		
		if (outputList.contains(input)) {
			return outputList;
		} else {
			outputList.add(input);
		}
		
		String combination = "";
		int inputLength = input.length();
		String lastCharacter = "" + (input.charAt(inputLength - 1));
		for (int index = inputLength - 2; index >= 0; index--) {
			
			String firstPart = input.substring(0, index);
			String lastPart = input.substring(index, inputLength - 1);
			combination = firstPart + lastCharacter + lastPart;
			getPermutations(combination,outputList);
		}
		return outputList;
	}
	
	public static void main(String[] args) {
		
		List<String> output = new ArrayList<String>();
		StringPermutation permutation = new StringPermutation();
		Scanner sc = new Scanner(System.in);
		try {
			
			String input = sc.next();
			permutation.getPermutations(input, output);
			for(String string : output){
				System.out.println(string);
			}
		} catch(InputMismatchException exp) {
			
			System.out.print("Please enter a string");
		} finally {
			
			sc.close();
		}
	}
}