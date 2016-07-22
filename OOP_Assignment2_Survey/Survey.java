package OOP_Assignment2_Survey;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Survey {

	void survey() throws IOException, FileNotFoundException {
	
		System.out.println("Hello, we are going to conduct a survey. Please support us.");
		System.out.print("Please enter the number of participants who gonna take part in the survey");
		Scanner scannerObject = new Scanner(System.in);
		int noOfParticipant = scannerObject.nextInt();
		if(noOfParticipant <= 0)
		{
			System.out.println("Please enter the number greater than 0.");
			survey();
		} else {
			FileWriter fileWriter = new FileWriter("Answers.txt");
		
			List<String> questionslist = new ArrayList<String>();
		
			for(int index=0 ; index<noOfParticipant ; index++) {
			
				Read_Questions_From_A_File read = new Read_Questions_From_A_File();
				int participantNo = index+1;
				questionslist = read.read_Questions(participantNo);
			}
			System.out.println("The Survey is completed.");
			print_Distribution(questionslist);
			scannerObject.close();
			fileWriter.close();
		}
	}
	
	void print_Distribution(List<String> questionList) throws IOException, FileNotFoundException {
		Iterator<String> iterator1 = questionList.iterator();
		int incrementor = 0;
		while(iterator1.hasNext()) {
		
			String[] questionParts=iterator1.next().split(",");
			for(int index=0 ; index<questionParts.length ; index++) {
				questionParts[index] = questionParts[index].trim();
			} 
			if(questionParts[1].equals("Single Select")) {

				Print_Singleselect_Answers print = new Print_Singleselect_Answers();
				print.percentageDistribution(questionList.get(incrementor), questionParts[2]);
			}
			incrementor++;
		}
	}

	public static void main(String[] args) {

		try {
			Survey surv = new Survey();
			surv.survey();
		} catch(FileNotFoundException exp) {
		
			System.out.print("Please enter the correct address of the file as it is not found");
		} catch(IOException exp) {
			
			System.out.print("Something went wrong:-"+exp.getMessage());
		} catch(Exception exp) {
			
			System.out.print("Something went wrong:-"+exp.getMessage());
		}
	}
}
