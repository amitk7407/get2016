package DS_Assignment1_DoublyLinkedList;

public class MyDoublyLinkedList<T> {

	private Node<T> startNode;
	private int actual_size = 0;

	/**
	 * unparameterized constructor to initialize a node
	 */
	public MyDoublyLinkedList() {
		
		startNode = null;
	}
	
	/**
	 * parameterized constructor to create a node with the given value
	 * @param value : value of the node
	 */
	public MyDoublyLinkedList(T value) {
		
		startNode.value = value;
	}

	/**
	 * method to add a node with a specified node value
	 * @param value : value of the node
	 * @return : boolean
	 */
	public boolean addNode(T value) {

		Node<T> newNode = new Node<T>(value);
		if(startNode == null){

			startNode = newNode;
			actual_size++;
		}
		else{

			Node<T> temp = startNode;
			while(temp.rear != null) {

				temp = temp.rear;
			}
			temp.rear = newNode;
			newNode.front = temp;
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
		Node<T> newNode = new Node<T>(value);
		if(index == 0 && startNode == null){
		
			startNode = newNode;
			actual_size++;
		} else if(index == 0) {

			newNode.rear = startNode;
			startNode.front = newNode;
			startNode = newNode;
			actual_size++;
		}
		else{
			Node<T> temp = startNode;
			int count = 0;
			while(count != index-1) {

				temp = temp.rear;
				count++;
			}
			if(temp.rear == null) {
			
				temp.rear = newNode;
				newNode.front = temp;
			} else {
				newNode.rear = temp.rear;
				temp.rear = newNode;
				newNode.front = temp;
				newNode.rear.front = newNode;
			}
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

		Node<T> currentNode = startNode;
		
		if(currentNode.value.equals(value)){

			startNode = currentNode.rear;
			startNode.front = null;
			currentNode = null;
		} else{
			while(!currentNode.value.equals(value) && currentNode.rear != null) {

				currentNode  = currentNode.rear;	
			}
			if(!currentNode.value.equals(value) && currentNode.rear == null) {
				
				throw new NullPointerException();
			}
			currentNode.front.rear = currentNode.rear;
			if(currentNode.rear == null) {
			
				currentNode = null;
			} else {
				
				currentNode.rear.front = currentNode.front;
				currentNode = null;
			}
		}
		actual_size--;
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

			startNode = startNode.rear;
			startNode.front = null;
		}
		else{
			
			Node<T> currentNode = startNode;
			int count = 0;
			while(count != index) {

				currentNode = currentNode.rear;
				count++;
			}
			if(currentNode.rear != null) {
			
				currentNode.rear.front = currentNode.front;
				currentNode.front.rear = currentNode.rear;
				currentNode = null;
			} else {
				
				currentNode.front.rear = null;
				currentNode = null;
			}
		}
		actual_size--;
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

			Node<T> currentNode = startNode;
			int count = 0;
			while(count != index) {

				currentNode = currentNode.rear;
				count++;
			}
			return currentNode.value;
		}
	}

	/**
	 * method to reverse the node list
	 */
	public void reverse() {

		Node<T> next = null;
		Node<T> current = startNode;
		while (current != null) {
            next = current.front;
            current.front = current.rear;
            current.rear = next;
            current = current.front;
        }
		if(next != null) {
		
			startNode = next.front;
		}
	}

	/**
	 * method to print the list
	 */
	public void print(){

		Node<T> tempNode = startNode;

		while(tempNode != null){

			System.out.println(tempNode.value);
			tempNode = tempNode.rear;
		}
	}
}