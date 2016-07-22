package OOP_Assignment2_Survey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question {

	List<String> ques;
	Question() throws NumberFormatException, IOException {
		
		FileReader file = null;
		BufferedReader buffer = null;
		
		file = new FileReader("src\\OOP_Assignment2_Survey\\Questions.txt");  
		buffer = new BufferedReader(file); 
		
		ques = new ArrayList<String>(); 
		String currentLine = "";
		while((currentLine=buffer.readLine()) != null) {  
			
			ques.add(currentLine); 
		}
		file.close();
		buffer.close();
	}
}