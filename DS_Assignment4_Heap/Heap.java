package DS_Assignment4_Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * class to create a heap and perform operations on it
 * @param <T> : generic type
 */
public class Heap<T> {

	private List<T> array = new ArrayList<T>();
	
	/**
	 * method to create a heap
	 */
	public void build_Max_Heap() {
		
		int length = array.size();
		for(int index=length/2-1 ; index>=0 ; index--) {
			
			max_Heapify(length, index);
		}
	}
	
	/**
	 * method to create a max heap by heapifying it
	 * @param length : length of the array to be heapified
	 * @param index : node from which the array is to be heapified
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void max_Heapify(int length, int index) {
		
		int left = index*2 + 1;
		int right = index*2 + 2;
		int largest = index;
		
		if(left < length && ((Comparable)array.get(left)).compareTo(array.get(largest)) > 0) {
			largest = left;
		}
		if(right < length && ((Comparable)array.get(right)).compareTo(array.get(largest)) > 0) {
			largest = right;
		}

		if(largest != index) {
				
			T temp = array.get(index);
			array.set(index, array.get(largest));
			array.set(largest, temp);
			max_Heapify(length, largest);
		}
	}
	
	/**
	 * printing the heap
	 */
	public void display() {
	
		for(int index=0 ; index<array.size() ; index++) {
			
			System.out.print(array.get(index)+"  ");
		}
		System.out.println();
	}
	
	/**
	 * sorting the heap in increasing order
	 */
	public void sort_Max_Heap() {
		
		int length = array.size();
		for(int index=length-1 ; index>=0 ; index--) {
			
			T temp = array.get(index);
			array.set(index, array.get(0));
			array.set(0, temp);
			
			max_Heapify(index, 0); 
		}
	}
	
	/**
	 * insert an element in the heap maintaining it property
	 * @param value
	 */
	public void insert(T value) {
		
		array.add(value);
		build_Max_Heap();
	}
	
	/**
	 * method to delete the top most element of the heap
	 * @return : top most element
	 */
	public T delete() {
		
		T value = array.get(0);
		array.set(0, array.get(array.size()-1));
		array.remove(array.size()-1);
		max_Heapify(array.size(), 0);
		return value;
	}
	
	/**
	 * method to check if heap is empty or not
	 * @return : boolean
	 */
	public boolean isEmpty() {
		
		if(array.size() == 0) {
			
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		Heap<Integer> heap = new Heap<Integer>();
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(4);
		/*heap.insert(6);
		heap.insert(7);
		heap.insert(8);
		heap.insert(9);
		heap.insert(10);
		*/
		heap.display();
		heap.delete();
		heap.delete();
		heap.display();
		heap.sort_Max_Heap();
		heap.display();
	}
}