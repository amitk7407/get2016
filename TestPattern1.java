package Assignment2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestPattern1 {
	Pattern1 pattern = new Pattern1();
	int row = 7;
	String[] expectedPattern = {"   1", "  121", " 12321", "1234321", " 12321", "  121", "   1"};

	@Test
	public void testPatternPrint() {
		assertArrayEquals(expectedPattern, pattern.patternPrint(row));	
	}
}