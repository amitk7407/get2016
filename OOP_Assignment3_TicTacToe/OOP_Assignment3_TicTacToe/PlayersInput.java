package OOP_Assignment3_TicTacToe;

import java.util.Random;

public class PlayersInput {

	//takes the position where the user want to enter his symbol
	public Boolean playerInput(int row, int col, int rows, int columns, char currentPlayer, char[][] board) {
			
		if((row>=0 && row<rows) && (col>=0 && col<columns) && (board[row][col] == ' ')) {
				
			board[row][col] = currentPlayer;
			return true;
		}
		return false;
	}
	
	//takes the position where the computer want to enter his symbol
	public Boolean computerInput(int rows, int columns, char currentPlayer, char[][] board) {
		
		Random random = new Random();
		int random1 = random.nextInt(3);
		System.out.println(random1+1);
		int random2 = random.nextInt(3);
		System.out.println(random1+1);
		if((random1>=0 && random1<rows) && (random2>=0 && random2<columns) && (board[random1][random2] == ' ')) {
				
			board[random1][random2] = currentPlayer;
			return true;
		}
		return false;
	}
	
	//this method changes the current user
	public char playerChange(char currentPlayer) {			
		
		if(currentPlayer == 'x') {
			currentPlayer = 'o';
		} else {			
			currentPlayer = 'x';
		}
		return currentPlayer;
	}
}