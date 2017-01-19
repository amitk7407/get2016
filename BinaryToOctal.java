/**
 *	Assignment 1:
 *			Write a function (int convertBinaryToOctal(int n) )to convert binary numbers to octal eg.
 *	      		Input:
 *						Binary Number: 110101
 *	     		Output:
 *						Octal Number:  65
 *			Also write JUnit test cases which takes above input and assert octal number.
 *	
 *	@author  Amit Kumar
 * 	@date   13-07-2016 
 */

public class BinaryToOctal {
	
	//This method converts a binary number to an octal number
	int convertBinaryToOctal(int num) {

		int oct = 0;						//we initialize the octal number with 0
		int dec = 0;						//we initialize the decimal number with 0
		int i = 0;
		int temp;
		
	    while(num != 0) {					//This loop is used for converting the binary number into a decimal number
	    
	    	temp = (num % 10) * (int) Math.pow(2,i);
	    	dec += temp;
	        ++i;
	        num /= 10;
	    }
	    i=1;
	    while (dec != 0) {					//This loop is used for converting the decimal number into an octal number        
	    	
	    	temp = (dec % 8) * i;
	    	oct += temp;
	        dec /= 8;
	        i *= 10;
	    }
	    return oct;							//Octal number is returned to the calling method
	}
}