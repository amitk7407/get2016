package DS_Assignment4_Heap;

/**
 * class to create a node
 * @param <T>
 */
public class Node<T> {

	public Node<T> left;
	public Node<T> right;
	public T value;
	
	/**
	 * method to initialize a node with null
	 */
	public Node() {
		
		left = null;
		right = null;
		value = null;
	}
	
	/**
	 * method to initialize a node with a value
	 * @param value : the value of the node
	 */
	public Node(T value) {
		
		left = null;
		right = null;
		this.value = value;
	}
}