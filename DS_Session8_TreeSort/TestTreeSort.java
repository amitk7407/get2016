package DS_Session8_TreeSort;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * class to test the tree sort
 */
public class TestTreeSort {

	TreeSort<Integer> tree = new TreeSort<Integer>();
	List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 7, 3, 6, 9, 8, 4));
	List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	Node<Integer> node = null;
	
	/**
	 * method to initially create a tree
	 */
	@Before
	public void setUp() {
		
		node = tree.createTree(node, list);
	}
	
	/**
	 * method to test the sorting
	 */
	@Test
	public void test() {
	
		assertEquals(expectedList, tree.inOrder(node));
	}
}