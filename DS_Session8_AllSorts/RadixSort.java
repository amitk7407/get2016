package DS_Session8_AllSorts;

import java.util.LinkedList;
import java.util.Queue;

/**
 * class to do the radix sort
 */
public class RadixSort {

	/**
	 * method to sort the array using the radix sort
	 * @param arr : array to be sorted
	 * @return : sorted array
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int[] radixSort(int[] arr) {
		
		Queue[] count = new Queue[10];				//array of queue
		
		for(int index = 0 ; index < count.length ; index++) {
			
			count[index] = new LinkedList<Integer>();
		}
		
		int divisor = 1;
		boolean flag = true;
		
		while(flag) {							//runs until there the highest value gets at the right place

			flag = false;
			for(int index = 0 ; index < arr.length ; index++) {			//add elements to the queue every time the remainder is calculated
			
				int hash = (arr[index]/divisor) % 10;
				if(hash > 0) {

					flag = true;
				}
				count[hash].add(arr[index]);
			}
			divisor *= 10;
			int size = 0;
		
			for(int index = 0 ; index < 10 ; index++) {					//queue is copied to the original array
			
				while(!count[index].isEmpty()) {
				
					arr[size++] = (Integer)count[index].remove();
				}
			}
		}
		return arr;
	}
}