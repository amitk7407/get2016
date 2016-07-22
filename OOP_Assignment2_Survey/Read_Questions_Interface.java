package OOP_Assignment2_Survey;

import java.io.IOException;
import java.util.List;

public interface Read_Questions_Interface {

	public List<String> read_Questions(int participantNo) throws IOException;
}