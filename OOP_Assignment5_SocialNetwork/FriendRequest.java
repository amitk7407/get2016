package OOP_Assignment5_SocialNetwork;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class to send accept, decline, and block friend requests 
 */
public class FriendRequest {
	
	private static final int CHOICE_1 = 1;
	private static final int CHOICE_2 = 2;
	private static final int CHOICE_3 = 3;

	/**
	 * method to send friend request 
	 * @param graph : graph object
	 * @param sc : scanner object
	 */
	FriendRequest(Graph graph, Scanner sc) {
		
		System.out.println("Enter the name of the user who sends request:");
		String name1 = "";
		while(name1.length() == 0) {
			
			name1 = sc.next().trim();
		}
		Node node1 = graph.getNode(name1);
		
		if(node1 == null) {
			System.out.println(name1+" is not present in the system.");
			new FriendRequest(graph, sc);
		}
		System.out.println("Enter the name of the user to whom the request is sent:");
		String name2 = "";
		while(name2.length() == 0) {
			
			name2 = sc.next().trim();
		}
		Node node2 = graph.getNode(name2);
		if(node2 == null) {
			System.out.println(name2+" is not present in the system.");
			new FriendRequest(graph, sc);
		}
		if(node2.IsBlocked(node1)) {
			
			System.out.println(name2+" has blocked "+name1);
		}
		
		System.out.println("Options for response to the friend request:");
		options(node1, node2, sc);
	}
	
	/**
	 * method to respond to friend request
	 * @param node1 : requester
	 * @param node2 : request receiver
	 * @param sc : scanner object
	 */
	void options(Node node1, Node node2, Scanner sc) {
	
		try {
			System.out.println("1. Accept\n2. Reject\n3. Block");
			int choice = sc.nextInt();
			if(!(choice == CHOICE_1 || choice == CHOICE_2 || choice == CHOICE_3)) {
			
				System.out.println("Please select from the options provided.");
				options(node1, node2, sc);
			} else {
				boolean option = true;
				while(option) {
					switch (choice) {
			
						case 1:
							node1.addFriend(node2);
							node2.addFriend(node1);
							System.out.println(node2.getName()+" has accepted the friend request of "+node1.getName());
							option = false;
							break;

						case 2:
							System.out.println(node2.getName()+" has rejected the friend request of "+node1.getName());
							option = false;
							break;
					
						case 3:
							node2.blockNode(node1);
							System.out.println(node2.getName()+" has blocked "+node1.getName());
							option = false;
							break;
							
						default:
							System.out.println("Invalid input");
							System.out.println("Please re-enter the option.");
							break;
					}
				}
			}
		} catch(InputMismatchException exp) {
			
			System.out.println("Please enter only integer options.");
			options(node1, node2, sc);
		} catch(Exception exp) {
			
			System.out.println(exp.getMessage());
			options(node1, node2, sc);
		}
	}
}