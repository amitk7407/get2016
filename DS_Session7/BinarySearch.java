package DS_Session7;

/**
 * class to do binary search of an element
 * @param <T> : generic type of element
 */
public class BinarySearch<T> {

	/**
	 * method to do binary search for an element
	 * @param array : array in which the value is to find
	 * @param low : initial index of array
	 * @param high : last index of array
	 * @param target : value to find
	 * @return : position if found, -1 if not found, -2 if array is empty, -3 if array is not sorted
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int binarySearch(T[] array, int low, int high, T target) 
	{	
		if(array.length == 0) {
			
			return -2;
		}
		if(!checkForSorted(array)) {
			
			return -3;
		}
		while(low <= high) {

			int mid = (low + high) /2;
		
			if(((Comparable)array[mid]).compareTo(target) == 0) {
			
				while(((Comparable)array[mid]).compareTo(target) == 0) {
					
					mid = mid - 1;
				}
				
				return mid + 2;
			} else if(((Comparable)array[mid]).compareTo(target) > 0) {
			
				return binarySearch(array, low, mid - 1, target);
			} else {
			
				return binarySearch(array, mid + 1, high, target);
			}
		}
		return -1;
	}
	
	/**
	 * method to check if the array is sorted or not
	 * @param array : array to be checked
	 * @return : boolean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean checkForSorted(T[] array) {
		
		for(int index = 0 ; index < array.length - 1 ; index++) {
			
			if(((Comparable)array[index]).compareTo(array[index + 1]) > 0) {
				
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		Integer[] array = {1, 2, 4, 5, 5, 5, 5, 5, 6, 7, 8, 9};
		BinarySearch<Integer> binary = new BinarySearch<Integer>();
		int location = binary.binarySearch(array, 0, array.length-1, new Integer(4));
		if(location == -1) {
			
			System.out.println("Value not found!!");
		} else if(location == -2) {
			
			System.out.println("Array is empty!!");
		} else if(location == -3) {
			
			System.out.println("Array is not sorted.");
			System.out.println("Please enter a sorted array..");
		} else {
		
			System.out.println("value found at position : "+location);
		}
	}
}