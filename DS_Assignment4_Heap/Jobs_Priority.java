package DS_Assignment4_Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * class to create a job priority queue
 */
public class Jobs_Priority {

	private HashMap<String, Integer> jobs;
	private Heap<Integer> heap;
	
	/**
	 * unparameterized constructor to create an empty priority queue
	 */
	public Jobs_Priority() {
		
		heap = new Heap<Integer>();
		jobs = new HashMap<String, Integer>();
		heap.build_Max_Heap();
		departmentList();
	}
	
	/**
	 * method to create a hash map of departments along with their priorities
	 */
	public void departmentList() {
		
		jobs.put("department chair", 4);
		jobs.put("professor", 3);
		jobs.put("graduate", 2);
		jobs.put("undergraduate", 1);
	}
	
	/**
	 * method to input the department from the user
	 * @param buffer : Buffered Reader object
	 */
	public void inputDepartment(BufferedReader buffer) {
		
		String department = "";
		try {
			
			while(department.length() == 0) {
		
				department = buffer.readLine();
			}
			department = department.toLowerCase().trim();
			if(jobs.containsKey(department)) {
		
				heap.insert(jobs.get(department));
			} else {
			
				System.out.print("Please enter from the given options:");
				inputDepartment(buffer);
			}
		} catch(IOException exp) {
			
			exp.printStackTrace();
			inputDepartment(buffer);
		}
	}
	
	/**
	 * method to do the highest priority jobs first
	 */
	public void priorityAssignmentDisplay() {
		
		if(heap.isEmpty()) {
			
			System.out.println("There are no jobs in the priority queue.");
		} else {

			while(!heap.isEmpty()) {

				System.out.print(heap.delete()+"  ");
			}
		}
	}		
}