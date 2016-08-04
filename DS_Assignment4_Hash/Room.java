package DS_Assignment4_Hash;

/**
 * class to create a room
 */
public class Room {

	int roomNO;
	Guest guest;

	/**
	 * parameterized constructor to initialize a room
	 * @param roomNO : room number of the room
	 */
	public Room(int roomNO) {
		
		this.roomNO = roomNO;
		guest = null;
	}

	/**
	 * method to get the room number
	 * @return : returns room number
	 */
	public int getRoomNO() {
		
		return roomNO;
	}

	/**
	 * method to set the room number
	 * @param roomNO : room number
	 */
	public void setRoomNO(int roomNO) {
		
		this.roomNO = roomNO;
	}	

	/**
	 * method to get the guest associated with a room
	 * @return : guest object
	 */
	public Guest getGuest() {
		
		return guest;
	}

	/**
	 * method to associate the guest with a room
	 * @param guest : guest object
	 */
	public void setGuest(Guest guest) {
		
		this.guest = guest;
	}
}
