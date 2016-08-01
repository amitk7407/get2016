package DS_Assignment2_Stack;

/**
 * class to find the postfix of a given operation
 */
public class InfixToPostfix {

	/**
	 * method to create the postfix expression
	 * @param expression : infix expression
	 * @return : postfix expression
	 */
	public String postfix(String expression) {
		
		String postfix = "";
		Stack<Character> stack = new Stack<Character>();
		Operators_Priority op = new Operators_Priority();
		int count = 0;
		
		for(int index = 0 ; index<expression.length() ; index++) {		//for each character in the string
			
			if((expression.charAt(index)>64 && expression.charAt(index)<91) || (expression.charAt(index)>96 && expression.charAt(index)<123)) {
																				//for alphabets
				postfix += expression.charAt(index);
			} else if(expression.charAt(index) == '(') {						//for left parenthesis
				
				stack.push('(');
				count++;
			} else if(expression.charAt(index) == ')') {						//for right parenthesis
				
				if(count != 0) {
				
					while(stack.peep() != '(') {
						
						postfix += stack.pop();
					}
					stack.pop();
				} else {
					
					throw new ArrayIndexOutOfBoundsException();
				}
			} else if(expression.charAt(index) == '+' || expression.charAt(index) == '-' || expression.charAt(index) == '*' || expression.charAt(index) == '/' || expression.charAt(index) == '%') {
																				//for operators
					while(!stack.isEmpty() && !(expression.charAt(index) == '(') && (op.charPriority(stack.peep()) >= op.charPriority(expression.charAt(index)))) {
						
						postfix += stack.pop();
					}
				stack.push(expression.charAt(index));
			} else {
				
				throw new IllegalArgumentException();
			}
		}																		//till the stack has the elements
		while(!stack.isEmpty()) {										
			
			postfix += stack.pop();
		}
		return postfix;
	}
}