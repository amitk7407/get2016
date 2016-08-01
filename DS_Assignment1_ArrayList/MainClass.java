package DS_Assignment1_ArrayList;

import java.util.NoSuchElementException;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			MyArrayList<String> arrayList = new MyArrayList<String>();
			MyArrayList<String> arrayList1 = new MyArrayList<String>();
		
			arrayList.add("Amit1");
			arrayList.add("Amit2");
			arrayList.add("Amit3");
			arrayList.add("Amit4");
		
			for(int index=0 ; index<arrayList.size() ; index++) {
				System.out.println(arrayList.getObject(index));
			}
		
			System.out.println();
			arrayList.add("Amit5",2);
		
			for(int index=0 ; index<arrayList.size() ; index++) {
				System.out.println(arrayList.getObject(index));
			}
		
			System.out.println();
			System.out.println(arrayList.getObject(0));
			System.out.println(arrayList.getIndex("Amit1"));
		
			arrayList.remove(0);
			arrayList.remove("Amit2");
			System.out.println();
			
			for(int index=0 ; index<arrayList.size() ; index++) {
				System.out.println(arrayList.getObject(index));
			}	
		
			System.out.println();
			System.out.println(arrayList.size());
			System.out.println();
			arrayList.reverse();
			System.out.println();
			
			for(int index=0 ; index<arrayList.size() ; index++) {
				System.out.println(arrayList.getObject(index));
			}	
		
			System.out.println();
			arrayList.removeAll();

			arrayList.add("Amit5",0);
			arrayList.add("Amit4",0);
			
			for(int index=0 ; index<arrayList.size() ; index++) {
				System.out.println(arrayList.getObject(index));
			}	
		
			arrayList1.add("Amit2");
			arrayList1.add("Amit4");
			arrayList1.add("Amit3");
			arrayList1.add("Amit5");
			arrayList1.add("Amit9");
			
			System.out.println();
			for(int index=0 ; index<arrayList1.size() ; index++) {
				System.out.println(arrayList1.getObject(index));
			}
			
			arrayList = new MergeList().mergeList(arrayList, arrayList1);
			System.out.println();
			
			for(int index=0 ; index<arrayList.size() ; index++) {
				System.out.println(arrayList.getObject(index));
			}
			
		} catch(ArrayIndexOutOfBoundsException exp) {
			
			System.out.println("There is no node at such index");
			exp.printStackTrace();
		} catch(NoSuchElementException exp) {
			
			System.out.println("The value is not present in the list");
			exp.printStackTrace();
		} catch(NullPointerException exp) {
			
			System.out.println("The list is empty");
			exp.printStackTrace();
		} catch(Exception exp) {
			
			exp.printStackTrace();
		}
	}
}