/**
 *	Assignment 3:
 *
 *		Write a recursive function to sort the given array in ascending order using quicksort.
 *		Write JUnit Tests for above function.
 *			Sort this array {2,5,8,9,10, 77, 55, 11}
 *			Sort this array {}
 *
 *  author  Amit Kumar
 *  date 17-07-2016
 *  
 */
package Assignment3;

//import java.util.Scanner;

public class QuickSort {

	/*This method finds the position of the element whose left side elements are less than that
	 and right side elements are greater than that*/
	int partition(int[] arr, int low, int high) {
		
		int pivot = arr[low];			//pivot is a variable whose position is to be fixed
		while(true) {
			while(pivot  > arr[low]) {		//it checks if pivot is greater than left side elements
				low++;
			}
			while(pivot < arr[high]) {		//it checks if pivot is smaller than right side elements
				high--;
			}
			if(low < high) {				//it swaps the elements if lowerbound of array is less than upperbound of array
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			} else {
				return high;
			}
		}
	}
	
	//this method sorts the array recursively
	int[] quickSort(int[] arr, int low, int high) {
		
		if(arr.length == 0) {		//if the array has no elements then it returns -1
			int[] array = {-1};
			return array;
		} else {
			for(int index =0 ; index<arr.length ; index++) {	//if the array has negative elements then it returns -2
				if(arr[index] < 0) {
					int[] array = {-2};
					return array;
				}
			}
			if(low < high) {
				int p = partition(arr, low, high);
				quickSort(arr, p+1, high);
				quickSort(arr, low, p-1);
			}
		}
		return arr;
	}
	
/*	public static void main(String[] args) {
		
		try {
			QuickSort quick = new QuickSort();
			int[] arr;
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the size of the array:");
			int size = sc.nextInt();
			arr = new int[size];
			
			for(int index=0 ; index < size ; index++) {
				arr[index] = sc.nextInt();
			}
			
			int[] result = quick.quickSort(arr, 0, size-1);
			
			if(result[0] == -1) {
				System.out.print("There is no element in the array");
			} else if(result[0] == -2) {
				System.out.print("Please enter positive numbers");
			} else {
				System.out.println("The sorted array is:");
				for(int i=0 ; i<result.length ; i++) {
					System.out.println(result[i]);
				}
			}
		} catch(OutOfMemoryError err) {
			System.out.print("Please enter a reasonable size of array.");
		} catch(NegativeArraySizeException exp) {
			System.out.print("Please enter positive array size");
		} catch(Exception exp) {
			System.out.print("Please enter integer values only and less than 2147483648.");
		}
	}*/
}