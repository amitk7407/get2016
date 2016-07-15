package Assignment2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestPattern2 {
	Pattern2 pattern = new Pattern2();
	int row = 7;
	String[] expectedPattern = {"1234567", " 123456", "  12345", "   1234", "    123", "     12", "      1"};

	@Test
	public void testPatternPrint() {
		assertArrayEquals(expectedPattern, pattern.patternPrint(row));	
	}
}