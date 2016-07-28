package OOP_Assignment5_SocialNetwork;

import java.util.Scanner;

/**
 * class to find the mutual friends of two users
 */
public class MutualFriend {

	private static final int ZERO_LENGTH = 0;
	
	/**
	 * method to find mutual friends of two users
	 * @param graph : graph
	 * @param sc : scanner object
	 */
	public MutualFriend(Graph graph, Scanner sc) {

		System.out.println("Enter the name of the user1:");
		String name1 = "";
		while(name1.length() == ZERO_LENGTH) {
			
			name1 = sc.next().trim();
		}
		Node node1 = graph.getNode(name1);
		
		if(node1 == null) {
			System.out.println(name1+" is not present in the system.");
			new MutualFriend(graph, sc);
		}
		
		System.out.println("Enter the name of the user2:");
		String name2 = "";
		while(name2.length() == ZERO_LENGTH) {
			
			name2 = sc.next().trim();
		}
		Node node2 = graph.getNode(name2);
		
		if(node2 == null) {
			System.out.println(name2+" is not present in the system.");
			new MutualFriend(graph, sc);
		}
		
		System.out.println("Mutual Friends between "+name1+" and "+name2+" are:");
		for(Node temp : node1.connectedNode()) {
			
			if(node2.isFriend(temp)) {
				
				System.out.println(temp.getName());
			}
		}
	}
}