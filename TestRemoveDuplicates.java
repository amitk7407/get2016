import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


public class TestRemoveDuplicates {

	Duplicate duplicate = new Duplicate();
	int[] input = {2, 5, 4, 6, 3, 8, 5, 9, 3, 3, 6, 3, 9, 0};
	int[] output = {2, 5, 4, 6, 3, 8, 9, 0};
	
	@Test
	public void testRemoveDuplicates() {
		assertArrayEquals("All Duplicate elements has been removed !", output, duplicate.removeDuplicate(input));
	}

}
