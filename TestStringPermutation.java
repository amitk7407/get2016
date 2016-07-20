package Assignment4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestStringPermutation {

	StringPermutation permutation = new StringPermutation();
	List<String> expected = new ArrayList<String>(Arrays.asList("ABCD",
			"ABDC", "ACBD", "ACDB", "BACD", "BADC", "BCAD", "BCDA", "BDCA",
			"BDAC", "CBDA", "CBAD", "CDBA", "CDAB", "CADB", "CABD", "DCAB",
			"DCBA", "DACB", "DABC", "DBAC", "DBCA", "ADBC", "ADCB"));
	List<String> output = new ArrayList<String>();
	
	@Test
	public void testPermutation() {
		assertEquals(expected, permutation.getPermutations("ABCD", output));
	}
}
