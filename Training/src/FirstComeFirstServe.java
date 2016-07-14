/**
 *	Assignment 4:
 *			Write a java  function int [][]FCFS( int arrival_time [], int job_size[] ) to simulate FCFS (First come First Server) scheduler of a machine.  First parameter represents list of jobs arrival time and second parameter represent length for respective job. Function should display wait time for each job for cpu cycle. Assume CPU cycle start with 1 for processing.  
 *				Input:
 *						Arrival_time [1, 5, 9, 25]
 *						Job_size [12,7,2,5]
 *				Output:
 *						Job       job arrived time      Job wait time    Job Start at         Job finished at
 *						1          1                               0	                1                         12
 *						2          5   	                 8                          13                       19
 *						3          9                               11                        20                       21
 *						4          25                             0                          25                       29
 *
 *				Note: To create JUNIT Test Case for array problem , you need to create a sample function that will take 2 input ( first one will be expected 2D array and second input will be 2D array came after above function call)
 *				isArrayEqual(int expected[][], int output[][])
 *
 *				Write JUnit test cases using a method which asserts on the return value of isArrayEqual method.
 * 
 * 
 *  @author  Amit Kumar
 *  @date   13-07-2016
 */
public class FirstComeFirstServe {

	//this method performs the first come first served process
	 int[][] FCFS(int arrival_time[], int job_size[]) {
		 
		 int[][] result = new int[job_size.length][5];
		 int job_finish = 0;
		 int wait_time = 0;
		 
		 if(arrival_time.length == job_size.length) {
			 
			 for(int i=0 ; i<arrival_time.length ; i++) {
				 
				 if(arrival_time[i]>=0 && job_size[i]>=0) {
					 
					 result[i][0] = i+1;							//this provides job number in the first column
					 result[i][1] = arrival_time[i];				//this provides arrival time in the second column
					 if((job_finish+1) < arrival_time[i]) {
						 job_finish = arrival_time[i]-1;
					 }
					 wait_time = (job_finish+1) - arrival_time[i];
					 result[i][2] = wait_time;						//this provides wait time in the third column
					 result[i][3] = job_finish+1;					//this provides finish time in the fourth column
					 job_finish = job_finish+job_size[i];
					 result[i][4] = job_finish;						//this provides finish time in the fifth column
				 } else {
					 System.out.print("arrival time and job size should be positive");
				 }
			 }
		 } else {
			 System.out.print("No of arrival times should be equal to the no of jobs");
		 }
		 return result;
	 }
}