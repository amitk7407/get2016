package DS_Assignment1_BinarySearch;

import java.util.Scanner;

/**
 * class is used to find an element from an array using binary search
 */
public class BinarySearch {

	/**
	 * method is used to find an element i the array using recursion
	 * @param array : integer array
	 * @param low : first index of array
	 * @param high : last index of array
	 * @param target : the number to find
	 * @return : target if found
	 * @return : -1 if the number is not found
	 */
	public int searchElement(int[] array,int low,int high,int target){
		
		int mid = (low+high)/2;
		if(low > high) {
			
			return -1;
		} else if(array[mid] == target){
				
			return mid;
		} else if (array[mid] > target){
					
			return searchElement(array, low, mid-1, target);
		} else {
						
			return searchElement(array, mid+1, high, target);
		}
	}
		
	/**
	 * method to read an array
	 * @param size : size of array
	 * @return array : array
	 */
	private int[] readArray(Scanner sc) {
		
		System.out.println("Please enter the number of elements in array");
		try {
			int size = sc.nextInt();
		
			while(size <= 0) {
			
				System.out.println("Please enter integer number of elements in array");
				size = sc.nextInt();
			}
			
			int[] array = null;
			boolean flag = false;
			while(!flag) {
				
				flag = true;
				System.out.println("Please enter the elements in array");
				array = new int[size];
				
				for(int index=0 ; index<size ; index++){
										
					array[index] = sc.nextInt();
				}
				for(int index=0 ; index<size-1 ; index++) {
				
					if(array[index] > array[index+1]) {
						System.out.println("Please enter soted array.");
						flag = false;
						break;
					}
				}
			}
			return array;	
		} catch(NumberFormatException exp) {
			
			System.out.println(exp.getMessage());
			readArray(sc);
		} catch(Exception exp) {
			
			System.out.println(exp.getMessage());
			readArray(sc);
		}
		return null;
	}
	
	/**
	 * method to read target
	 * @return : integer
	 */
	private int readtarget(Scanner sc){
		
		System.out.println("Please enter the number to find in array");
		try{
			
			int target = sc.nextInt();
			return target;	
		} catch(NumberFormatException exp) {
		
			System.out.println(exp.getMessage());
			readtarget(sc);
		} catch(Exception ex){
				
			System.out.println(ex.getMessage());
			readtarget(sc);
		}
		return 0;
	}
	
	/**
	 * main method to invoke all other methods to find location of the target
	 * @param args : command line argument
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BinarySearch binarySearch = new BinarySearch();
		int[] array = binarySearch.readArray(sc);
		int target = binarySearch.readtarget(sc);
		
		int result = binarySearch.searchElement(array, 0, array.length-1, target);
		if(result == -1){
			
			System.out.println("Number not found");
		} else {
				
			System.out.println("Number found at "+(result+1));
		}
		sc.close();
	}
}