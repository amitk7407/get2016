package OOP_Assignment5_SocialNetwork;

/**
 * class to validate the user inputs
 */
public class Validations {

	/**
	 * method to validate name
	 * @param name : user input
	 * @return boolean
	 */
	public boolean validateEntityName(String name) {
		
		if(name.length()>30) { 
			
			return false;
		}
		char[] nameArray=new char[name.length()];
		nameArray=name.toCharArray();
		
		for(char temp : nameArray) {
			
			if((temp < 65 && temp != 32 ) || ( temp > 90 && temp < 97 ) || temp > 122 ) {
				
				return false;		
			}
		}
		return true;
	}
	

	/**
	 *  method to validate contact
	 * @param contact : user input
	 * @return boolean
	 */
	public boolean validateContact(String contact) {
		
		if(contact.length() != 10) { 
			
			return false;		
		} 
		char[] contactArray=new char[contact.length()];
		contactArray=contact.toCharArray();
		
		for(char temp : contactArray) {
			
			if(temp < 48 || temp > 57) {
				
				return false;	
			}
		}
		return true;
	}

	/**
	 * method to validate address
	 * @param address : user input
	 * @return boolean
	 */
	public boolean validateAddress(String address) {
		
		if(address.length() == 0 || address.length() > 100) {
			
			return false;
		}
		return true;
	}
}