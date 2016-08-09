package DS_Session8_TreeSort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import ReceiveInput.ReceiveInput;

	/**
	 * class to check for the operations performed on tree
	 */
public class MainClass {
		
	public static void main(String[] args) {
		
		try {

			TreeSort<Integer> tree = new TreeSort<Integer>();
			ReceiveInput input = new ReceiveInput();
			List<Integer> list = new ArrayList<Integer>();
			Node<Integer> root = null;
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			char repeat = 'y';
			
			while(repeat == 'y' || repeat == 'Y') {

				System.out.print("Enter the roll number : ");
				int value = input.intInput(buffer);
				
				if(list.contains(value)) {
					
					System.out.println("This roll number is already fed in the system.");
					System.out.println("Please enter a unique roll number.");
					continue;
				}
				list.add(value);
				System.out.println();
				System.out.println("Do you want to continue(y)");
				repeat = input.charInput(buffer);
			}
			
			root = tree.createTree(root, list);
			
			System.out.println("The sorted order of roll number is : ");
			list = tree.inOrder(root);
			
			for(Integer value : list) {
			
				System.out.println(value+"  ");
			}
			
		} catch(Exception exp) {
			
			exp.printStackTrace();
		}
	}
}