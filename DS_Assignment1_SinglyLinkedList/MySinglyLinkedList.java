package DS_Assignment1_SinglyLinkedList;


/**
 *class to create a Singly linked list and perform operations in it 
 * @param <T> : generic type of object
 */
public class MySinglyLinkedList<T> {

	private MySinglyLinkedList<T> startNode;
	private MySinglyLinkedList<T> next;
	private T value;
	private int actual_size = 0;

	/**
	 * unparameterized constructor to initialize a node
	 */
	public MySinglyLinkedList() {
		
		value = null;
		next = null;
		startNode = null;
	}
	
	/**
	 * parameterized constructor to create a node with the given value
	 * @param value : value of the node
	 */
	public MySinglyLinkedList(T value) {
		
		this.value = value;
		next = null;
		startNode = null;
	}

	/**
	 * method to add a node with a specified node value
	 * @param value : value of the node
	 * @return : boolean
	 */
	public boolean addNode(T value) {

		MySinglyLinkedList<T> newNode = new MySinglyLinkedList<T>(value);
		if(startNode == null){

			startNode = newNode;
			actual_size++;
		}
		else{

			MySinglyLinkedList<T> temp = startNode;
			while(temp.next != null) {

				temp = temp.next;
			}
			temp.next = newNode;
			actual_size++;
		}
		return true;
	}

	/**
	 * method to add a node at a specified position
	 * @param index : position at which the node is to be added
	 * @param value : value of the node to be added
	 * @return : boolean
	 */
	public boolean addNode(int index, T value) {

		if(actual_size < index || index < 0) {

			throw new ArrayIndexOutOfBoundsException();
		}
		MySinglyLinkedList<T> newNode = new MySinglyLinkedList<T>(value);
		if(index == 0){

			newNode.next = startNode;
			startNode = newNode;
			actual_size++;
		}
		else{
			MySinglyLinkedList<T> temp = startNode;
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

	/**
	 * method to remove a node corresponding to its value
	 * @param value : value of the nod to be deleted
	 * @return : boolean
	 */
	public boolean removeNode(T value) {

		MySinglyLinkedList<T> prevNode = startNode;
		MySinglyLinkedList<T> currentNode = startNode;
		
		if(currentNode.value.equals(value)){

			startNode = currentNode.next;
			currentNode = null;
		} else{
			while(!currentNode.value.equals(value) && currentNode.next != null) {

				prevNode = currentNode;
				currentNode  = prevNode.next;	
			}
			if(currentNode.next == null) {
				
				throw new NullPointerException();
			}
			prevNode.next = currentNode.next;
			currentNode = null;
		}
		return true;
	}

	/**
	 * method to remove a node from a specified location
	 * @param index : location from which the node is to be deleted
	 * @return : boolean
	 */
	public boolean removeNode(int index) {

		if(actual_size <= index || index < 0) {

			throw new ArrayIndexOutOfBoundsException();
		}
		if(index == 0){

			startNode = startNode.next;
		}
		else{
			MySinglyLinkedList<T> prevNode = startNode;
			MySinglyLinkedList<T> nextNode = startNode.next;
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

	/**
	 * method to get node value from a given index
	 * @param index : index from which the node value is to be retrieved
	 * @return : generic type object
	 */
	public T get(int index) {

		if(actual_size <= index || index < 0) {

			throw new ArrayIndexOutOfBoundsException();
		}
		if(index == 0){

			return startNode.value;
		}
		else{

			MySinglyLinkedList<T> temp = startNode;
			int count = 0;
			while(count <= index-1) {

				temp = temp.next;
				count++;
			}
			return temp.next.value;
		}
	}

	/**
	 * method to reverse the node list
	 */
	public void reverse() {

		MySinglyLinkedList<T> prev = null;
		MySinglyLinkedList<T> next = null;
		MySinglyLinkedList<T> current = startNode;
		while(current.next != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		current.next = prev;
		startNode = current;
	}

	/**
	 * method to print the list
	 */
	public void print(){

		MySinglyLinkedList<T> tempNode = startNode;

		while(tempNode != null){

			System.out.println(tempNode.value);
			tempNode = tempNode.next;
		}
	}
}