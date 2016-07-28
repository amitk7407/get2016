package DS_Assignment1_SinglyLinkedList;

import java.util.NoSuchElementException;

public class MainClass {

	public static void main(String[] args) {
		
		try {
		
			MySinglyLinkedList<String> list = new MySinglyLinkedList<String>();
			list.addNode("Amit1");
			list.addNode("Amit2");
			list.addNode("Amit3");
			list.addNode("Amit4");
			list.addNode("Amit5");
			
			list.print();
			System.out.println();
			list.addNode(0, "Amit6");
			list.print();
			
			list.removeNode(0);
			System.out.println();
			list.print();
			
			list.removeNode("Amit1");
			System.out.println();
			list.print();
			
			System.out.println();
			String value = list.get(0);
			System.out.println(value);
			System.out.println();
			list.print();
			
			System.out.println();
			list.reverse();	
			list.print();
			
		} catch(ArrayIndexOutOfBoundsException exp) {
			
			System.out.println("There is no node at such index");
			exp.printStackTrace();
		} catch(NoSuchElementException exp) {
			
			System.out.println("The value is not present in the list");
			exp.printStackTrace();
		} catch(Exception exp) {
			
			exp.printStackTrace();
		}
	}
}