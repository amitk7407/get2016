package OOP_Assignment5_SocialNetwork;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to perform operations over graph nodes
 */
public class Graph {

	private List<Node> nodeList;

	/**
	 * unparameterized constructor
	 */
	public Graph() {
		
		this.nodeList = new ArrayList<Node>();
	}
	
	/**
	 * method to add node to graph
	 * @param node : node to be added
	 */
	public void addNode(Node node) {
		
		nodeList.add(node);
	}
	
	/**
	 * method to remove node from graph
	 * @param node : node to be removed
	 */
	public void removeNode(Node node) {
	
		nodeList.remove(node);
		for(Node temp : nodeList) {
			temp.removeFriend(node);
		}
		node = null;
	}
	
	/**
	 * method to search a node based on name
	 * @param name : name of user or organization
	 * @return node : having the name same as inputed
	 */
	public Node getNode(String name) {
		
		for(Node temp : nodeList) {
			if(temp.getName().equalsIgnoreCase(name)) {
				return temp;
			}
		}
		return null;
	}
	
	/**
	 * method to retrieve node list
	 * @return list of nodes
	 */
	public List<Node> getNodeList() {
	
		return nodeList;
	}
	
	/**
	 * method to display all the nodes of the graph
	 */
	public void display() {
		
		System.out.println("Here are the details of the nodes:-");
		System.out.println("Name\tType\t\tContact\t\tAddress\tFriends");
		for(Node temp : nodeList) {
			System.out.print(temp.getName()+"\t");
			System.out.print(temp.getType()+"\t");
			System.out.print(temp.getContact()+"\t");
			System.out.print(temp.getAddress()+"\t");
			temp.displayFriendNode();
		}
	}
}