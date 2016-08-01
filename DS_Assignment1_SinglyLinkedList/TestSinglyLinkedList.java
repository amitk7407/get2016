package DS_Assignment1_SinglyLinkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestSinglyLinkedList {
	
	MySinglyLinkedList<String> singlyLinkedList;

	@Before
	public void setUp() throws Exception {
		
		singlyLinkedList = new MySinglyLinkedList<String>();
	}

	@Test
	public void testAdd() {
		
		assertEquals("Success",true,singlyLinkedList.addNode(0, "1"));
		assertEquals("Success",true,singlyLinkedList.addNode(1, "2"));
		assertEquals("Success",true,singlyLinkedList.addNode(2, "3"));
		assertEquals("Success",true,singlyLinkedList.addNode("4"));
	}

	@Test(expected = NullPointerException.class)
	public void testRemoveE() {
		
		assertEquals("Success",true,singlyLinkedList.removeNode("5"));
		assertEquals("Success",true,singlyLinkedList.removeNode("4"));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testRemoveIndex() {
		
		assertEquals("Success","2",singlyLinkedList.removeNode(1));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGet() {
		
		assertEquals("Success",true,singlyLinkedList.addNode(0, "1"));
		assertEquals("Success",true,singlyLinkedList.addNode(1, "5"));
		assertEquals("Success",true,singlyLinkedList.addNode(2, "3"));
		
		assertEquals("2",singlyLinkedList.get(3));
		assertEquals("5",singlyLinkedList.get(1));
	}
}