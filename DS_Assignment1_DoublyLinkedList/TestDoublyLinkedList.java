package DS_Assignment1_DoublyLinkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestDoublyLinkedList {
	
	MyDoublyLinkedList<String> doublyLinkedList;

	@Before
	public void setUp() throws Exception {
		
		doublyLinkedList = new MyDoublyLinkedList<String>();
	}

	@Test
	public void testAdd() {
		
		assertEquals("Success",true,doublyLinkedList.addNode(0, "1"));
		assertEquals("Success",true,doublyLinkedList.addNode(1, "2"));
		assertEquals("Success",true,doublyLinkedList.addNode(2, "3"));
		assertEquals("Success",true,doublyLinkedList.addNode("4"));
	}

	@Test(expected = NullPointerException.class)
	public void testRemoveE() {
		
		assertEquals("Success",true,doublyLinkedList.removeNode("5"));
		assertEquals("Success",true,doublyLinkedList.removeNode("4"));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testRemoveIndex() {
		
		assertEquals("Success",true,doublyLinkedList.removeNode(1));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGet() {
		
		assertEquals("Success",true,doublyLinkedList.addNode(0, "1"));
		assertEquals("Success",true,doublyLinkedList.addNode(1, "5"));
		assertEquals("Success",true,doublyLinkedList.addNode(2, "3"));
		
		assertEquals("2",doublyLinkedList.get(3));
		assertEquals("5",doublyLinkedList.get(1));
	}
}