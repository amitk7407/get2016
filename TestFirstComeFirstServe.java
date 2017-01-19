import org.junit.Test;

import static org.junit.Assert.*;


public class TestFirstComeFirstServe {

	FirstComeFirstServe fcfs = new FirstComeFirstServe();
	int[] arrival_time = {1, 5, 9, 25};
	int[] job_size = {12, 7, 2, 5};
	int[][] expected = {{1, 1, 0, 1, 12}, {2, 5, 8, 13, 19}, {3, 9, 11, 20, 21}, {4, 25, 0, 25, 29}};		
	
	public static boolean isArrayEqual(int[][] expected, int[][]output) {
		
		int flag = 0;
		for(int i=0 ; i<expected.length ; i++) {
			for(int j=0 ; j<expected.length ; j++) {
				if(expected[i][j] != output[i][j]) {
					flag = 1;
					break;
				}
			}
		}
		if(flag == 1) {
			return false;
		}
		return true;
	}
				
	@Test
	public void testLongestArraySequence() {

		assertTrue(isArrayEqual(expected, fcfs.FCFS(arrival_time, job_size)));
	}
}