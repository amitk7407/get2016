package OOP_Assignment2_Survey;

import java.util.Scanner;

public class Text_Answer {

	@SuppressWarnings("resource")
	public String text_Select() {
		
		Scanner scannerObject = new Scanner(System.in);
		String answer = scannerObject.nextLine();;
		//scannerObject.close();
		return answer;
	}
}
