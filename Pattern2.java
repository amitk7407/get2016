/**	Assignment 2:
 *
 *	   1 2 3 4 5 
 *	     1 2 3 4 
 *	       1 2 3 
 *		 1 2 
 *		   1
 *
 *	Implement this also as same modular approach that we have used in assignment 1 and write junit test cases for each modules..
 * 
 *
 *  @author Amit Kumar
 *  @date  15-07-2016
 */

package Assignment2;
//import java.util.Scanner;
public class Pattern2 {
	
	//This method calculates the spaces in each row and store that in a string and return that string
    String spacePrint(int row) {

        String space = "";						//we initialize the space string
        for(int i=0 ; i<row ; i++) {			//this loop add spaces in the string
            
            space = space + " ";
        }
       return space;
    }
    
  //This method calculates the numbers in each row and store that in a string and return that string
    String numberPrint(int row, int n) {

        String num = "";						//we initialize the number string
        int temp = 1;
        for(int i=row ; i<n ; i++) {			//this loop add numbers in the string
            
        	num = num+temp;
        	temp++;
        } 
        return num;
    }
    
  //This method prints the pattern
    String[] patternPrint(int total_rows) {
        
    	String[] pattern = new String[total_rows];				//this is a string array to store the pattern
    	for(int row=0 ; row<total_rows ; row++) {				
           	
    		String space = spacePrint(row);						//spacePrint method is called for each row
           	String num = numberPrint(row, total_rows);			//numberPrint method is called for each row
               
           	pattern[row] = space+num;							//spaces and numbers are concatenated to make pattern
    	}
        return pattern;
    }
/*    public static void main(String[] args) {

        Pattern2 print = new Pattern2();
        Scanner sc = new Scanner(System.in);
            
        try {
        	int total_rows = sc.nextInt();
        	String[] pattern = new String[total_rows];
            if(total_rows < 10) {

            	pattern = print.patternPrint(total_rows);
            	for(int row=0 ; row<total_rows ; row++) {
            		System.out.println(pattern[row]);
            	}
            } else {
            	System.out.println("Please enter the valid input!!");
            	System.out.println("Row should be less than 10.");
            }
        } catch(Exception exp) {
        	
        	System.out.println("Row can only be positive number!");
        	System.out.println("Please enter a positive number.");
        }
    }*/
}