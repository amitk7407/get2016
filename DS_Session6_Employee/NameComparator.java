package DS_Session6_Employee;

import java.util.Comparator;

/**
 * class to compare the employee objects using their name
 */
public class NameComparator implements Comparator<Employee> {

	/**
	 * method to compare two objects of the employee
	 */
	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		return emp1.getEmployeeName().compareTo(emp2.getEmployeeName());
	}
}