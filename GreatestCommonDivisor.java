/**
 *	Assignment 1:
 *
 *		Write recursive functions for the following:
 *
 *			b) int gcd(int x, int y) where x > 0 and y > 0, to compute the greatest common divisor of x and y. 
 *				Also, Write following JUnits cases:
 *					gcd(2, 1)
 *					gcd(12, 18)
 *					gcd(100, 3)
 *
 *  @author amitk407
 *  @date  16-07-2016
 *  
 */

package Assignment3;

//import java.util.Scanner;

public class GreatestCommonDivisor {

	int global = 0;
	//This method finds the greatest common divisor and returns the result
	int GCD(int num, int den) {
		if(global==0 && (den<=0 || num<=0)) {		//this checks for positive numerator and denominator
			return -1;
		} else if(den > 0) {			//we check if denominator is greater than zero
			global++;
			num = GCD(den, num%den);		//we recursively call the gcd method
		}
		return num;
	}

/*	public static void main(String[] args) {
		
		int num, den;
		Scanner sc = new Scanner(System.in);
		try {
			num = sc.nextInt();
			den = sc.nextInt();
		
			GreatestCommonDivisor gcd = new GreatestCommonDivisor();

			int result = gcd.GCD(num, den);
			System.out.print(result);
			if(result == -1) {
				System.out.println("Both numbers should be positive and greater than zero");
			} else {
				System.out.println("The Greatest Common Divisor of "+num+" and "+den+" is "+result);
			}
		} catch(Exception exp) {
			System.out.println("The numbers should be integers and less than 2147483648");
		}
	}*/
}