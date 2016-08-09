package DS_Session8_AllSorts;

/**
 * class to sort the array using quick sort
 */
public class QuickSort {

	/**
	 *  This method finds the position of the element whose left side elements are less than that 
	 *  and right side elements are greater than that
	 * @param arr : array to be partitioned
	 * @param low : low index of the array
	 * @param high : high index of the array
	 * @return : index by which array can be partitioned
	 */
	int partition(int[] arr, int low, int high) {
		
		int pivot = low;			//pivot is a variable whose position is to be fixed
		int storeIndex = pivot + 1;
		
		for(int index = low + 1 ; index <= high ; index++) {
			
			if(arr[pivot] > arr[index]) {
				
				int temp = arr[index];
				arr[index] = arr[storeIndex];
				arr[storeIndex] = temp;
				storeIndex++;
			}
		}
		
		int temp = arr[pivot];
		arr[pivot] = arr[storeIndex - 1];
		arr[storeIndex - 1] = temp;
		
		return storeIndex - 1;
	}
	
	/**
	 * this method sorts the array recursively
	 * @param arr : array to be sorted
	 * @param low : low index of the array
	 * @param high : high index of the array
	 * @return : sorted array
	 */
	int[] quickSort(int[] arr, int low, int high) {
		
		if(arr.length == 0) {		//if the array has no elements then it returns -1
			
			int[] array = {-1};
			return array;
		} else {
			
			if(low < high) {
				int p = partition(arr, low, high);
				quickSort(arr, p+1, high);
				quickSort(arr, low, p-1);
			}
		}
		return arr;
	}
}