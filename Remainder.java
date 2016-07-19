/**
 *	Assignment 1:
 *
 *		Write recursive functions for the following:
 *
 *			a) int rem(int x, int y) where x >=0 and y > 0, to compute the remainder of x divided by y.
 *				Also, Write following JUnits cases:
 *					rem(2, 1)
 *					rem(2, 0)
 *					rem(100, 3)
 *
 *  @author amitk407
 *  @date  16-07-2016
 *  
 */

package Assignment3;

//import java.util.Scanner;

public class Remainder {

	int global = 0;
	//this method finds the remainder of two numbers and return the result
	int rem(int num, int den) {
	
		if(global==0 && (den<=0 || num<0)) {		//here we check for positive numerator and denominator
			return -1;
		} else if(global==0 && num/den>=17000) {	//here large range of numbers are handled
				num = num - (num/den) * den;
//				num = num%den;
		} else if(num >= den) {			//we check if the numerator is greater than or equal to denominator
			global++;
			num = rem(num-den, den);		//we recursively call the rem method
		}
		return num;
	}

/*	public static void main(String[] args) {
		
		int num, den;
		Scanner sc = new Scanner(System.in);
		try {
			num = sc.nextInt();
			den = sc.nextInt();
			
			Remainder remainder = new Remainder();
			int result = remainder.rem(num, den);
					
			if(result == -1) {
				System.out.println("Both numbers should be positive and greater than zero");
			} else {
				System.out.println("The remainder is "+result);		
			}
		}
	//	catch(StackOverflowError err) {
	//		
	//		System.out.println("Please enter a numerator which is atmost 17000 times the denominator");
	//	}
		catch(Exception exp) {
			
			System.out.println("The numbers should be integers and less than 2147483648");
		}
	}*/
}