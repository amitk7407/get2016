/**
 *	Assignment 2:
 *				Write a program which remove duplicate elements from an unsorted Array eg.
 *				Input:
 *						Given Array: [2,5,4,6,3,8,5,9,3,3,6,3,9,0]
 *			Output:
 * 				Resultant Array:[2,5,4,6,3,8,9,0]
 *	
 *			Method name : int[] removeDuplicate(int input[])
 *			Write JUnit test cases which will assert the array return from the above method and the expected array.
 *
 *	@author  Amit Kumar
 * 	@date   13-07-2016 
 *
 */
public class Duplicate {
	
	/* This method compares every element with every other element in the array and 
	for each duplicate value shifts the remaining elements upwards by one position*/
	
	int[] removeDuplicate(int[] input) {
		int length = input.length;
		for(int i=0 ; i<length ; i++) {
	
			for (int j=i+1 ; j<length ; j++) {
			
				if(input[i] == input[j]) {					//checks if there is any duplicate elements or not
				
					for(int k=j ; k<length-1 ; k++) {		//if duplicate elements are found then the remaining elements are shifted upwards by one position
					
						input[k] = input[k+1];
					}
					length--;
					j--;
				}
			}
		}
		int[] result = new int[length];
		for(int i=0 ; i<length ; i++) {						//this loop copies the unique elements to another array		{
			result[i] = input[i];
		}
		return result;
	}
}