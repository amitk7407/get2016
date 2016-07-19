package Assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRemainder {

	Remainder remainder = new Remainder();
	int num1 = 2;
	int den1 = 1;
	int rem1 = 0;
	
	int num2 = 2;
	int den2 = 0;
	int rem2 = -1;
	
	int num3 = 100;
	int den3 = 3;
	int rem3 = 1;
	
	@Test
	public void testRemainder1() {
		assertEquals(rem1, remainder.rem(num1, den1));
	}
	@Test
	public void testRemainder2() {
		assertEquals(rem2, remainder.rem(num2, den2));
	}
	@Test
	public void testRemainder3() {
		assertEquals(rem3, remainder.rem(num3, den3));
	}
}