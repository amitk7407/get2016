package DS_Session5;

import java.util.LinkedList;
import java.util.List;

/**
 * class to use queue features
 * @param <T> : generic type of objects
 */
public class Queue<T> {
	
	List<T> queueList;
	private int front = -1;
	private int rear = -1;
	
	/**
	 * unparameterized constructor to create a singly linked list
	 */
	public Queue() {
		
		queueList = new LinkedList<T>();
	}
	
	/**
	 * method to enter an element in the queue
	 * @param item : item to be enqueued
	 */
	public void enqueue(T item) {
		
		if(front == -1) {
			
			front++;
			rear++;
		} else {
			
			rear++;
		}
		queueList.add(rear, item);;
	}
	
	/**
	 * method to delete the rear element of queue and return that element
	 * @return : deleted object of generic type
	 */
	public T dequeue() {
		
		if(queueList.size() == 1) {
			
			rear--;
			return queueList.remove(front--);
		}else if(!queueList.isEmpty()) {
			
			rear--;
			return queueList.remove(front);
		}
		throw new NullPointerException("Stack is empty!");
	}
	
	/**
	 * method used to make the queue empty
	 * @return : boolean
	 */
	public boolean makeEmpty() {
		
		int size = size();
		for(int index=0 ; index<size ; index++) {
		
			dequeue();
		}
		return true;
	}
	
	/**
	 * method to check if queue is empty or not
	 * @return : boolean
	 */
	public boolean isEmpty() {
		
		return queueList.isEmpty();
	}
	
	/**
	 * method used to retrieve the element from front
	 * @return : generic object
	 */
	public T getFront() {
		
		return get(front);
	}

	/**
	 * method to return the value at desired index in queue
	 * @param index : position whose value is to be returned
	 * @return : generic object
	 */
	public T get(int index) {
	
		if(!queueList.isEmpty()) {
			
			return queueList.get(index);
		}
		throw new NullPointerException("Queue is empty!");
	}
	
	/**
	 * method to return size of the queue
	 * @return : Integer
	 */
	public int size() {
		
		return queueList.size();
	}
	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(5);
		queue.enqueue(8);
		queue.enqueue(5);
		queue.enqueue(8);
		queue.enqueue(5);
		queue.enqueue(8);
		
		for(int index=0 ; index<queue.size() ; index++) {
			
			System.out.println("Value at index "+index+" is "+queue.get(index));
		}
		System.out.println();
		System.out.println("Value dequeued : "+queue.dequeue());
		System.out.println("Value at front of queue : "+queue.getFront());
		System.out.println("Value dequeued : "+queue.dequeue());
		System.out.println("Value at front of queue : "+queue.getFront());
		System.out.println("Value dequeued : "+queue.dequeue());
		System.out.println();
		
		for(int index=0 ; index<queue.size() ; index++) {
			
			System.out.println("Value at index "+index+" is "+queue.get(index));
		}
		
		queue.makeEmpty();
		System.out.println(queue.isEmpty());
		for(int index=0 ; index<queue.size() ; index++) {
			
			System.out.println("Value at index "+index+" is "+queue.get(index));
		}
	}
}