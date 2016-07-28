package DS_Assignment1_SinglyLinkedList;

public class Node<T> {

	public T value;
	public Node<T> next;
	
	public Node() {
		
		value = null;
		next = null;
	}
	
	public Node(T value) {
		
		this.value = value;
		next = null;
	}
}
