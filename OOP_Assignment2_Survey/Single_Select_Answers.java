package OOP_Assignment2_Survey;

import java.util.Scanner;

public class Single_Select_Answers {

	@SuppressWarnings("resource")
	public String single_Select(String optionsList) {
		
		String[] options = optionsList.substring(1, optionsList.length()-1).split("/");
		Scanner scannerObject = new Scanner(System.in);
		String answer = scannerObject.next();
		
		Boolean flag = false;
		for(int index=0 ; index<options.length ; index++) {
		
			if(answer.equals(options[index])) {
				
				flag = true;
				break;
			}
		}
		if(flag == false) {
			
			System.out.print("Please enter from the given options:"+optionsList);
			answer = single_Select(optionsList);
		}
		//scannerObject.close();
		return answer;
	}
}