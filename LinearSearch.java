/**
 *	Assignment 2:
 *
 *		Write recursive functions for the following:
 *
 *			a) to search for a given value x in an array using linear search strategy.
 *				Write JUnit Tests:
 *					take an array having {2,5,8,9,10, 77, 55}, and search 88
 *					take an array having {2,5,8,9,10, 77, 55, 11}, and search 77
 *
 *  author Amit Kumar
 *  date 17-07-2016
 * 
 * 
 */
package Assignment3;

//import java.util.Scanner;

public class LinearSearch {
	
	/*This method searches an element from an unsorted array and
	returns the position of the element in the array to the calling function*/
	int linearSearch(int[] arr, int position, int target) {
		
		if(position < arr.length) {					//This condition is true till we traverse the whole array
			
			if(arr[position] == target) {			//We check even the element at current position is equal to the target value or not
				return position+1;					//If element is found, position of the element is returned
			} else {
				return linearSearch(arr, position+1, target);	//If not found we check for the next element in the array
			}
		}
		return -1;									//-1 is returned when no such element is found
	}
	
/*	public static void main(String[] args) {
		LinearSearch linear = new LinearSearch();
		int[] arr;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter the size of the array:");
			int size = sc.nextInt();
			arr = new int[size];
			for(int index=0; index<size ; index++) {
				arr[index] = sc.nextInt();
			}
	
			int position = 0;
			System.out.print("Which element you want to search ?");
			int target = sc.nextInt();
			int result = linear.linearSearch(arr, position, target);
			if(result == -1) {
				System.out.print("Element not found!!");
			} else {
				System.out.print("The element "+target+" is found at position "+result);
			}
		} catch(OutOfMemoryError err) {
			System.out.print("Please enter a reasonable size of array.");
		} catch(Exception exp) {
			System.out.print("Please enter integer values only and less than 2147483648.");
		}
	}*/
}