package Assignment3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGreatestCommonDivisor {

	GreatestCommonDivisor gcd = new GreatestCommonDivisor();
	int num1 = 2;
	int den1 = 1;
	int gcd1 = 1;
	
	int num2 = 2;
	int den2 = 0;
	int gcd2 = -1;
	
	int num3 = 100;
	int den3 = 3;
	int gcd3 = 1;
	
	@Test
	public void testGCD1() {
		assertEquals(gcd1, gcd.GCD(num1, den1));
	}
	@Test
	public void testGCD2() {
		assertEquals(gcd2, gcd.GCD(num2, den2));
	}
	@Test
	public void testGCD3() {
		assertEquals(gcd3, gcd.GCD(num3, den3));
	}
}