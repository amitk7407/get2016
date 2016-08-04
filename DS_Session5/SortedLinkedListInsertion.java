package DS_Session5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * class to insert an element in a sorted list
 * @param <T> : generic type object
 */
public class SortedLinkedListInsertion<T> {

	private List<T> list;
	private int counter = 0;
	
	/**
	 * parameterized constructor to get a list from the user
	 * @param list : list provided by user
	 */
	public SortedLinkedListInsertion(List<T> list) {

		this.list = new LinkedList<T>();
		this.list = list;
	}
	
	/**
	 * method to insert an element in the sorted list
	 * @param value : value to be inserted
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insert(T value) {
		
		if(counter == list.size()) {
			
			list.add(counter, value);
		} else if(((Comparable)list.get(counter)).compareTo(value) < 0 || 
				((Comparable)list.get(counter)).compareTo(value) == 0) {
			
			counter++;
			insert(value);
		} else {
			
			list.add(counter, value);
		}
		counter = 0;
	}
	
	/**
	 * method to print the list
	 */
	public void print() {
		
		Iterator<T> itr = list.iterator();
		while(itr.hasNext()) {
			
			System.out.println(itr.next());
		}
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<Integer>();
		/*list.add(1);
		list.add(4);
		list.add(6);
		list.add(8);
		list.add(8);*/
		SortedLinkedListInsertion<Integer> sortedList = new SortedLinkedListInsertion<Integer>(list);
		sortedList.insert(5);
		sortedList.insert(4);
		sortedList.insert(7);
		sortedList.insert(5);
		sortedList.insert(3);
		sortedList.insert(0);
		sortedList.insert(1);
		sortedList.insert(9);
		sortedList.insert(4);
		sortedList.insert(6);
		sortedList.print();
	}
 }