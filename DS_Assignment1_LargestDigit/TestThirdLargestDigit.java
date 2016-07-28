package DS_Assignment1_LargestDigit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestThirdLargestDigit {

	ThirdLargestDigit thirdLargestDigit;
		
	int[] array1,array2,array3;

	@Before
	public void setUp() throws Exception {
			
		thirdLargestDigit = new ThirdLargestDigit();
		array1 = new int[]{2, 5, 4, 3, 8, 15, 16, 78};
		array2 = new int[]{6, 4, 8, 15, 84, 32, 15};			
		array3 = new int[]{2, 5, 41, 8, 9, 62, 0};
	}

	@Test
	public void testThirdLargestDigit() {
			
		assertEquals(15, thirdLargestDigit.thirdLargestDigit(array1));
		assertEquals(15, thirdLargestDigit.thirdLargestDigit(array2));
		assertEquals(9, thirdLargestDigit.thirdLargestDigit(array3));
	}
}