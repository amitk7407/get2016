package OOP_Assignment5_SocialNetwork;

import java.util.ArrayList;
import java.util.List;

/**
 * class to define attributes of an User
 */
public class User extends Node {

	private String name, type, contact, address;
	private List<Node> nodeFriendList;
	private List<Node> blockList;
	
	/**
	 * parameterized constructor
	 * @param name : name of organization
	 * @param type : type of profile
	 * @param contact : contact detail
	 * @param address : address
	 */
	public User(String name, String type, String contact, String address) {
		this.name = name;
		this.type = type;
		this.contact = contact;
		this.address = address;
		this.nodeFriendList = new ArrayList<Node>();
		this.blockList = new ArrayList<Node>();
	}
	
	/**
	 * method to add a friend to friend list
	 */
	@Override
	public void addFriend(Node node) {
		// TODO Auto-generated method stub
		if(!nodeFriendList.contains(node)) {
			nodeFriendList.add(node);
		}
	}

	/**
	 * method to remove a friend from friend list
	 */
	@Override
	public void removeFriend(Node node) {
		
		if(nodeFriendList.contains(node)) {
			nodeFriendList.remove(node);
		}
	}

	/**
	 * method to display all nodes in friend list
	 */
	@Override
	public void displayFriendNode() {
		
		for(Node temp : nodeFriendList) {
			System.out.print(temp.getName()+",");
		}
		System.out.println();
	}

	/**
	 * method to get friend(connected) nodes list
	 */
	@Override
	public List<Node> connectedNode() {
		
		return nodeFriendList;
	}

	/**
	 * method to check if a user is friend with you
	 */
	@Override
	public boolean isFriend(Node node) {
		
		if(nodeFriendList.contains(node)) {
			return true;
		}
		return false;
	}
	
	/**
	 * method to add user to block list
	 */
	@Override
	public void blockNode(Node node) {
		
		if(!blockList.contains(node)) {
			blockList.add(node);
		}
	}

	/**
	 * method to check if a user has been blocked
	 */
	@Override
	public boolean IsBlocked(Node node) {
		
		if(blockList.contains(node)) {
			return true;
		}
		return false;
	}
	
	/**
	 * method to set Name
	 */
	@Override
	public void setName(String name) {
		
		this.name = name;
	}

	/**
	 * method to get Name
	 */
	@Override
	public String getName() {
		
		return name;
	}

	/**
	 * method to set Type
	 */
	@Override
	public void setType(String type) {
		
		this.type = type;
	}

	/**
	 * method to get Type
	 */
	@Override
	public String getType() {
	
		return type;
	}

	/**
	 * method to get Contact
	 */
	@Override
	public String getContact() {
		
		return contact;
	}

	/**
	 * method to set Contact
	 */
	@Override
	public void setContact(String contact) {
		
		this.contact = contact;
	}

	/**
	 * method to get address
	 */
	@Override
	public String getAddress() {
		
		return address;
	}

	/**
	 * method to set address
	 */
	@Override
	public void setAddress(String address) {
		
		this.address = address;
	}

	/**
	 * method to generate hash code
	 */
	@Override
	public int hashCode() {
		
		return getName().hashCode() + getType().hashCode() + getContact().hashCode() + getAddress().hashCode();
	}

	/**
	 * method to compare two organization profiles
	 */
	@Override
	public boolean equals(Object obj) {
		try {
			Node node = (Node) obj;
			if (this.hashCode() == node.hashCode()) {
				return true;
			}
			return false;
		} catch(Exception exp) {
			System.out.println(exp.getMessage());
		}
		return false;
	}
}