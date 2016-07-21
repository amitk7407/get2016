package OOP_Assignment1_Calculator;

import javax.swing.JButton;

public class Operator extends JButton{

	String operator;
	public Operator() {
		//Default Constructor
	}
	
	public Operator(String operator) {
		this.operator = operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getOperator() {
		//returns the operator associated with the object based on which the operations method is called
		return operator;
	}

	public double addition(double value1, double value2) {
		//Perform the addition operation on the values passed as arguments
		return 0.0;
	}
	
	public double subtraction(double value1, double value2) {
		//Perform the subtraction operation on the values passed as arguments
		return 0.0;
	}
	
	public double division(double value1, double value2) {
		//Perform the division operation on the values passed as arguments
		return 0.0;
	}
	
	public double multiplication(double value1, double value2) {
		//Perform the multiplication operation on the values passed as arguments
		return 0.0;
	}
	
	public double equals(String equation) {
		//Perform the multiplication operation on the values passed as arguments
		return 0.0;
	}
}