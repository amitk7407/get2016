/**
 * 	Question 1:
 *		Write(No implementation required for methods) the classes for the Calculator example that was discussed in the class . Include all the classes which were discussed : 
 *			1. Calculator 
 *			2. Display
 *			3. Buttons
 *			4. Commands/Operations
 *			5. Layout 
 *		Add more classes if needed. Ensure you capture the hierarchy correctly along with method names and attributes . 
 *
 *
 *	Notes
 *		No SOP in any class other than Main class.
 *		No console reading other than Main class.
 *		Class/Method/Object/Variable names should be self-explanatory.
 *		Write short classes and methods
 *		Follow naming conventions
 *
 *  author Amit Kumar
 *  date 19-07-2016
 *  
 */

package OOP_Assignment1_Calculator;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

public class Calculator implements ActionListener{

	Digits[] digit;
	Operator[] operator;
	
	public Calculator(){
		//default constructor to provide default values to the objects
	}
		
	public Digits[] getDigits() {
		//sending the reference for 
		return digit;
	}
	
	public Operator[] getOperators() {
		//sending the reference for 
		return operator;
	}
	
	public void display(Digits[] digit, Operator[] operator) {
		//displays the whole equation along with the result
	}
	
	public void layout(JComponent[] components, LayoutManager layoutManager) {
		//creating a specific layout
	}
	
	public double performOperations(Digits[] digit, Operator[] operator) {
		//sending the reference for 
		return 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//used for the actions performed when the buttons are clicked
	}
}