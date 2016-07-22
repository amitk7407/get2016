package OOP_Assignment2_Survey;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Print_Singleselect_Answers {

	void percentageDistribution(String question, String optionsList) throws FileNotFoundException, IOException{
		
		FileReader file = null;
		BufferedReader buffer = null;
		
		file = new FileReader("Answers.txt");  
		buffer = new BufferedReader(file);
		String[] options = optionsList.substring(1, optionsList.length()-1).split("/");
			
		String currentLine = "";
		double incrementor = 0.0;
		String questionFromFile = null;

		int count[] = new int[options.length];
	
		while((currentLine=buffer.readLine()) != null) {  
				
			if(currentLine.length() >= question.length()) {
				questionFromFile = currentLine.substring(0, question.length());
				if(questionFromFile.equals(question)) {
					
					for(int index=0 ; index<options.length ; index++) {
						String option = currentLine.substring(question.length()+6, currentLine.length());
						if(options[index].equals(option)) {
						
							count[index]++;
							incrementor++;
						}
					}
				}
			}
		}	
			
		System.out.println("REPORT A:");
		System.out.println("The percentage distribution of single select questions of the survey is:");
		System.out.println(question.substring(4, question.length()));
		for(int index=0 ; index<count.length ; index++) {
				
			System.out.println("\t"+options[index]+" - "+(count[index]/incrementor)*100+"%");
		}
		file.close();
		buffer.close();
	}	
}