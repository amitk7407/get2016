/**
 *	Assignment 1:
 *	
 *			   1
 *			 1 2 1
 *		   1 2 3 2 1
 *		 1 2 3 4 3 2 1
 *     1 2 3 4 5 4 3 2 1
 *	     1 2 3 4 3 2 1
 *	       1 2 3 2 1
 *	         1 2 1
 *			   1
 *
 *	Write a program to display above pyramid using modular approach. 
 *
 *	Divide whole problem in 3 parts as per describe in the presentation.
 *
 *	1. spaces(row, n): return the spaces string
 *	2. numbers(row, n): return the number string
 *	3. print whole pyramid : It will return the array of string by using above 2 functions.
 *
 *	Also write JUnit test cases for each modules. 
 *
 *
 *  @author   Amit Kumar
 *  @date    15-07-2016
 *
 *
 */

package Assignment2;
//import java.util.Scanner;
public class Pattern1 {

	//This method calculates the spaces in each row and store that in a string and return that string
    String spacePrint(int row,int total_rows) {
        
    	String space = "";						//we initialize the space string
    	if(row <= total_rows/2) {				//this condition is true for (half+1) of the total rows
        	for(int index=0 ; index<(total_rows/2-row) ; index++) {		//this loop add spaces in the string
 				
	            space = space+" ";
	        }
    	}
    	else { 
    		for(int index=0 ; index<(row-total_rows/2) ; index++) {		//this loop add spaces in the string
        			
	            space = space+" ";
	        }
    	}
    	return space;
    }
    
	//This method calculates the numbers in each row and store that in a string and return that string
    String numberPrint(int row, int total_rows) {
    	
        String num = "";									//we initialize the number string
        int temp = 0;
        if(row <= total_rows/2) {							//this condition is true for (half+1) of the total rows
        	for(int index=0 ; index<(2*row+1) ; index++) {	//this loop add numbers in the string
        		if(index <= row) {							//this condition helps to store the numbers in increasing order
        			temp++;
        			num = num+temp;
        		} else {									//this condition helps to store the numbers in decreasing order
        			temp--;
        			num = num+temp;
        		}
        	}
        } else {
        	for(int index=0 ; index<(2*(total_rows-row)-1) ; index++) {		//this loop add numbers in the string
        		if(index < total_rows-row) {				//this condition helps to store the numbers in increasing order
        			temp++;
        			num = num+temp;
        		} else {									//this condition helps to store the numbers in decreasing order
        			temp--;
        			num = num+temp;
        		}
        	}
        }
        return num ;
    }
    
    //This method prints the pattern
    String[] patternPrint(int total_rows) {
    	
       	String[] pattern = new String[total_rows];				//this is a string array to store the pattern
       	for(int row=0 ; row<total_rows ; row++) {				
       	
       		String space = spacePrint(row, total_rows);			//spacePrint method is called for each row
       		String num = numberPrint(row, total_rows);			//numberPrint method is called for each row
           
       		pattern[row] = space+num;							//spaces and numbers are concatenated to make pattern
       	}
       	return pattern;
    }
    
/*    public static void main(String[] args) {
       
    	Pattern1 print_pattern=new Pattern1();
        Scanner sc = new Scanner(System.in);
        
        try {
        	int total_rows = sc.nextInt();
        	String[] pattern = new String[total_rows];
            if(((total_rows/2+1) < 10) && (total_rows%2 != 0)) {

            	pattern = print_pattern.patternPrint(total_rows);
            	for(int row=0 ; row<total_rows ; row++) {
            		System.out.println(pattern[row]);
            	}
            } else {
            	System.out.println("Please enter the valid input!!");
            	System.out.println("Row should be an odd number and less than 18.");
            }
        } catch(Exception exp) {
        	
        	System.out.println("Row can only be positive number!");
        	System.out.println("Please enter a positive number.");
        }        
    }*/
}