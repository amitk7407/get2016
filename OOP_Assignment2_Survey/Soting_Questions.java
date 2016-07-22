package OOP_Assignment2_Survey;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class Soting_Questions implements Comparable<Question>{  
	
	@Override
	public int compareTo(Question question){  
		  
		
		String[] options = new String[question.ques.size()];
		int index = 0;
		Iterator<String> iterator = question.ques.iterator();  
		while(iterator.hasNext()){  
		
			options[index] = iterator.next();
			options[index] = options[index].substring(4, options[index].length()-1);
			index++;
		}

		Arrays.sort(options);
		for(int index2=0 ; index2<options.length ; index2++) {
			System.out.println(options[index2]);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
		try {
			Question question = new Question();
			Soting_Questions sort = new Soting_Questions();
			sort.compareTo(question);
		} catch(FileNotFoundException exp) {
		
			System.out.print("Please enter the correct address of the file as it is not found");
		} catch(IOException exp) {
			
			System.out.print("Something went wrong:-"+exp.getMessage());
		} catch(Exception exp) {
			
			System.out.print("Something went wrong:-"+exp.getMessage());
		}
	}
}