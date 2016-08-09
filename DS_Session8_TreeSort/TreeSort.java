package DS_Session8_TreeSort;

import java.util.ArrayList;
import java.util.List;

/**
 * class to make a tree and sort it
 * @param <T> : generic object
 */
public class TreeSort<T> {

	Node<T> root;
	int sizeOfTree = 0;
	List<T> list = new ArrayList<T>();
		
	/**
	 * unparameterized constructor
	 */
	public TreeSort() {
		
		root = null;
	}
		
	/**
	 * method to take a list and create a tree
	 * @param node : root node(null initially)
	 * @param list : list of elements
	 * @return : root node of the tree
	 */
	public Node<T> createTree(Node<T> node, List<T> list) {
		
 		for(T value : list) {
 
 			node = createTree(node, value);
 		}
 		return node;
	}
	
	/**
	 * method to create a binary search tree
	 */
 	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Node<T> createTree(Node<T> node, T value) {
		
 		if(node == null) {
			
 			node = new Node<T>(value);
 			sizeOfTree++;
 		} else if(((Comparable)node.value).compareTo(value) > 0) {
		
 			node.left = createTree(node.left, value);
 		} else {
		
 			node.right = createTree(node.right, value);
 		}
 		return node;
	}
	
	/**
	 * method to find in order traversal of the tree
	 */
	public List<T> inOrder(Node<T> node) {
		
		if(sizeOfTree == 0) {
			
			System.out.println("There are no elements in the tree.");
			return list;
		} else if(node != null) {
			
			inOrder(node.left);
			list.add(node.value);
			inOrder(node.right);
		}
		return list;
	}
}