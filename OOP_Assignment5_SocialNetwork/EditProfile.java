package OOP_Assignment5_SocialNetwork;

import java.util.Scanner;

/**
 * class for editing a user's or organization's profile
 */
public class EditProfile {
	
	private static final int ZERO_LENGTH = 0;

	/**
	 * Method to edit a profile from graph
	 * @param graph : contains graph from which profile is to be deleted
	 * @param sc : scanner object
	 */
	EditProfile(Graph graph, Scanner sc) {
		
		System.out.println("Enter the name of the user whose profile is to be edited:");
		String name = "";
		
		while(name.length() == ZERO_LENGTH) {
			
			name = sc.next().trim();
		}
		Node node = graph.getNode(name);
		
		if(node == null) {
			
			System.out.println(name+" is not present in the system.");
			new EditProfile(graph, sc);
		} else {
			
			Validations validate = new Validations();
			
			node.setName(updateName(sc, validate));

			node.setContact(updateContact(sc, validate));
			
			node.setAddress(updateAddress(sc, validate));
									
			System.out.println("Data has been updated successfully.");
		}
	}
	
	/**
	 * method to update name of user or organization
	 * @param sc : scanner object
	 * @param validate : object of type validations
	 * @return string : holding user input
	 */
	String updateName(Scanner sc, Validations validate) {
		
		System.out.println("Enter the new name of the user:");
		String newName = "";
		while(newName.length() == ZERO_LENGTH) {
			
			newName = sc.nextLine().trim();
		}
		
		if(!validate.validateEntityName(newName)) {
		
			System.out.print("Invalid name(can not have more than 30 words).");
			newName = updateName(sc, validate);
		}
		return newName;
	}
	
	/**
	 * method to update Contact of user or organization
	 * @param sc : scanner object
	 * @param validate : object of type validations
	 * @return string : holding user input
	 */
	public String updateContact(Scanner sc, Validations validate) {

		System.out.println("Enter the new contact number of the user:");
		String contact = sc.next().trim();
			
		if(!validate.validateContact(contact)) {
			
			System.out.print("Invalid contact(should be a 10 digit number).");
			contact = updateContact(sc, validate);
		}
		return contact;
	}

	/**
	 * method to update Address of user or organization
	 * @param sc : scanner object
	 * @param validate : object of type validations
	 * @return string : holding user input
	 */
	public String updateAddress(Scanner sc, Validations validate) {
	
		System.out.println("Enter the new address of the user:");
		String address = "";
		while(address.length() == ZERO_LENGTH) {
			
			address = sc.next().trim();
		}
		
		if(!validate.validateAddress(address)) {

			System.out.print("Invalid address(Not more than 100 words).");
			address = updateAddress(sc, validate);
		}
		return address;
	}
}