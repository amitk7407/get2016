package DS_Assignment1_SinglyLinkedList;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T> {

	private Node<T> startNode;
	private int actual_size = 0;

	public MySinglyLinkedList() {
		startNode = null;
	}

	public boolean addNode(T value) {

		Node<T> newNode = new Node<T>(value);
		if(startNode == null){

			startNode = newNode;
			actual_size++;
		}
		else{

			Node<T> temp = startNode;
			while(temp.next != null) {

				temp = temp.next;
			}
			temp.next = newNode;
			actual_size++;
		}
		return true;
	}

	public boolean addNode(int index, T value) {

		if(actual_size < index || index < 0) {

			throw new ArrayIndexOutOfBoundsException();
		}
		Node<T> newNode = new Node<T>(value);
		if(index == 0){

			newNode.next = startNode;
			startNode = newNode;
			actual_size++;
		}
		else{
			Node<T> temp = startNode;
			int count = 0;
			while(count != index-1) {

				temp = temp.next;
				count++;
			}
			newNode.next = temp.next;
			temp.next = newNode;
			actual_size++;
		}
		return true;
	}

	public boolean removeNode(T value) {


		Node<T> prevNode = startNode;
		Node<T> currentNode = startNode;
		
		if(currentNode.value.equals(value)){

			startNode = currentNode.next;
			currentNode = null;
		} else{
			while(!currentNode.value.equals(value)) {

				prevNode = currentNode;
				currentNode  = prevNode.next;	
			}
			
			prevNode.next = currentNode.next;

			currentNode = null;
		}


		return true;
	}

	public boolean removeNode(int index) {

		if(actual_size <= index || index < 0) {

			throw new ArrayIndexOutOfBoundsException();
		}
		if(index == 0){

			startNode = startNode.next;
		}
		else{
			Node<T> prevNode = startNode;
			Node<T> nextNode = startNode.next;
			int count = 0;
			while(count != index-1) {

				prevNode = prevNode.next;
				nextNode = nextNode.next;
				count++;
			}
			prevNode.next = nextNode.next;
			nextNode.next = null;
		}
		return true;
	}

	public T get(int index) {

		if(actual_size <= index || index < 0) {

			throw new ArrayIndexOutOfBoundsException();
		}
		Node<T> temp = startNode;
		int count = 0;
		while(count <= index-1) {

			temp = temp.next;
			count++;
		}
		return temp.next.value;
	}

	public Node<T> reverse() {

		Node<T> prev = null;
		Node<T> next = null;
		Node<T> current = startNode;
		while(current.next != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		current.next = prev;
		startNode.next = current;
		return startNode;
	}

	public void print(){

		Node<T> tempNode = startNode;

		while(tempNode != null){

			System.out.println(tempNode.value);
			tempNode = tempNode.next;
		}
	}
}