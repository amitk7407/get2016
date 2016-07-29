package DS_Assignment1_ArrayList;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArrayList {
	
	MyArrayList<String> arrayList;
	MyArrayList<String> arrayList2;
	MyArrayList<String> resultantArrayList;
	MergeList merge;
	
	@Before
	public void setUp() throws Exception {
		
		arrayList = new MyArrayList<String>();
		arrayList2 = new MyArrayList<String>();
		merge = new MergeList();
	}

	@Test
	public void testAddT() {
		
		assertEquals("Success",true,arrayList.add("1"));
		assertEquals("Success",true,arrayList.add("2"));
		assertEquals("Success",true,arrayList.add("3"));
		assertEquals("Success",true,arrayList.add("4"));
		assertEquals("Success",true,arrayList.add("5"));
		assertEquals("Success",true,arrayList.add("6"));
		assertEquals("Success",true,arrayList2.add("8"));
		assertEquals("Success",true,arrayList2.add("3"));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testAddAt() {
		
		assertEquals("Success",true,arrayList.add("7", 1));
		assertEquals("Success",true,arrayList.add("8", 2));
		assertEquals("Success",true,arrayList.add("9", 7));
		assertEquals("Success",true,arrayList.add("10", 4));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testRemoveIndex() {
		
		assertEquals("Success",true,arrayList.remove(1));
		assertEquals("Success",true,arrayList.remove(2));
		assertEquals("Success",true,arrayList.remove(3));
		assertEquals("Success",true,arrayList.remove(4));
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveT() {
		
		try {
			assertEquals("Success",true,arrayList.remove("0"));
			assertEquals("Success",true,arrayList.remove("7"));
			assertEquals("Success",true,arrayList.remove("5"));
			assertEquals("Success",true,arrayList.remove("3"));
		} catch(ArrayIndexOutOfBoundsException exp) {
			
			Assert.fail("Test Failed "+exp.getMessage());
		}
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetIndex() {
		
		assertEquals("Success",0,arrayList.getIndex("5"));
		assertEquals("Success",1,arrayList.getIndex("6"));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetObject() {
		
		assertEquals("5",arrayList.getObject(0));
		assertEquals("6",arrayList.getObject(1));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testReverse(){
		
		arrayList.reverse();
		assertEquals("10", arrayList.getObject(0));
		assertEquals("9", arrayList.getObject(1));
		assertEquals("8", arrayList.getObject(2));
		assertEquals("7", arrayList.getObject(3));
		assertEquals("6", arrayList.getObject(4));
		assertEquals("5", arrayList.getObject(5));
	}

	@Test
	public void testRemoveAll() {
		
		assertEquals("Success" , true, arrayList.removeAll());
	}
	
	@Test(expected = NullPointerException.class)
	public void testMergeList() {
		
		resultantArrayList.add("6");
		resultantArrayList.add("8");
		resultantArrayList.add("3");
		resultantArrayList.add("8");
		assertEquals(resultantArrayList, merge.mergeList(arrayList, arrayList2));
	}
}