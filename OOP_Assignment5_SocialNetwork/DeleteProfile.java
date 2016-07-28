package OOP_Assignment5_SocialNetwork;

import java.util.Scanner;

/**
 * class for deleting a user's or organization's profile
 */
public class DeleteProfile {
	
	private static final int ZERO_LENGTH = 0;

	/**
	 * Method to delete a profile from graph
	 * @param graph : contains graph from which profile is to be deleted
	 * @param sc : scanner object
	 */
	DeleteProfile(Graph graph, Scanner sc) {
		
		System.out.println("Enter the name of the user whose profile is to be deleted:");
		String name = "";
		
		while(name.length() == ZERO_LENGTH) {
			
			name = sc.nextLine().trim();
		}
		Node node = graph.getNode(name);
		
		if(node == null) {
			
			System.out.println(name+" is not present in the system.");
			new DeleteProfile(graph, sc);
		} else {
			
			graph.removeNode(node);
			System.out.println(name+" is deleted from the system successfully.");
		}
	}
}