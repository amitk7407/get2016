package DS_Session8_AllSorts;

/**
 * class to find the bubble sort
 */
public class BubbleSort {

	/**
	 * method to sort an array using bubble sort
	 * @param arr : array to be sorted
	 * @return : sorted array
	 */
	public int[] bubbleSort(int[] arr) {
		
		for(int index1 = 0 ; index1 < arr.length - 1 ; index1++) {
			
			for(int index2 = 0 ; index2 < arr.length - index1 - 1 ; index2++) {
				
				if(arr[index2] > arr[index2 + 1]) {
				
					int temp = arr[index2 + 1];
					arr[index2 + 1] = arr[index2];
					arr[index2] = temp;
				}
			}
		}
		return arr;
	}
}