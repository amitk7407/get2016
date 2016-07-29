package DS_Assignment1_ArrayList;

import java.util.NoSuchElementException;

/**
 * class to create a dynamic array and perform operations in it
 * @param <T> : generic class
 */
public class MyArrayList<T> {

	private static final int DEFAULT_SIZE = 8;
	private static final int MIN_SIZE = 2;
	private static final int ZERO = 0;
	private static final int NUM1 = 1;
	private static final int NUM2 = 2;
	private static final int NUM3 = 3;
	
	private Object[] arrayList = new Object[DEFAULT_SIZE];
	private int actual_size = 0;
	
	/**
	 * unparameterized constructor
	 */
	public MyArrayList() {
		
	}
	
	/**
	 * parameterized constructor to initialize the array of the given size
	 * @param size : size given by the user
	 */
	public MyArrayList(int size) {
		
		arrayList = new Object[size];
	}
	
	/**
	 * method to add an object in the array list
	 * @param o : the object provided by the user
	 * @return : boolean
	 */
	public boolean add(Object o) {
		
		if((arrayList.length - actual_size) < MIN_SIZE) {
			incrementSize();
		}
		arrayList[actual_size++] = o;
		return true;
	}
	
	/**
	 * method to add an object at a given index in the array list
	 * @param o : the object provided by the user
	 * @param index : the index at which the object is to be added
	 * @return : boolean
	 */
	public boolean add(Object o, int index) {

		if(index > actual_size || index < ZERO) {
			
			throw new ArrayIndexOutOfBoundsException();
		}
		if(arrayList.length <= index) {
			
			incrementSize();
		}
		for(int rowIndex=actual_size-NUM1 ; rowIndex>=index ; rowIndex--) {
			
			arrayList[rowIndex+NUM1] = arrayList[rowIndex];
		}
		arrayList[index] = o;
		++actual_size;
		return true;
	}
	
	/**
	 * method to increase the size of the array
	 * @return : integer
	 */
	public int incrementSize() {
		
		int size = (arrayList.length*NUM2)/NUM3 + NUM1;
		arrayList = copy(arrayList, size);
		return size;
	}
	
	/**
	 * method copies the small array into another big array
	 * @param o : array of object to be copied
	 * @param size : size of the new array
	 * @return : another big array
	 */
	public Object[] copy(Object[] o, int size) {
		
		Object[] newArray = new Object[size];
		for(int index=ZERO ; index<o.length ; index++) {
			
			newArray[index] = o[index];
		}
		return newArray;
	}
	
	/**
	 * method to get object at a particular index
	 * @param index : at which the object is to be found
	 * @return : object
	 */
	public Object getObject(int index) {
		
		if(index >= actual_size || index < ZERO) {
			
			throw new ArrayIndexOutOfBoundsException();
		}
		return arrayList[index];
	}
	
	/**
	 * method to retrieve index of an object
	 * @param o : object of which index is to be found
	 * @return : integer
	 */
	public int getIndex(Object o) {
		
		for(int index=ZERO ; index<actual_size ; index++) {
			
			if(arrayList[index].equals(o)) {
				return index;
			}
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * method to remove an object from a particular index
	 * @param index : the position from which object has to be removed
	 * @return : boolean
	 */
	public boolean remove(int index) {
		
		if(index >= actual_size || index < ZERO) {
			
			throw new ArrayIndexOutOfBoundsException();
		}
		for(int rowIndex=index+NUM1 ; rowIndex<actual_size ; rowIndex++) {
			
			arrayList[rowIndex-NUM1] = arrayList[rowIndex];
		}
		arrayList[--actual_size] = null;
		return true;
	}
	
	/**
	 * method to remove an object
	 * @param o : the object to be removed
	 * @return : boolean
	 */
	public boolean remove(Object o) {
		
		int index = getIndex(o);
		remove(index);
		return true;
	}
	
	/**
	 * method to remove all the objects
	 * @return : boolean
	 */
	public boolean removeAll() {
		
		for(int index=ZERO ; index<actual_size ; index++) {
		
			arrayList[index] = null;
		}
		actual_size = ZERO;
		return true;
	}
	
	/**
	 * method to return size of the array
	 * @return : integer
	 */
	public int size() {
		
		return actual_size;
	}
	/**
	 * method to reverse the array
	 * @return : reversed array
	 */
	public void reverse() {
		
		Object[] obj = new Object[arrayList.length];
		for(int index1=ZERO, index2=actual_size-NUM1 ; index1<actual_size ; index1++, index2--) {
			
			obj[index1] = arrayList[index2];
		}
		arrayList = copy(obj, obj.length);
	}
	
	/**
	 * method to sort the array
	 */
/*	public void sort() {
		
		for (int rowIndex=ZERO ; rowIndex<arrayList.length ; rowIndex++) {

			for (int columnIndex=rowIndex+NUM1; columnIndex<arrayList.length ; columnIndex++) {
				
			  
		    }
		}
	}*/
}