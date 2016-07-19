package Assignment4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestQueensProblem {

	QueensProblem queen = new QueensProblem();
	int[] expected1 = {0, 1, 0, 0};
	int[] expected2 = {0, 0, 0, 1};
	int[] expected3 = {1, 0, 0, 0};
	int[] expected4 = {0, 0, 1, 0};
	
	int[][] actual = new int[4][4];

	@Before
	public void setUp() throws Exception {
		
		actual = queen.queensProblem(actual, 0, 0, 4, 4);
	}

	@Test
	public void testQueens1() {
		assertArrayEquals(expected1, actual[0]);
	}
	
	@Test
	public void testQueens2() {
		assertArrayEquals(expected2, actual[1]);
	}
	
	@Test
	public void testQueens3() {
		assertArrayEquals(expected3, actual[2]);
	}
	
	@Test
	public void testQueens4() {
		assertArrayEquals(expected4, actual[3]);
	}
}