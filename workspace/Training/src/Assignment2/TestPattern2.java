package Assignment2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPattern2 {
	Pattern2 pattern = new Pattern2();
	int total_rows = 7;
	int row = 4;
	
	String[] expectedPattern = {"1234567", " 123456", "  12345", "   1234", "    123", "     12", "      1"};
	String expectedSpace = "   ";
	String expectedNumber = "1234";

	@Test
	public void testPatternPrint() {
		assertArrayEquals(expectedPattern, pattern.patternPrint(total_rows));	
	}
	
		@Test
	public void testSpacePrint() {
		assertEquals(expectedSpace, pattern.spacePrint(row-1));	
	}
	
	@Test
	public void testNumberPrint() {
		assertEquals(expectedNumber, pattern.numberPrint(row-1, total_rows));	
	}
}