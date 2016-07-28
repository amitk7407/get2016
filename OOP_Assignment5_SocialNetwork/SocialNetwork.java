/**
 * Assignment 1
 * 
 * Implementation of Social Network
 *
 * @author Amit Kumar
 * @date 27-07-2016
 */

package OOP_Assignment5_SocialNetwork;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * main class to bind the network entities
 */
public class SocialNetwork {

	private Graph graph;	//Graph to store the social network structure
	
	/**
	 * unparameterized constructor
	 */
	public SocialNetwork() {
		
		graph = new Graph();
	}
	
	/**
	 * method to create network
	 */
	public void createNetwork() {
		ReadFile read = new ReadFile();
	
		graph = read.readFile(graph);
		graph = read.readFriendList(graph);
		graph.display();
	}
	
	/**
	 * method to select among options
	 */
	public void manipulateOptions() {
		
		System.out.println();
		System.out.println("Choose one of the operations to be performed:");
		System.out.println("1. Is Friend");
		System.out.println("2. Delete Profile");
		System.out.println("3. Edit Profile");
		System.out.println("4. Friend Request");
		System.out.println("5. Mutual Friend");
		System.out.println("6. Is Connection");
		System.out.println("7. Display");
		System.out.println("Choose from the above options:");
		
		Scanner sc = new Scanner(System.in);
		try {
			int choice = sc.nextInt();
		
			switch (choice) {
		
				case 1:
					new IsFriend(graph, sc);
					break;
				
				case 2:
					new DeleteProfile(graph, sc);
					break;
				
				case 3:
					new EditProfile(graph, sc);
					break;
				
				case 4:
					new FriendRequest(graph, sc);
					break;
						
				case 5:
					new MutualFriend(graph, sc);
					break;
					
				case 6:
					new IsConnected(graph, sc);
					break;
						
				case 7:
					graph.display();
					break;
		
				default:
					System.out.println("Please choose from the given options.");
					break;
			}
			manipulateOptions();
		} catch(InputMismatchException exp) {
			
			System.out.println("Please enter a valid choice");
			manipulateOptions();
		} catch(Exception exp) {
			
			System.out.println(exp.getMessage());
			manipulateOptions();
		} finally {
			
			sc.close();
		}
	}
	
	/**
	 * main method
	 * @param args : string[]
	 */
	public static void main(String[] args) {
	
		SocialNetwork socialNetwork = new SocialNetwork();
		socialNetwork.createNetwork();
		socialNetwork.manipulateOptions();
	}
}