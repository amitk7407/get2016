package OOP_Assignment2_Survey;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Store_Answers_In_A_File {

	void store_Answers(int participantNo, List<String> answers, List<String> questions) throws IOException, FileNotFoundException {
		FileWriter file = null;
		try{  
			
			file = new FileWriter("Answers.txt", true);  
			String participant = "Participant "+participantNo+":";
			file.write(participant+ System.getProperty("line.separator"));
			for(int index=0 ; index<questions.size() ; index++) {
				
				String result = questions.get(index)+" ---> "+answers.get(index);
				file.write(result+ System.getProperty("line.separator"));
			}
		} catch(FileNotFoundException exp) {
		
			System.out.println("Please check the file address as the file is not found");
		} finally {
		
			file.close();  
		}
	}
}