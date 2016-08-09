package DS_Session8_AllSorts;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * class to test all the sorts
 */
public class TestAllSorts {
	
	QuickSort quick = new QuickSort();
	BubbleSort bubble = new BubbleSort();
	CountSort count = new CountSort();
	RadixSort radix = new RadixSort();
		
	int[] arr1 = {6, 2, 5, 8, 9, 10, 77, 55, 11};
	int[] result1 = {2, 5, 6, 8, 9, 10, 11, 55, 77};
		
	/**
	 * unit test case to test the quick sort
	 */
	@Test
	public void testQuickSort() {
		assertArrayEquals(result1, quick.quickSort(arr1, 0, arr1.length-1));
	}

	/**
	 * unit test case to test the bubble sort
	 */
	@Test
	public void testBubbleSort() {
		assertArrayEquals(result1, bubble.bubbleSort(arr1));
	}
		
	/**
	 * unit test case to test the count sort
	 */
	@Test
	public void testCountSort() {
		assertArrayEquals(result1, count.countSort(arr1));
	}
		
	/**
	 * unit test case to test the radix sort
	 */
	@Test
	public void testRadixSort() {
		assertArrayEquals(result1, radix.radixSort(arr1));
	}
}