package Assignment3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestLargestDigit {

	LargestDigit largest = new LargestDigit();
	int num1 = 2;
	int result1 = 2;
	
	int num2 = 1257369;
	int result2 = 9;
	
	int num3 = 444;
	int result3 = 4;
	
	@Test
	public void testLargest1() {
		assertEquals(result1, largest.largestDigit(num1));
	}
	@Test
	public void testLargest2() {
		assertEquals(result2, largest.largestDigit(num2));
	}
	@Test
	public void testLargest3() {
		assertEquals(result3, largest.largestDigit(num3));
	}
}