/**
 *	Assignment 5:
 *			Write a function to check given array is in sorted order or not. Function should 
 *			return 1 if array is in ascending order, 2 if array is in descending order, 0 if array is not in sorted
 *	
 *			Use this function and write a program to display appropriate message based on return value of above function.
 *			Also write JUnit test cases which takes an integer array as input and assert return value.
 *			Write Junit Test cases for all above 3 cases.
 *
 *  @author   Amit Kumar
 *  @date    13-07-2016
 *
 */
public class SortedArrayCheck {

	//this method checks if the array is sorted or not
	int checkSortedArray(int[] input) {
		
		int i;
		for(i=1 ; i<input.length ; i++) {			//this loop checks for sorted array in descending order
			if(input[i-1] < input[i]) {
				break;
			}
		}
		if(i == input.length) {
			return 2;
		}
		else {
			for(i=1 ; i<input.length ; i++) {		//this loop checks for sorted array in ascending order
				if(input[i-1] > input[i]) {
					break;
				}
			}
			if(i == input.length) {
				return 1;
			}
			else {
				return 0;							//this shows the array is not sorted
			}
		}
	}
}