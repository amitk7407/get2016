package DS_Assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class to check for the operations performed on tree
 */
public class MainClass {
	
	public static void main(String[] args) {
		
		try {

			Tree<Integer> tree = new Tree<Integer>();
			Tree<Integer> tree2 = new Tree<Integer>();
			MainClass input = new MainClass();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			char repeat = 'y';
		
			while(repeat == 'y' || repeat == 'Y') {

				System.out.println("1. Insert element in tree");
				System.out.println("2. InOrder traversal");
				System.out.println("3. PreOrder Traversal");
				System.out.println("4. PostOrder traversal");
				System.out.println("5. Check for Mirror tree");
				System.out.println("6. Exit");		
		
				int choice = input.intInput(buffer);
			
				switch(choice) {
			
					case 1 :
						tree = input.createTree(buffer);
						break;
					case 2 :
						System.out.print("InOrder Traversal : ");
						tree.inOrder();
						break;
					case 3 :
						System.out.print("PreOrder Traversal : ");
						tree.preOrder();
						break;
					case 4 :
						System.out.print("PostOrder Traversal : ");
						tree.postOrder();
						break;
					case 5 :
						System.out.println("Please enter the data of first tree:");
						tree = input.createTree(buffer);
						System.out.println("Please enter the data of second tree:");
						tree2 = input.createTree(buffer);
						
						if(tree.isMirrorTree(tree2)) {
							
							System.out.println("Both trees are mirror images of each other.");
						} else {
							
							System.out.println("The trees are not mirror images of each other.");
						}
						break;
					case 6 :
						System.exit(0);
					default :
						System.out.println("Invalid choice!");
						break;
				}
				System.out.println();
				System.out.println("Do you want to continue(y)");
				repeat = input.charInput(buffer);
			}
		} catch(Exception exp) {
			
			exp.printStackTrace();
		}
	}
	
	/**
	 * method to take an integer input from user
	 * @param buffer : BufferedReader object
	 * @return : integer
	 */
	public int intInput(BufferedReader buffer) {
		
		int choice = 0;
		try {
			
			choice = Integer.parseInt(buffer.readLine());
			if(choice < 0) {
				
				throw new IllegalArgumentException();
			}
		} catch(IllegalArgumentException | IOException exp) {
			
			System.out.println("Please enter positive integers only");
			intInput(buffer);
		}
		return choice;
	}
	
	/**
	 * method to take a character input from user
	 * @param buffer : BufferedReader object
	 * @return : character
	 */
	public char charInput(BufferedReader buffer) {
		
		String str = "";
		try {
			
			str = buffer.readLine();	
		}
		catch(IOException exp) {
			
			exp.printStackTrace();
			charInput(buffer);
		}
		return str.charAt(0);
	}
	
	/**
	 * method to create a whole tree 
	 * @param buffer : BufferedReader object
	 * @return : Tree
	 */
	public Tree<Integer> createTree(BufferedReader buffer) {
		
		char repeat ='y';
		Tree<Integer> tree = new Tree<Integer>();
		
		while(repeat == 'y' || repeat == 'Y') {
			
			System.out.println("Enter integer value for the node");
			int value = intInput(buffer);
			tree.add(value);
			System.out.println("Do you want to enter more nodes(y)");
			repeat = charInput(buffer);
		}
		System.out.println("Tree Created.");
		return tree;
	}
}