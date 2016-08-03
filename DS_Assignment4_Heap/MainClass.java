package DS_Assignment4_Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class to check the jobs priority queue operations
 */
public class MainClass {

	public static void main(String[] args) {
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		Jobs_Priority jobs = new Jobs_Priority();
		MainClass input = new MainClass();
		char repeat = 'y';
		
		try {

			while(repeat =='y' || repeat == 'Y') {
			
				System.out.println("1. Insertion of new job");
				System.out.println("2. Print job based on priority");
				System.out.println("3. Exit");
		
				int choice = input.intInput(buffer);
		
				switch(choice) {
			
				case 1 :
					input.jobInsertion(buffer, jobs);
					break;
				case 2 :
					System.out.print("The order of jobs completion is :");
					jobs.priorityAssignmentDisplay();
					break;
				case 3 :
					System.out.println("Exited...");
					System.exit(0);
				default :
					System.out.println("Invalid choice.");
					break;
				}
				System.out.println();
				System.out.println("Do you want to continue(y)");
				repeat = input.charInput(buffer);
			}
			buffer.close();
		} catch(IOException exp) {
			
			exp.printStackTrace();
		} catch(Exception exp) {
			
			exp.printStackTrace();
		}
	}
	
	/**
	 * method to input an integer
	 * @param buffer : Buffered Reader
	 * @return : integer
	 */
	public int intInput(BufferedReader buffer) {
		
		int choice = 0;
		try {
			
			String temp = "";
			while(temp.length() == 0) {
				
				temp = buffer.readLine();
			}
			choice = Integer.parseInt(temp);
			
			if(choice < 0) {
				
				throw new IllegalArgumentException();
			}
		} catch(IllegalArgumentException | IOException exp) {
			
			System.out.println("Please enter positive integers only");
			intInput(buffer);
		} catch(Exception exp) {
			
			System.out.println("Please enter positive integers only");
			intInput(buffer);
		}
		return choice;
	}
	
	/**
	 * method to insert the jobs in the priority queue
	 * @param buffer : Buffered Reader
	 * @param jobs : Jobs_Priority object
	 */
	public void jobInsertion(BufferedReader buffer, Jobs_Priority jobs) {
		
		char repeat ='y';
	
		while(repeat == 'y' || repeat == 'Y') {
			
			System.out.println("Please enter departments from the following list:");
			System.out.println("1.UnderGraduate\n2.Graduate\n3.Professor\n4.Department Chair");
				
			jobs.inputDepartment(buffer);	
			System.out.println("Do you want to enter more nodes(y)");
			repeat = charInput(buffer);
		}
	}
	
	/**
	 * method to take character as an input
	 * @param buffer : Buffered Reader
	 * @return : character
	 */
	public char charInput(BufferedReader buffer) {
		
		String str = "";
		try {
			
			while(str.length() == 0) {
				
				str = buffer.readLine();
			}	
		}
		catch(IOException exp) {
			
			charInput(buffer);
		} catch(Exception exp) {
			
			charInput(buffer);
		}
		return str.charAt(0);
	}
}