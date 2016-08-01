package DS_Assignment2_Stack;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter an expression:");
		String expression = sc.next();
		InfixToPostfix postfix = new InfixToPostfix();
		String postfixExpression = postfix.postfix(expression);
		System.out.println("The postfix of the above given expression is : " +postfixExpression);
		sc.close();
	}
}
