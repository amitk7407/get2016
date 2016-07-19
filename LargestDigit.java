/**
 *	Assignment 1:
 *		
 *		Write recursive functions for the following:
 *		
 *			c) int largestdigit(int x) where x >= 0,  to find out the largest digit in the number x.
 *				Also, Write following JUnits cases:
 *					largestdigit(2)
 *					largestdigit(1257369)
 *					largestdigit(444)
 *
 *
 *  @author amitk407
 *  @date  16-07-2016
 *  
 */

package Assignment3;

//import java.util.Scanner;

public class LargestDigit {

	int global = 0;
	//this method finds the largest digit in a number and returns the result
	int largestDigit(int num) {
		if(global==0 && num<=0) {		//this checks for positive number
			return -1;
		} else if(num > 0) {				//we check if the number is greater than zero or not
			int remainder = num%10;			//it gives the last digit of the number
			int remainder1 = largestDigit(num/10);		//it recursively reduces the number to the last digit
			if(remainder > remainder1) {		//it checks the greatest of the two digits from last
				global++;
				return remainder;
			}
			return remainder1;
		}
		return 0;				//if there is a number less than 1 it gives zero as result
	}
	
/*	public static void main(String[] args) {
		
		int num;
		Scanner sc = new Scanner(System.in);
		try {
			num = sc.nextInt();
			
			LargestDigit largest = new LargestDigit();

			int result = largest.largestDigit(num);
			if(result == -1) {
				System.out.println("The number should not be negative");
			} else if(result == 0) {
					System.out.println("Please enter a number greater than zero");
			} else {
				System.out.println("The largest digit in "+num+" is "+result);
			}
		} catch(Exception exp) {
			System.out.println("The numbers should be integers and less than 2147483648");
		}
	}*/
}