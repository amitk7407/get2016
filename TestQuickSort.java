package Assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuickSort {

	QuickSort quick = new QuickSort();
	int[] arr1 = {6, 2, 5, 8, 9, 10, 77, 55, 11};
	int[] result1 = {2, 5, 6, 8, 9, 10, 11, 55, 77};
	
	int[] arr2 = {};
	int[] result2 = {-1};
	
	@Test
	public void testQuickSort1() {
		assertArrayEquals(result1, quick.quickSort(arr1, 0, arr1.length-1));
	}
	@Test
	public void testQuickSort2() {
		assertArrayEquals(result2, quick.quickSort(arr2, 0, arr2.length-1));
	}
}