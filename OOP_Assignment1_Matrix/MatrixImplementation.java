/**
 * 	Question 2:
 *		
 *	 Implement Matrix Class as discussed in session.
 *	 Write proper unit test for addElements, transpose, show, multiplication methods. 
 *
 *	Notes
 *		No SOP in any class other than Main class.
 *		No console reading other than Main class.
 *		Class/Method/Object/Variable names should be self-explanatory.
 *		Write short classes and methods
 *		Follow naming conventions
 *
 *  author Amit Kumar
 *  date 19-07-2016
 *  
 */
package OOP_Assignment1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixImplementation {
	
	
	//this method takes the input of the matrix from the user
	int[][] inputMatrix(Scanner scannerObject) throws InputMismatchException, ArrayIndexOutOfBoundsException {
				
		System.out.print("Enter the number of rows you want in matrix");
		int rows = scannerObject.nextInt();		
		System.out.print("Enter the number of columns you want in matrix");
		int columns = scannerObject.nextInt();
	
		if(rows<=0 || columns<=0) {				//If number of rows or columns is less than or equal to zero then an exception is thrown
			
			throw new ArrayIndexOutOfBoundsException();
		} else {
			int[][] matrix = new int[rows][columns];			//matrix is initialized
			System.out.print("Enter the elements in matrix");
		
			for(int rowIndex=0 ; rowIndex<rows ; rowIndex++) {			//elements in the matrix is fed
				for(int columnIndex=0 ; columnIndex<columns ; columnIndex++) {
					matrix[rowIndex][columnIndex] = scannerObject.nextInt();
				}
			}
			return matrix;
		}
	}
	

	//this method takes two matrices and returns the sum of the matrices
	int[][] addMatrixElements(int[][] matrix1, int[][] matrix2) {
		
		int[][] sum;
		if((matrix1.length == matrix2.length) && (matrix1[0].length == matrix2[0].length)) {	/*it checks for the 
																					equal dimensions of the two matrices*/

			sum = new int[matrix1.length][matrix1[0].length];			//resultant matrix is initialized
			for(int rowIndex=0 ; rowIndex<matrix1.length ; rowIndex++) {		//both matrices are added
				for(int columnIndex=0 ; columnIndex<matrix1[0].length ; columnIndex++) {
					sum[rowIndex][columnIndex] = matrix1[rowIndex][columnIndex] + matrix2[rowIndex][columnIndex];
				}
			}			
		} else {		//if the dimensions of the matrices are different then it returns the null matrix
			sum = null;
		}
		return sum;
	}
	
	
	//this method computes the transpose of the matrix
	int[][] matrixTranspose(int[][] matrix) {

		int[][] transpose = new int[matrix[0].length][matrix.length];		//a matrix has been initialized
		for(int rowIndex=0 ; rowIndex<matrix.length ; rowIndex++) {		//here the matrix has been transposed
			for(int columnIndex=0 ; columnIndex<matrix[0].length ; columnIndex++) {
				transpose[columnIndex][rowIndex] = matrix[rowIndex][columnIndex];
			}
		}
		return transpose;
	}
	
	
	//this method prints the matrix
	void showMatrix(int[][] matrix) {
		
		for(int rowIndex=0 ; rowIndex<matrix.length ; rowIndex++) {		//here the matrix is printed
			for(int columnIndex=0 ; columnIndex<matrix[0].length ; columnIndex++) {
				System.out.print(matrix[rowIndex][columnIndex]+" ");
			}
			System.out.println();
		}
	}
	
	
	//this methods multiplies the two matrices and returns the result
	int[][] matrixMultiplication(int[][] matrix1, int[][]matrix2) {
		
		int multiply[][];
		if(matrix1[0].length == matrix2.length) {	/*it checks if the column count of first matrix
														is equal to the row count of the second matrix*/

			multiply = new int[matrix1.length][matrix2[0].length];		//the resultant matrix has been initialized
			for(int rowIndex=0 ; rowIndex<matrix1.length ; rowIndex++) {		//the multiplication of the matrices has been calculated
				for(int columnIndex=0 ; columnIndex<matrix2[0].length ; columnIndex++) {
					for(int index=0 ; index<matrix2.length ; index++) {
						multiply[rowIndex][columnIndex] = multiply[rowIndex][columnIndex]
								+ (matrix1[rowIndex][index] * matrix2[index][columnIndex]);	
					}
				}
			}			
		} else {			//if the conditions fails it returns the null matrix
			multiply = null;
		}
		return multiply;
	}
	
	
	public static void main(String[] args) {
		
		MatrixImplementation matrixObject = new MatrixImplementation();
		Scanner scannerObject =new Scanner(System.in);
		int[][] result = null;
	//	while(true) {
			try {
				
				System.out.println("Enter 1 for entering a matrix");
				System.out.println("Enter 2 for transposing a matrix");
				System.out.println("Enter 3 for addition of two matrices");
				System.out.println("Enter 4 for multiplication of two matrices");
				System.out.println("Enter 0 for exit");
				
				System.out.print("Enter your choice:");
				int operation = scannerObject.nextInt();
				switch(operation) {
			
					case 0:
						System.exit(0);
					
					case 1:						//inputs an array
						System.out.println("Enter a matrix:-");
						result = matrixObject.inputMatrix(scannerObject);
						System.out.println("The input matrix is as follows:-");
						matrixObject.showMatrix(result);
						break;
				
					case 2:						//transpose an array
						System.out.println("Enter a matrix:-");
						result = matrixObject.inputMatrix(scannerObject);
						result = matrixObject.matrixTranspose(result);
						System.out.println("The transpose of matrix is:-");
						matrixObject.showMatrix(result);
						break;
				
					case 3:						//sum of the matrices
						System.out.println("Enter two matrices for addition:");
						System.out.println("Enter first matrix:");
						int[][] matrix1Sum = matrixObject.inputMatrix(scannerObject);
							
						System.out.println("Enter second matrix:");
						int[][] matrix2Sum = matrixObject.inputMatrix(scannerObject);
						
						System.out.println("Matrix1 is:");
						matrixObject.showMatrix(matrix1Sum);
						System.out.println("Matrix2 is:");
						matrixObject.showMatrix(matrix2Sum);
						
						result = matrixObject.addMatrixElements(matrix1Sum, matrix2Sum);
						if(result == null) {		//if null matrix is accepted then this will gets executed
						
							System.out.print("Please enter the matrices with the same dimension");
						} else {
							System.out.println("The sum of the matrices is:-");
							matrixObject.showMatrix(result);
						}
						break;
				
					case 4:					//multiplication of the matrices
						System.out.println("Enter two matrices for multiplication:");
						System.out.println("Enter first matrix:");
						int[][] matrix1Multiply = matrixObject.inputMatrix(scannerObject);
						
						System.out.println("Enter second matrix:");
						int[][] matrix2Multiply = matrixObject.inputMatrix(scannerObject);
						
						System.out.println("Matrix1 is:");
						matrixObject.showMatrix(matrix1Multiply);
						System.out.println("Matrix2 is:");
						matrixObject.showMatrix(matrix2Multiply);
						
						result = matrixObject.matrixMultiplication(matrix1Multiply, matrix2Multiply);
						if(result == null) {			//if null matrix is accepted then this will gets executed
						
							System.out.print("Please enter th matrices such that the column count of first matrix should be equal to the row count of the second matrix");
						} else {
							System.out.println("The multiplication of the matrices is:-");
							matrixObject.showMatrix(result);
						}
						break;
				}
			
			} catch(InputMismatchException exp) {
				
				System.out.print("Please enter the integer dimensions");
			} catch(ArrayIndexOutOfBoundsException exp) {
				
				System.out.print("Please enter the dimensions greater than zero");
			} catch(Exception exp) {
			
				exp.printStackTrace();
			} finally {
			
				scannerObject.close();
			}
	//	}
	}
}