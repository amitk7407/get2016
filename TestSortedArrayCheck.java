import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestSortedArrayCheck {

	SortedArrayCheck arrayCheck = new SortedArrayCheck();
	int[] input1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	int result1 = 1;
	
	int[] input2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	int result2 = 2;
	
	int[] input3 = {1, 2, 3, 8, 7, 4, 6, 5, 8, 0};
	int result3 = 0;
	
	@Test
	public void testLongestArraySequence() {
		assertEquals(result1, arrayCheck.checkSortedArray(input1));
		assertEquals(result2, arrayCheck.checkSortedArray(input2));
		assertEquals(result3, arrayCheck.checkSortedArray(input3));		
	}
}
