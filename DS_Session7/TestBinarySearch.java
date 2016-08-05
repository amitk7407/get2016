package DS_Session7;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestBinarySearch {

	BinarySearch<Integer> binary = new BinarySearch<Integer>();
	Integer[] arraySearch = {1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 6, 7, 8, 9};
	Integer[] arrayEmpty = {};
	Integer[] arraySortCheck = {1, 21, 3, 4, 8, 7, 9, 6, 1, 2};
	Integer target1 = 3;
	Integer target2 = 0;
	
	@Test
	public void testBinarySearchPositive() {
		
		assertEquals(3, binary.binarySearch(arraySearch, 0, arraySearch.length, target1));
	}

	@Test
	public void testBinarySearchNegative() {
		
		assertEquals(-1, binary.binarySearch(arraySearch, 0, arraySearch.length, target2));
	}
	
	@Test
	public void testBinarySearchEmpty() {
		
		assertEquals(-2, binary.binarySearch(arrayEmpty, 0, arrayEmpty.length, target1));
	}
	
	@Test
	public void testBinarySearchUnsorted() {
		
		assertEquals(-3, binary.binarySearch(arraySortCheck, 0, arraySortCheck.length, target1));
	}
}
