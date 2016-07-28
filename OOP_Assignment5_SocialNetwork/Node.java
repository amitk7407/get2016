package OOP_Assignment5_SocialNetwork;

import java.util.List;

/**
 * abstract class to define functionality of a node
 */
public abstract class Node {

	public abstract void addFriend(Node node);
	
	public abstract void removeFriend(Node node);
	
	public abstract void displayFriendNode();
	
	public abstract List<Node> connectedNode();
	
	public abstract boolean isFriend(Node node);
	
	public abstract void blockNode(Node node);
	
	public abstract boolean IsBlocked(Node node);
	
	public abstract void setName(String name);
	
	public abstract String getName();
	
	public abstract void setType(String type);
	
	public abstract String getType();
	
	public abstract void setContact(String contact);
	
	public abstract String getContact();
	
	public abstract void setAddress(String address);
	
	public abstract String getAddress();
}