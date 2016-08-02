package DS_Assignment3;

/**
 * class to create a tree and perform its operation
 * @param <T> : generic type
 */
public class Tree<T> {

	Node<T> root;
	int sizeOfTree = 0;
	
	/**
	 * unparameterized constructor
	 */
	public Tree() {
		
		root = null;
	}
	
	/**
	 * method to add an element in the tree
	 * @param value : value to be added
	 */
	public void add(T value) {
		
		root = insert(root, value);
	}

	/**
	 * method to create a binary search tree
	 */
/* 	//Binary Search Tree
 	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Node<T> insert(Node<T> node, T value) {
		
		if(node == null) {
			
			node = new Node<T>(value);
			sizeOfTree++;
		} else if(((Comparable)node.value).compareTo(value) > 0) {
			
			node.left = insert(node.left, value);
		} else {
			
			node.right = insert(node.right, value);
		}
		return node;
	}
*/	
	
	/**
	 * method to create a binary tree
	 * @param node : current node of the tree
	 * @param value : value to be inserted
	 * @return : Node
	 */
	//Binary Tree
	public Node<T> insert(Node<T> node, T value) {
		
		if(node == null) {
			
			node = new Node<T>(value);
			sizeOfTree++;
		} else if(sizeOfTree % 2 != 0) {
			
			node.left = insert(node.left, value);
		} else {
			
			node.right = insert(node.right, value);
		}
		return node;
	}
	
	/**
	 * method to find in order traversal of the tree
	 */
	public void inOrder() {
		
		inOrderPrint(root);
	}
	
	public void inOrderPrint(Node<T> node) {
		
		if(sizeOfTree == 0) {
			
			System.out.println("There are no elements in the tree.");
		} else if(node != null) {
			
			inOrderPrint(node.left);
			System.out.print(node.value+" ");
			inOrderPrint(node.right);
		}
	}
	
	/**
	 * method to find pre order traversal of the tree
	 */
	public void preOrder() {
		
		preOrderPrint(root);
	}
	
	public void preOrderPrint(Node<T> node) {
		
		if(sizeOfTree == 0) {
			
			System.out.println("There are no elements in the tree.");
		} else if(node != null) {
			
			System.out.print(node.value+" ");
			preOrderPrint(node.left);
			preOrderPrint(node.right);
		}
	}
	
	/**
	 * method to find post order traversal of the tree
	 */
	public void postOrder() {
		
		postOrderPrint(root);
	}
	
	public void postOrderPrint(Node<T> node) {
		
		if(sizeOfTree == 0) {
			
			System.out.println("There are no elements in the tree.");
		} else if(node != null) {
			
			postOrderPrint(node.left);
			postOrderPrint(node.right);
			System.out.print(node.value+" ");
		}
	}		
	
	/**
	 * method to check if two trees are mirror similar to each other or not
	 * @param tree : second tree
	 * @return : boolean
	 */
	public boolean isMirrorTree(Tree<T> tree) {
	
		return MirrorTree(this.root, tree.root);
	}
	 
	public boolean MirrorTree(Node<T> root1, Node<T> root2) {
		
		if(root1 == null && root2 == null) {
			
			return true;
		} else if (root1 != null && root2 != null) {
			
			if(root1.value == root2.value) {
				
				MirrorTree(root1.left, root2.right);
				MirrorTree(root1.right, root2.left);
				return true;
			} else {
				
				return false;
			}
		} else {
			
			return false;
		}
	}
}