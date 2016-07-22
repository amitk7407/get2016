package OOP_Assignment1_Matrix;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestMatrixImplementation {

	MatrixImplementation matrix = new MatrixImplementation();
	//Scanner scannerObject = new Scanner(System.in);
	
	int[][] expectedTransposeMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	int[][] actualTransposeMatrix = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
	
	int[][] expectedSumMatrix = {{3, 5, 11}, {7, 8, 9}, {7, 14, 12}};
	int[][] sumMatrix1 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
	int[][] sumMatrix2 = {{2, 1, 4}, {5, 3, 1}, {4, 8, 3}};
	
	int[][] expectedMultiplyMatrix = {{22, 46}, {28, 22}, {46, 60}};
	int[][] multiplyMatrix1 = {{6, 4, 2}, {2, 0, 8}, {8, 3, 9}};
	int[][] multiplyMatrix2 = {{2, 3}, {1, 6}, {3, 2}};
	
	@Test
	public void testMatrixTranspose() {
		assertArrayEquals(expectedTransposeMatrix, matrix.matrixTranspose(actualTransposeMatrix));
	}
	
	@Test
	public void testAddMatrixElements() {
		assertArrayEquals(expectedSumMatrix, matrix.addMatrixElements(sumMatrix1, sumMatrix2));
	}
	
	@Test
	public void testMatrixMultiplication() {
		assertArrayEquals(expectedMultiplyMatrix, matrix.matrixMultiplication(multiplyMatrix1, multiplyMatrix2));
	}
}