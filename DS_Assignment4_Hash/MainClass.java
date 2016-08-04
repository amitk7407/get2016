package DS_Assignment4_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class to check for the room allocation process
 */
public class MainClass {

	public static void main(String[] args) {

		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		MainClass input = new MainClass();
		
		try {

			System.out.print("Enter the total number of rooms in the Hotel:");
			int roomCount = input.intInput(buffer);
			Room[] room = new Room[roomCount];
			RoomAllocation roomAllocation = new RoomAllocation(room);
		
			System.out.print("Enter the total number of guests:");
			int guestCount = input.intInput(buffer);
			Guest[] guest = new Guest[guestCount];
		
			if(!input.validateCount(roomCount, guestCount)) {
				
				main(args);
			} else {

				System.out.println(guestCount);
				for(int index = 0 ; index < guestCount ; index++) {
					
					System.out.println();
					System.out.print("Enter the guest "+(index+1)+" name: ");
					String name = buffer.readLine();
					System.out.print("Enter the guest "+(index+1)+" age: ");
					int age = input.intInput(buffer);
					guest[index] = new Guest(name, age);
				}
		
				for(int index = 0 ; index < guestCount ; index++) {
					
					roomAllocation.allocateRoom(guest[index]);
				}
				
				roomAllocation.printRoomAllocatedList();
			}
		} catch(IOException exp) {
			
			System.out.println(exp.getMessage());
			System.out.println("Please enter again.");
			main(args);
		} finally {
			
			try {
			
				buffer.close();
			} catch(IOException exp) {
				
				exp.printStackTrace();
			}
		}
	}
	
	/**
	 * method to input an integer
	 * @param buffer : Buffered Reader
	 * @return : integer
	 */
	public int intInput(BufferedReader buffer) {
		
		int input = 0;
		try {
			
			String temp = "";
			while(temp.length() == 0) {
				
				temp = buffer.readLine();
			}
			input = Integer.parseInt(temp);
			
			if(input < 0) {
				
				throw new IllegalArgumentException();
			}
		} catch(IllegalArgumentException | IOException exp) {
			
			System.out.println("Please enter positive integers only");
			input = intInput(buffer);
		} catch(Exception exp) {
			
			System.out.println("Please enter positive integers only");
			input = intInput(buffer);
		}
		return input;
	}	
	
	/**
	 * method to check if room are greater than guests or not
	 * @param roomCount : number of rooms
	 * @param guestCount : number of guests
	 * @return : boolean
	 */
	public boolean validateCount(int roomCount, int guestCount) {
		
		if(guestCount > roomCount) {
			
			System.out.println("Guest count should be less than room count.");
			System.out.println();
			return false;
		}
		return true;
	}
}