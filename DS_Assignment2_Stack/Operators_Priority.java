package DS_Assignment2_Stack;

/**
 * class to assign proper priorities to the operators
 */
public class Operators_Priority {

	public static final int IS_ADDITION = 1;
	public static final int IS_SUBTRACTION = 1;
	public static final int IS_MULTIPLICATION = 2;
	public static final int IS_DIVISION = 2;
	public static final int IS_MODULO = 2;
	public static final int IS_LEFT_PARENTHESIS = 0;
	
	/**
	 * method to return the priorities
	 * @param ch : operator whose priority is to be get
	 * @return : priority of the operators
	 */
	public int charPriority(char ch) {
		
		if(ch == '+') {
			
			return IS_ADDITION;
		} else if(ch == '-') {
			
			return IS_SUBTRACTION;
		} else if(ch == '*') {
			
			return IS_MULTIPLICATION;
		} else if(ch == '/') {
			
			return IS_DIVISION;
		} else if(ch == '%') {
			
			return IS_MODULO;
		} else if(ch == '(') {
			
			return IS_LEFT_PARENTHESIS;
		} else {
			
			return 0;
		}
	}
}
