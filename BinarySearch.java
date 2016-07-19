/**
 *	Assignment 2:
 *		
 *		Write recursive functions for the following:
 *
 *			b) to search for a given value x in an array using binary search strategy.
 *				Write JUnit Tests for each function:
 *					take an array having {2,5,8,9,10, 55, 77}, and search 88
 *					take an array having {2,5,8,9,10, 55, 77}, and search 77
 *
 *  author Amit Kumar
 *  date 17-07-2016
 *  
 */
package Assignment3;

//import java.util.Scanner;

public class BinarySearch {

	/*This method searches an element from a sorted array and
	returns the position of the element in the array to the calling function*/
	int binarySearch(int[] arr, int low, int high, int target) {
		
		int mid;							//A variable mid is declared which store the mid position index of the array
		if(low <= high) {					//This condition is true till there is at least one element in the array
			
			mid = (low+high)/2;				//mid is computed here
			if(arr[mid] == target) {			//We check if the element at mid position is equal to the desired value
				return mid+1;
			} else if(arr[mid] > target) {		//If element at mid position is greater than the value 
												//then we make a recursive call to the array with mid-1 as last index
				return binarySearch(arr, low, mid-1, target);
			} else {							//If element at mid position is smaller than the value
												//then we make a recursive call to the array with mid+1 as initial index
				return binarySearch(arr, mid+1, high, target);
			}
		}
		return -1;								//-1 is returned when there is no element found
	}
	
/*	public static void main(String[] args) {
		BinarySearch binary = new BinarySearch();
		int[] arr;
		int flag = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter the size of the array:");
			int size = sc.nextInt();
			arr = new int[size];
			for(int index=0; index<size ; index++) {
				arr[index] = sc.nextInt();
			}
			for(int index=0; index<size-1 ; index++) {
				if(arr[index] > arr[index+1]) {
					flag = 1;
					break;
				}
			}
			if(flag == 1) {
				System.out.print("Please give a sorted array in increasing order!");
			} else {
				int low = 0;
				int high = size-1;
				System.out.print("Which element you want to search ?");
				int target = sc.nextInt();
				int result = binary.binarySearch(arr, low, high, target);
				if(result == -1) {
					System.out.print("Element not found!!");
				} else {
					System.out.print("The element "+target+" is found at position "+result);
				}	
			}
		} catch(Exception exp) {
			System.out.print("Please enter only integer values and less than 2147483648");
		}
	}*/
}