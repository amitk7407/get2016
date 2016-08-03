package DS_Assignment4_Hash;

/**
 * class to allocate a room to the guest
 */
public class RoomAllocation {

	Room[] room;
	Guest[] guest;
	
	/**
	 * parameterized constructor to initialize a room array
	 * @param room : array of rooms
	 */
	public RoomAllocation(Room[] room) {
		
		this.room = room;
		createRoom();
	}
	
	/**
	 * method to create a room array
	 */
	public void createRoom() {
		
		for(int index = 0 ; index < room.length ; index++) {
			
			room[index] = new Room(index+1);
		}
	}
	
	/**
	 * method to create a hash code using age of the guest
	 * @param age : age of the guest
	 * @return : hash value
	 */
	public int hashFunction(int age) {
		
		return age % room.length;
	} 
	
	/**
	 * method to allocate a room to the guest
	 * @param guest : guest to be allocated a room
	 */
	public void allocateRoom(Guest guest) {
		
		int roomNo = hashFunction(guest.getAge());
		int counter = 0;
		
		while(room[roomNo].getGuest() != null) {
			
			roomNo++;
			roomNo %= room.length;
			counter++;
			if(counter == room.length) {
				
				System.out.println("All rooms are booked.");
				return;
			}
		}
		room[roomNo].setGuest(guest);
	}
	
	/**
	 * method to print the allocated room to the guest
	 */
	public void printRoomAllocatedList() {
		
		for(int index = 0 ; index < room.length ; index++) {
			
			if(room[index].getGuest() != null) {
				
				System.out.println("Room no. "+room[index].getRoomNO()+" is allocated to "+room[index].getGuest().getName()+"("+room[index].getGuest().getAge()+")");
			}
		}
	}
}