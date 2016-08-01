package DS_Assignment2_Stack;

import DS_Assignment1_SinglyLinkedList.MySinglyLinkedList;

/**
 * class to use stack features
 * @param <T> : generic type of objects
 */
public class Stack<T> {

	MySinglyLinkedList<T> stackList;
	private int top = -1;
	
	/**
	 * unparameterized constructor to create a singly linked list
	 */
	public Stack() {
		
		stackList = new MySinglyLinkedList<T>();
	}
	
	/**
	 * method to push an element in the stack
	 * @param item : item to be pushed
	 */
	public void push(T item) {
		
		stackList.addNode(item);;
		top++;
	}
	
	/**
	 * method to delete the top element of stack and return that element
	 * @return : deleted object of generic type
	 */
	public T pop() {
		
		if(!stackList.isEmpty()) {
			return stackList.removeNode(top--);
		}
		throw new NullPointerException("Stack is empty!");
	}
	
	/**
	 * method to check if stack is empty or not
	 * @return : boolean
	 */
	public boolean isEmpty() {
		
		return stackList.isEmpty();
	}
	
	/**
	 * method to return the value from top of stack
	 * @param index : position whose value is to be returned
	 * @return : generic object
	 */
	public T peep() {
	
		if(!stackList.isEmpty()) {
			
			return stackList.get(top);
		}
		throw new NullPointerException("Stack is empty!");
	}
	
	/**
	 * method to return the value at desired index in stack
	 * @param index : position whose value is to be returned
	 * @return : generic object
	 */
	public T get(int index) {
	
		if(!stackList.isEmpty()) {
			
			return stackList.get(index);
		}
		throw new NullPointerException("Stack is empty!");
	}
	
	/**
	 * method to return size of the stack
	 * @return : Integer
	 */
	public int size() {
		
		return stackList.size();
	}
}