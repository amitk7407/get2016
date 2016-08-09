package DS_Session8_AllSorts;

/**
 * class to do count sort
 */
public class CountSort {

	/**
	 * method to sort the array using count sort
	 * @param arr : array to be sorted
	 * @return : sorted array
	 */
	public int[] countSort(int[] arr) {
		
		int[] keyArray = new int[getMax(arr) + 1];
		for(int index = 0 ; index < arr.length ; index++) {
			
			keyArray[arr[index]]++;
		}
		
		int sortedArrayIndex = 0;
		for(int index = 0 ; index < keyArray.length ; index++) {
			
			while(keyArray[index] > 0) {
				
				arr[sortedArrayIndex++] = index;
				keyArray[index]--;
			}
		}
		return arr;
	}
	
	/**
	 * method to find the maximum value in the array
	 * @param array :array from which maximum value is to find 
	 * @return : max value from the array
	 */
	public int getMax(int[] array) {
		
		int max = array[0];
		for(int index = 1 ; index < array.length ; index++) {
			
			if(array[index] > max) {
				
				max = array[index];
			}
		}
		return max;
	}
}