package DS_Assignment1_LargestDigit;

import java.util.Scanner;

/**
 * class to find third largest number in an array
 */
public class ThirdLargestDigit {

	/**
	 * method to find third largest digit from an array
	 * @param array : array in which third largest is to be found
	 * @return : integer
	 */
	public int thirdLargestDigit(int[] array){
			
		int max = 0;
		int secondMax = 0;
		int thirdMax = 0;
		try{

			for(int index=0 ; index<array.length ; index++) {

				if(array[index] > max){
					
					thirdMax = secondMax;
					secondMax = max;
					max = array[index];
				} else if(array[index] < max && array[index] > secondMax) {
					
					thirdMax = secondMax;
					secondMax = array[index];
				} else if(array[index] < secondMax && array[index] > thirdMax) {
					
					thirdMax = array[index];	
				}
			}
		} catch(Exception ex){
				
			System.out.println("Something went wrong: "+ex.getMessage());
		}
		return thirdMax;
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
			
			System.out.println("Please enter the elements in array");
			int[] array = new int[size];
				
			for(int index=0 ; index<size ; index++){
										
				array[index] = sc.nextInt();
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
	 * main method to invoke all other methods to find the third largest element in the array 
	 * @param args : command line argument
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ThirdLargestDigit thirdLargestDigit = new ThirdLargestDigit();
		int[] array = thirdLargestDigit.readArray(sc);
	
		System.out.println("Third largest element is: "+thirdLargestDigit.thirdLargestDigit(array));
	}
}