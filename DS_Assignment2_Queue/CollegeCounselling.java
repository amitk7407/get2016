package DS_Assignment2_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class to organize counselling
 */
public class CollegeCounselling {

	Queue<Candidate> candidateList = new Queue<Candidate>();
	Queue<College> collegeList = new Queue<College>();
	
	/**
	 * method to enter the student data
	 */
	public void studentList() {
			
		candidateList.enqueue(new Candidate("Amit", 1));
		candidateList.enqueue(new Candidate("Ankit", 2));
		candidateList.enqueue(new Candidate("Noor", 3));
		candidateList.enqueue(new Candidate("Simran", 4));
		candidateList.enqueue(new Candidate("Vaibhav", 5));
		candidateList.enqueue(new Candidate("Ajinkya", 6));
		candidateList.enqueue(new Candidate("Arpit", 7));
		candidateList.enqueue(new Candidate("Rahul", 8));
		candidateList.enqueue(new Candidate("Raj", 9));
		candidateList.enqueue(new Candidate("Pulkit", 10));
		candidateList.enqueue(new Candidate("Avinash", 11));
		candidateList.enqueue(new Candidate("abhishek", 12));
		candidateList.enqueue(new Candidate("Rohit", 13));
	}
	
	/**
	 * method to enter the college data
	 */
	public void collegeList() {
		
		collegeList.enqueue(new College("JNIT", 1, 1));
		collegeList.enqueue(new College("JECRC", 2, 2));
		collegeList.enqueue(new College("YIT", 3, 1));
		collegeList.enqueue(new College("SKIT", 4, 1));
		collegeList.enqueue(new College("POORNIMA", 5, 2));
		collegeList.enqueue(new College("GIT", 6, 3));	
	}
	
	/**
	 * method to conduct counselling
	 * @return : list of students and allocated colleges
	 */
	public List<String> startCounselling() {
		
		int[] count = new int[collegeList.size()];
		List<String> result = new ArrayList<String>();
		int total = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(int index=0 ; index<collegeList.size() ; index++) {
			
			count[index] = collegeList.get(index).getSeats();		//array count is set with the total seats in each college
		}
		
		for(int index=0 ; index<candidateList.size() ; index++) {
																	//process is conducted for each student till there is seat
			int temp = 0;
			for(int collegeIndex=0 ; collegeIndex < collegeList.size() ; collegeIndex++) {
				
				if(count[collegeIndex] != 0) {						//checking if seats are still available
					
					temp = 1;
				}
			} 

			if(temp == 1) {											//condition true if seats are available
				
				System.out.println("Hii "+candidateList.get(index).getname());
				System.out.println("Please enter the college you want to counsel for from the given list:");
			
				checkForColleges(count, sc, candidateList.get(index).getname(), result, total);
			} else {												//else registration is closed
				System.out.println("All seats are full in all the colleges.");
				System.out.println("Registration closed!");
				for(int seatIndex=0 ; seatIndex<collegeList.size() ; seatIndex++) {		//sets the seats to zero after allocation of all the seats
				
					collegeList.get(seatIndex).setSeats(0);
				}
				return result;
			}
		}
		sc.close();
		for(int seatIndex=0 ; seatIndex<collegeList.size() ; seatIndex++) {
			
			collegeList.get(seatIndex).setSeats(0);
		}
		return result;
	}
	
	/**
	 * method to check for the available seat in the colleges
	 * @param count : array of seats
	 * @param sc : scanner object
	 * @param name : name of the student
	 * @param result : resultant list
	 * @param total : variable
	 */
	public void checkForColleges(int[] count, Scanner sc, String name, List<String> result, int total) {
		
		for(int index=0 ; index<collegeList.size() ; index++) {
			
			System.out.print(collegeList.get(index).getName()+"       ");
		}
		String college = "";
		while(college.isEmpty()) {
			college = sc.nextLine();
		}
		int flag = 0;
		for(int index2 = 0 ; index2<collegeList.size() ; index2++) {
			
			if(collegeList.get(index2).getName().equalsIgnoreCase(college) && count[index2] > 0) {
			
				System.out.println("Your request has been registered");
				result.add(name+"-----"+collegeList.get(index2).getName());
				total++;
				count[index2]--;
				flag = 1;
				break;
			} else if(collegeList.get(index2).getName().equalsIgnoreCase(college) && count[index2] <= 0) {
				
				System.out.println("Please enter another college.");
				System.out.println("The seats are already full.");
			}
		}
		if(flag == 0) {
			System.out.println("Please enter from the given colleges.");
			checkForColleges(count, sc, name, result, total);
		}
	}
	
	/**
	 * method to display the list of college allocation to students
	 * @param result : the list of the allocated colleges to the students
	 */
	public void displayCollegeAllocation(List<String> result) {
		
		System.out.println("The allocated seats to the students are:-");
		for(int index=0 ; index<result.size() ; index++) {
			
			System.out.println(result.get(index));
		}
	}
}