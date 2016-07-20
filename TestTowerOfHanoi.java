package Assignment4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestTowerOfHanoi {

	TowerOfHanoi tower = new TowerOfHanoi();

	List<String> expectedList1 = new ArrayList<String>(Arrays.asList(
			"Move Disk 1 from A to C", "Move Disk 2 from A to B", "Move Disk 1 from C to A",  
			"Move Disk 3 from A to C", "Move Disk 1 from B to C", "Move Disk 2 from B to A", 
			"Move Disk 1 from C to B"));
	
	List<String> expectedList2 = new ArrayList<String>(Arrays.asList(
			"Move Disk 1 from A to B", "Move Disk 2 from A to C", "Move Disk 1 from B to A"));
		
	List<String> actualList1 = new ArrayList<String>();
	List<String> actualList2 = new ArrayList<String>();

	@Test
	public void testTower1() {
			
		assertEquals(expectedList1, tower.towerOfHanoi("A", "C", "B", 3, actualList1));
	}
	@Test
	public void testTower2() {
			
		assertEquals(expectedList2, tower.towerOfHanoi("A", "C", "B", 2, actualList2));
	}
}