package DS_Assignment1_BinarySearch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBinary {
	
	BinarySearch binarySearch;
	int[] array = {1, 2, 6, 8, 10};
	
	@Before
	public void setUp() throws Exception {
		
		binarySearch = new BinarySearch();
	}

	@Test
	public void testSearchElement() {
		
		assertEquals(3,binarySearch.searchElement(array, 0, 4, 8));
		assertEquals(-1,binarySearch.searchElement(array, 0, 4, 15));
	}
}