package OOP_Assignment2_Survey;

import java.util.Scanner;

public class Multi_Select_Answers {

	@SuppressWarnings("resource")
	public String multi_Select(String optionsList) {
		
		String[] options = optionsList.substring(1, optionsList.length()-1).split("/ ");
		for(int index=0 ; index<options.length ; index++) {
			options[index] = options[index].trim();
		}
		Scanner scannerObject = new Scanner(System.in);
		String answer = scannerObject.nextLine();;
		String[] answers = answer.split("/");
		for(int index=0 ; index<answers.length ; index++) {
			options[index] = options[index].trim();
		}
		for(int index=0 ; index<answers.length ; index++) {
			
			Boolean flag = false;	
			for(int index2=0 ; index2<options.length ; index2++) {
				
				if(answers[index].equalsIgnoreCase(options[index2])) {
					
					flag = true;
					break;
				}
			}
			if(flag == false) {
				
				System.out.print("Please enter from the given options:"+optionsList);
				answer = multi_Select(optionsList);
			}
		}
		//scannerObject.close();
		return answer;
	}
}