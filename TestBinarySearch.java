package Assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBinarySearch {

	BinarySearch binary = new BinarySearch();
	int[] arr = {2, 5, 8, 9, 10, 55, 77};
	
	int target1 = 88;
	int position1 = -1;
	
	int target2 = 77;
	int position2 = 7;
	
	@Test
	public void testBinarySearch1() {
		assertEquals(position1, binary.binarySearch(arr, 0, arr.length-1, target1));
	}
	@Test
	public void testBinarySearch2() {
		assertEquals(position2, binary.binarySearch(arr, 0, arr.length-1, target2));
	}
}
