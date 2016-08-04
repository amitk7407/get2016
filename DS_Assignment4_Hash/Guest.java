package DS_Assignment4_Hash;

/**
 * class to create a guest
 */
public class Guest {

	String name = "";
	int age = 0;
	
	/**
	 * parameterized constructor to initialize a guest
	 * @param name : name of the guest
	 * @param age : age of the guest
	 */
	public Guest(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	
	/**
	 * method to set name of the guest
	 * @param name : name of the guest
	 */
	public void setName(String name) {
		
		this.name = name;
	}
	
	/**
	 * method to get the name of the guest
	 * @return : name of the guest
	 */
	public String getName() {
		
		return name;
	}
	
	/**
	 * method to set age of the guest
	 * @param age : age of the guest
	 */
	public void setAge(int age) {
		
		this.age = age;
	}
	
	/**
	 * method to get age of the guest
	 * @return : age of the guest
	 */
	public int getAge() {
		
		return age;
	}
}
