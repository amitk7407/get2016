package DS_Session8_AllSorts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import ReceiveInput.ReceiveInput;

/**
 * class to do sorting according to the array input
 */
public class AllSorts {

	/**
	 * method to perform sorting according to the array
	 * @param arr : array to be sorted
	 * @param buffer : BufferedReader Object
	 * @param input : ReceiveInput object
	 * @return : sorted array
	 */
	public static int[] sorting(int[] arr, BufferedReader buffer, ReceiveInput input) {
		
		boolean temp = true;
		while(temp) {
			
			System.out.println("Choose the type of sorting from the given options : ");
			System.out.println("1. Comparison Sorting");
			System.out.println("2. Linear Sorting");
			int choice = input.intInput(buffer);
		
			switch(choice) {
		
				case 1:
					if(arr.length <= 10) {
					
						System.out.println("Bubble Sort...");
						BubbleSort bubble = new BubbleSort();
						arr = bubble.bubbleSort(arr);
					} else {
						
						System.out.println("Quick Sort...");
						QuickSort quick = new QuickSort();
						arr = quick.quickSort(arr, 0, arr.length - 1);
					}
					temp = false;
					break;
				case 2:
					int flag = 0;
					for(int index = 0 ; index < arr.length ; index++) {
						
						if(arr[index] > 99) {
							
							flag = 1;
							break;
						}	
					}
					if(flag == 1) {
					
						System.out.println("Radix Sort : ");
						RadixSort radix = new RadixSort();
						arr = radix.radixSort(arr);
					} else {
						
						System.out.println("Count Sort : ");
						CountSort count = new CountSort();
						arr = count.countSort(arr);
					}
					temp = false;
					break;
				default:
					System.out.println("Invalid input!");
					System.out.println("Please choose from the given options.");
					break;
			}
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		
		ReceiveInput input = new ReceiveInput();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		char repeat = 'y';
		
		while(repeat =='y' || repeat =='Y') {
			
			System.out.print("Please enter the number of elements in the array : ");
			int size = input.intInput(buffer);
			
			int[] arr = new int[size];
			System.out.println("Please enter the elements inthe array : ");
			for(int index = 0 ; index < arr.length ; index++) {
				
				System.out.print("arr["+index+"] : ");
				arr[index] = input.intInput(buffer);
				System.out.println();
			}
		
			arr = AllSorts.sorting(arr, buffer, input);
			AllSorts.print(arr);
			
			System.out.println("Do you want to continue(y)");
			repeat = input.charInput(buffer);
		}
	}
	
	/**
	 * method to print the array
	 * @param arr : array to be printed
	 */
	public static void print(int[] arr) {
		
		for(int index = 0 ; index < arr.length ; index++) {
			
			System.out.println(arr[index]+"  ");
		}
	}
}