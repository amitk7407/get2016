package DS_Assignment1_DoublyLinkedList;


public class MainClass {

	public static void main(String[] args) {
		
		try {
		
			MyDoublyLinkedList<String> list = new MyDoublyLinkedList<String>();
			list.addNode("Amit7");
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
			
			list.removeNode("Amit5");
			System.out.println();
			list.print();
			
			System.out.println();
			String value = list.get(3);
			System.out.println(value);
			
			System.out.println();
			list.reverse();	
			list.print();
			
		} catch(ArrayIndexOutOfBoundsException exp) {
			
			System.out.println("There is no node at such index");
			exp.printStackTrace();
		} catch(NullPointerException exp) {
			
			System.out.println("The value is not present in the list");
			exp.printStackTrace();
		} catch(Exception exp) {
			
			exp.printStackTrace();
		}
	}
}