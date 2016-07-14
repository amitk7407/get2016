import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


public class TestSortedArrayJoin {

	SortedArrayJoin arrayJoin = new SortedArrayJoin();
	int[] input1 = {0, 2, 3, 5, 7, 8, 9, 11, 13, 15};
	int[] input2 = {1, 3, 4, 6, 9, 10, 12, 14, 16, 17};
	int[] result = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 9, 10, 11, 12, 13, 14, 15, 16, 17};
	int[] arr = new int[input1.length + input2.length];
	
	@Test
	public void testLongestArraySequence() {
		assertArrayEquals(result, arrayJoin.join(input1, input1.length, input2, input2.length, arr));
	}
}
