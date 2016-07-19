package Assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinearSearch {

	LinearSearch linear = new LinearSearch();
	int[] arr1 = {2, 5, 8, 9, 10, 77, 55};
	int target1 = 88;
	int position1 = -1;
	
	int[] arr2 = {2, 5, 8, 9, 10, 77, 55, 11};
	int target2 = 77;
	int position2 = 6;
	
	@Test
	public void testLinearSearch1() {
		assertEquals(position1, linear.linearSearch(arr1, 0, target1));
	}
	@Test
	public void testLinearSearch2() {
		assertEquals(position2, linear.linearSearch(arr2, 0, target2));
	}
}