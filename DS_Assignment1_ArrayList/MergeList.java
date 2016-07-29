package DS_Assignment1_ArrayList;

public class MergeList {

	public static <T> MyArrayList<T> mergeList(MyArrayList<T> list1, MyArrayList<T> list2) {
		
		if(list1.size() == 0 || list2.size() == 0) {
			throw new NullPointerException();
		}
		for(int index=0 ; index<list2.size() ; index++) {
			
			list1.add(list2.getObject(index));
		}
		return list1;
	}
}