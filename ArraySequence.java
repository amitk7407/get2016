/**
 *	Assignment 3:
 *				Write a program to find longest increasing sequence from an array of n integer values 
 * 						Input:
 *							Given Array: [1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9] 
 * 						Output:
 * 							Resultant Array: [1, 2,4,5,6,7,8,9]
 *	
 *					method name : int[] longestSequence(int input[])
 * 					Write JUnit test cases which will assert the array return from the above method and the expected array.
 *
 *	@author  Amit Kumar
 * 	@date   13-07-2016 
 *
 */
import java.util.*;
public class ArraySequence {
	
	//This method finds the longest increasing sequence from an array and returns the sequence
	int[] longestSequence(int input[]) {
		
		int i;
		int loc=0;						//this variable keeps the location from which the longest sequence is starting with
		int longest = 0;				//this variable keeps the longest sequence length
		
		ArrayList<Integer> arr = new ArrayList<Integer>();		//we take a dynamic array to store all the positions of the sequences
		arr.add(0);												//first location is set to initial index value that is 0
		
		for(i=1 ; i<input.length ; i++) {						//this loop stores the locations in the arraylist
			if(input[i] <= input[i-1]) {
				arr.add(i);
			}
		}
	
		arr.add(i);
		
		for(int j=1 ; j<arr.size() ; j++) {						//this loop finds the longest sequence
			int p = (arr.get(j) - arr.get(j-1));
			if(p > longest) {
				longest = p;
				loc = j-1;
			}
		}
		
		int m = 0;
		int[] c = new int[longest];
		for(int j=arr.get(loc) ; j<arr.get(loc+1) ; j++) {		//this loop copies the longest sequence in another array
			c[m++] = input[j];
		}
		return c;
	}
}