package DS_Session6_Employee;

import java.util.List;

/**
 * class to take employees data
 */
public class Employee implements Comparable<Employee>{

	int employeeId;
	String employeeName, employeeAddress;
	
	/**
	 * parameterized constructor to initialize an employee object
	 * @param employeeId : id of the employee
	 * @param employeeName : name of the employee
	 * @param employeeAddress : address of the employee
	 */
	public Employee(int employeeId, String employeeName, String employeeAddress) {
	
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	
	/**
	 * method to get the employee id
	 * @return : employeeId
	 */
	public int getEmployeeId() {
	
		return employeeId;
	}
	
	/**
	 * method to set the employee id
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
	
		this.employeeId = employeeId;
	}

	/**
	 * method to get the employee name
	 * @return : employee name
	 */
	public String getEmployeeName() {
	
		return employeeName;
	}

	/**
	 * method to set the employee name
	 * @param employeeName
	 */
	public void setEmployeeName(String employeeName) {
	
		this.employeeName = employeeName;
	}

	/**
	 * method to get the employee address
	 * @return : employee address
	 */
	public String getEmployeeAddress() {

		return employeeAddress;
	}

	/**
	 * method to set the employee address
	 * @param employeeAddress
	 */
	public void setEmployeeAddress(String employeeAddress) {

		this.employeeAddress = employeeAddress;
	}	
	
	/**
	 * method to display the list of the employees
	 * @param empList : list of the employee
	 */
	public static void display(List<Employee> empList) {
		
		for(Employee e : empList) {
			
			System.out.println(e.getEmployeeId()+"\t"+e.getEmployeeName()+"\t"+e.getEmployeeAddress());
		}
	}
	
	/**
	 * method to compare two objects of employee
	 */
	@Override
	public int compareTo(Employee emp) {
	
		if(this.getEmployeeId() == emp.getEmployeeId()) {
		
			return 0;
		} else if(this.getEmployeeId() > emp.getEmployeeId()) {
			
			return 1;
		} else {
			
			return -1;
		}
	}
}