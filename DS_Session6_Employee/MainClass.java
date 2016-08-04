package DS_Session6_Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * class to check the employee sorting process
 */
public class MainClass {

	/**
	 * main method
	 * @param args : command line argument
	 */
	public static void main(String[] args) {
	
		HashMap<Integer, Employee> empHash = new HashMap<Integer, Employee>();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		List<Employee> empList = new ArrayList<Employee>();
		MainClass input = new MainClass();
		
		System.out.println("Enter the Employee's data:");
		empList = input.inputEmployee(buffer, empList, empHash);
				
		System.out.println();
		System.out.println("Before Sorting: ");
		Employee.display(empList);
		
		System.out.println("After Natural Sorting: ");
		Collections.sort(empList);
		Employee.display(empList);
		
		System.out.println("After Name Sorting: ");
		Collections.sort(empList, new NameComparator());
		Employee.display(empList);
	}
	
	/**
	 * method to input employee details
	 * @param buffer : BufferedReader object
	 * @param empList : list of employees
	 * @return : list of employees
	 */
	public List<Employee> inputEmployee(BufferedReader buffer, List<Employee> empList, HashMap<Integer, Employee> empHash) {
		
		
		
		int empId = 0;
		String empName = "";
		String empAddress = "";
		
		System.out.print("Enter Employee's Id:");
		empId = intInput(buffer);
		System.out.print("Enter Employee's Name:");
		empName = inputString(buffer);
		System.out.print("Enter Employee's Address:");
		empAddress = inputString(buffer);

		Employee emp = new Employee(empId, empName, empAddress);
		
		if(!empHash.containsKey(empId)) {

			empList.add(emp);
			empHash.put(empId, emp);
		}
		
		System.out.println();
		System.out.print("Do you want to continue(y) ??");
		char repeat = charInput(buffer);
		if(repeat == 'y' || repeat == 'Y') {
			
			inputEmployee(buffer, empList, empHash);
		}
		
		return empList;
	}
	
	/**
	 * method to take string as an input
	 * @param buffer : BufferedReader object
	 * @return : string
	 */
	public String inputString(BufferedReader buffer) {
		
		String input = "";
		try {

			while(input.length() == 0) {
			
				input = buffer.readLine();
			}
		} catch(IOException exp) {
			
			input = inputString(buffer);
		}
		return input;
	}
	
	/**
	 * method to take character as an input
	 * @param buffer : BufferedReader object
	 * @return : character
	 */
	public char charInput(BufferedReader buffer) {
		
		String str = "";
		try {
			
			str = buffer.readLine();	
		}
		catch(IOException exp) {
			
			exp.printStackTrace();
			charInput(buffer);
		}
		return str.charAt(0);
	}
	
	/**
	 * method to take integer as an input
	 * @param buffer : BufferedReader object
	 * @return : integer
	 */
	public int intInput(BufferedReader buffer) {
		
		int input = 0;
		try {
			
			input = Integer.parseInt(buffer.readLine());
			if(input < 0) {
				
				throw new IllegalArgumentException();
			}
		} catch(IllegalArgumentException | IOException exp) {
			
			System.out.println("Please enter positive integers only");
			intInput(buffer);
		}
		return input;
	}
}