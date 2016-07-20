package Assignment4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestStringPermutation {

	PermutationString permutation = new PermutationString();
	String input1 = "ABCD";
	List<String> expected1 = new ArrayList<String>(Arrays.asList("ABCD",
			"ABDC", "ADBC", "ADCB", "ACDB", "ACBD", "CABD", "CADB", "CDAB",
			"CDBA", "CBDA", "CBAD", "BCAD", "BCDA", "BDCA", "BDAC", "BADC",
			"BACD", "DBAC", "DBCA", "DCBA", "DCAB", "DACB", "DABC"));
	List<String> output1 = new ArrayList<String>();
	
	String input2 = "ABC";
	List<String> expected2 = new ArrayList<String>(Arrays.asList("ABC",
			"ACB", "CAB", "CBA", "BCA", "BAC"));
	List<String> output2 = new ArrayList<String>();
	
	@Test
	public void testPermute1() {
		assertEquals(expected1, permutation.permute(input1, output1));
	}
	
	@Test
	public void testPermute2() {
		assertEquals(expected2, permutation.permute(input2, output2));
	}
}
