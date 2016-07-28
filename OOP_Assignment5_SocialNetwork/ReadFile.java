package OOP_Assignment5_SocialNetwork;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * class to read file
 */
public class ReadFile {

	private static final String FILE_PATH = "src//OOP_Assignment5_SocialNetwork//data1.txt";
	Node node;
	
	/**
	 * method to read nodes
	 * @param graph : graph object
	 * @return graph : updated after reading
	 */
	public Graph readFile(Graph graph) {
		
		try {
			FileReader file = new FileReader(FILE_PATH);
			BufferedReader buffer = new BufferedReader(file);
			String currentLine = "";
			String[] temp;
			
			while((currentLine = buffer.readLine()) != null) {
				
				temp = currentLine.split("[/$]");
				if(temp[0] .equalsIgnoreCase("individual")) {
					
					node = new User(temp[0], temp[1], temp[2], temp[3]);
				} else {

					node = new Organization(temp[0], temp[1], temp[2], temp[3]);
				}
				graph.addNode(node);
				
			}
			buffer.close();
			file.close();
		} catch(Exception exp) {
			
			System.out.println(exp.getMessage());
		}
		return graph;
	}
	
	/**
	 * method to read friend list
	 * @param graph : graph object
	 * @return graph : updated after reading
	 */
	public Graph readFriendList(Graph graph) {
		
		try {
			FileReader file = new FileReader(FILE_PATH);
			BufferedReader buffer = new BufferedReader(file);
			String currentLine = "";
			String[] temp;
			String[] friendList;
			
			while((currentLine = buffer.readLine()) != null) {
				
				temp = currentLine.split("[/$]");
				friendList = temp[4].trim().split(",");
				
				Node mainNode = graph.getNode(temp[0]);
				
				for(int index=0 ; index<friendList.length ; index++) {
					
					Node friendNode = graph.getNode(friendList[index].trim());
					if(mainNode == null) {
						
						System.out.println(mainNode+" is not in the graph.");
					}else if(friendNode == null) {
						
						System.out.println(friendNode+" is not in the graph.");
					}
					if(!(mainNode.connectedNode().contains(friendNode))) {
					
						mainNode.addFriend(friendNode);
					}
					if(!(friendNode.connectedNode().contains(mainNode))) {
					
						friendNode.addFriend(mainNode);
					}
				}
			}
			buffer.close();
			file.close();
		} catch(Exception exp) {
			
			System.out.println(exp.getMessage());
		}
		return graph;
	}
}