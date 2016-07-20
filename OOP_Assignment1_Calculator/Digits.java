package OOP_Assignment1_Calculator;

import javax.swing.JButton;

public class Digits extends JButton{
	
	double digit;
	public Digits() {
		//Default Constructor
	}

	public Digits(double digit) {
		this.digit = digit;
	}
	
	public void setDigits(double digit) {
		this.digit = digit;
	}
	
	public double getDigits() {
		//returns the digits associated with the object which are fed by the user
		return digit;
	}
}