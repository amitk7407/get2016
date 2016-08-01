package DS_Assignment2_Stack;

/**
 * class to check the stack operations
 */
public class CheckStack {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(8);
		stack.push(5);
		stack.push(8);
		stack.push(5);
		stack.push(8);
		
		for(int index=0 ; index<stack.size() ; index++) {
			
			System.out.println("Value at index "+index+" is "+stack.get(index));
		}
		System.out.println();
		System.out.println("Value popped out : "+stack.pop());
		System.out.println("Value at top of stack : "+stack.peep());
		System.out.println("Value popped out : "+stack.pop());
		System.out.println("Value at top of stack : "+stack.peep());
		System.out.println("Value popped out : "+stack.pop());
		System.out.println();
		
		for(int index=0 ; index<stack.size() ; index++) {
	
			System.out.println("Value at index "+index+" is "+stack.get(index));
		}
		System.out.println(stack.isEmpty());
	}
}