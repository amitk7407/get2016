/**
 *	Assignment 1: 
 *
 *		Tower of Hanoi
 *			List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk)
 *			Write JUnit for the above program:
 *				towerOfHanoi(“A”, “B”, “C”, 1);
 *					Expected: Returns List of movements of discs.
 *					Move Disk 1 from A to B 
 *
 *				towerOfHanoi(“A”, “B”, “C”, 2);
 *					Expected: Returns List of movements of discs.
 *					Move Disk 2 from A to C 
 *					Move Disk 1 from A to B 
 *					Move Disk 2 from C to B
 *
 *				towerOfHanoi(“A”, “B”, “C”, 3);
 *					Expected: Returns List of movements of discs.
 *					Move Disk 3 from A to B 
 *					Move Disk 2 from A to C 
 *					Move Disk 3 from B to C
 *					Move Disk 1 from A to B 
 *					Move Disk 3 from C to A 
 *					Move Disk 2 from C to B
 *					Move Disk 3 from A to B
 *
 *
 *  author Amit Kumar
 *  date 18-07-2016
 *  
 */

package Assignment4;

import java.util.*;

import java.util.Scanner;

public class TowerOfHanoi {

	//this method takes the number of disks and rods name and output the list array of steps
	List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk, List<String> result) {
		
		if(numOfDisk <= 0) {		//we check if there are disks or not
			
			System.out.println("Please enter greater than zero disks");
		} else if(numOfDisk == 1) {		//it checks if there is only one disk and directly move the disks
			
			result.add("Move Disk "+numOfDisk+" from "+source+" to "+destination);
		} else {				//recursive calls are made to move the disks and store the output in an array list
			
			towerOfHanoi(source, temp, destination, numOfDisk-1, result);
			result.add("Move Disk "+numOfDisk+" from "+source+" to "+destination);
			towerOfHanoi(temp, source, destination, numOfDisk-1, result);
		}
		return result;
	}	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
		
			TowerOfHanoi tower = new TowerOfHanoi();
			System.out.print("Please enter the total number of disks: ");
			int numOfDisk = sc.nextInt();			//No. of disks is taken as input
			List<String> result = new ArrayList<String>();
			result = tower.towerOfHanoi("A", "C", "B", numOfDisk, result);	//towerOfHanoi method is called
			for(String str:result) {
			
				System.out.println(str);			//the result is printed
			}
		} catch(StackOverflowError|OutOfMemoryError err) {
			
			System.out.print("Please enter  a reasonable amount of disks");
		} catch(InputMismatchException exp) {
			
			System.out.print("Please enter  a valid input");
		}
		finally {
			
			sc.close();				//at last the scanner object is closed
		}
	}
}