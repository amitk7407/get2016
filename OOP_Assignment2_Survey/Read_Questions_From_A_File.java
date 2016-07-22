package OOP_Assignment2_Survey;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Read_Questions_From_A_File implements Read_Questions_Interface {
 
	public List<String> read_Questions(int participantNo) throws IOException, FileNotFoundException {

		Question question = new Question();
		List<String> answers = new ArrayList<String>();
		
		Store_Answers_In_A_File storeAnswers = new Store_Answers_In_A_File();
		
		int incrementor = 0;
		Iterator<String> iterator=question.ques.iterator();  
		System.out.println("Enter the following data for participant "+participantNo);
			
		while(iterator.hasNext()){  
			
			System.out.println(iterator.next());  
			String[] questionParts=question.ques.get(incrementor).split(",");
			for(int index=0 ; index<questionParts.length ; index++) {
				questionParts[index] = questionParts[index].trim();
			}
				
			if(questionParts[1].equals("Single Select")) {
				
				Single_Select_Answers singleSelect = new Single_Select_Answers();
				answers.add(singleSelect.single_Select(questionParts[2]));
				
			} else if(questionParts[1].equals("Multi Select")) {
				
				Multi_Select_Answers multiSelect = new Multi_Select_Answers();
				answers.add(multiSelect.multi_Select(questionParts[2]));					
			} else if(questionParts[1].equals("Text")) {
					
				Text_Answer textSelect = new Text_Answer();
				answers.add(textSelect.text_Select());					
			}
			incrementor++;
		}
			
		storeAnswers.store_Answers(participantNo, answers, question.ques);
		return question.ques;
	}	
}