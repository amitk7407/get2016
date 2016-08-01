package DS_Assignment2_Queue;

import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		
		CollegeCounselling college = new CollegeCounselling();
		college.studentList();
		college.collegeList();
		List<String> result = college.startCounselling();
		college.displayCollegeAllocation(result);
	}
}
