package DS_Assignment1_DoublyLinkedList;

public class Node<T> {

	public T value;
	public Node<T> front;
	public Node<T> rear;
	
	public Node() {
			
		value = null;
		front = null;
		rear = null;
	}
		
	public Node(T value) {
		
		this.value = value;
		front = null;
		rear = null;
	}
}