/**
 * 
 *	Assignment 6:
 *			Write a program to join two sorted arrays and generate third sorted array.
 *				int[] join(int a[], int asize, int b[], int bsize, int c[])
 *				asize is number of elements in array a , bsize is number of elements in array b
 *				Assume array c has sufficient space to store elements. Do not sort array c explicit.
 *			Write JUnit test cases using a method which takes two arrays as input and return true or false for asserting
 *
 *
 *  
 *  @author  Amit Kumar
 *  @date   13-07-2016
 */
public class SortedArrayJoin {

	//this method joins the two sorted array
	int[] join(int a[], int asize, int b[], int bsize, int c[]) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < asize && j < bsize) {		//this loop merges the two arrays in sorted manner into third array
	        
			if (a[i] < b[j]) {
	            c[k] = a[i];
	            i++;
	        } else {
	            c[k] = b[j];
	            j++;
	        }
	        k++;
	    }

	    while (i < asize) {					//this loop copies the remaining elements in the array to the final array
	        c[k] = a[i];
	        i++;
	        k++;
	    }

	    while (j < bsize) {					//this loop copies the remaining elements in the array to the final array
	        c[k] = b[j];
	        j++;
	        k++;
	    }
	    return c;
	}
}