package OOP_Assignment5_SocialNetwork;

import java.util.List;
import java.util.Scanner;

/**
 * class to check presence of connection between two nodes
 */
public class IsConnected {
	
	private static final int ZERO_LENGTH = 0;

	/**
	 * method to check presence of connection between two nodes
	 * @param graph : graph 
	 * @param sc : scanner object
	 */
	public IsConnected(Graph graph, Scanner sc) {

		System.out.println("Enter the name of the user1:");
		String name1 = "";
		while(name1.length() == ZERO_LENGTH) {
			
			name1 = sc.next().trim();
		}
		Node node1 = graph.getNode(name1);
		
		if(node1 == null) {
			System.out.println(name1+" is not present in the system.");
			new IsConnected(graph, sc);
		}
		
		System.out.println("Enter the name of the user2:");
		String name2 = "";
		while(name2.length() == ZERO_LENGTH) {
			
			name2 = sc.next().trim();
		}
		Node node2 = graph.getNode(name2);
		
		if(node2 == null) {
			System.out.println(name2+" is not present in the system.");
			new IsConnected(graph, sc);
		}
		
		boolean result = connected(node1, node2);
		if(result) {
			System.out.println(name1+" is connected to "+name2);
		} else {
			System.out.println(name1+" is not connected to "+name2);
		}
	}

	/**
	 * method to check indirect connection between two nodes
	 * @param node1 : node one
	 * @param node2 : node two
	 * @return boolean
	 */
	boolean connected(Node node1, Node node2) {
		
		if(node1.isFriend(node2)) {
			
			return true;
		} else {
		
			List<Node> nodeList = node1.connectedNode();
			for(Node node : nodeList) {
				if(connected(node, node2)) {
					return true;
				}
			}
		}
		return false;		
	}
}