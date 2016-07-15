package Assignment2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPattern1 {
	Pattern1 pattern = new Pattern1();
	int total_rows = 7;
	int row = 4;
	
	String[] expectedPattern = {"   1", "  121", " 12321", "1234321", " 12321", "  121", "   1"};
	String expectedSpace = "";
	String expectedNumber = "1234321";

	@Test
	public void testPatternPrint() {
		assertArrayEquals(expectedPattern, pattern.patternPrint(total_rows));	
	}	

	@Test
	public void testSpacePrint() {
		assertEquals(expectedSpace, pattern.spacePrint(row-1, total_rows));	
	}
	
	@Test
	public void testNumberPrint() {
		assertEquals(expectedNumber, pattern.numberPrint(row-1, total_rows));	
	}
}