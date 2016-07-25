package OOP_Assignment3_TicTacToe;

public class CheckForResult {

	private int rows;
	private int columns;
	private char currentPlayer;
	private char[][] board;
	
	public CheckForResult(int rows,  int columns, char currentPlayer, char[][]board) {
		
		this.rows = rows;
		this.columns = columns;
		this.currentPlayer = currentPlayer;
		this.board = board;
	}
	//checks for horizontal win
	public Boolean checkForHorizontalWin() {
		
		for(int rowIndex=0 ; rowIndex<rows ; rowIndex++) {
			
			int count = 0;
			for(int columnIndex=0 ; columnIndex<columns ; columnIndex++) {
			
				if((board[rowIndex][columnIndex] == currentPlayer)) {
					count++;
				}
			}
			if(count == rows) {	
				return true;
			}
		}
		return false;
	}
		
	//checks for vertical win
	public Boolean checkForVerticalWin() {

		for(int rowIndex=0 ; rowIndex<rows ; rowIndex++) {
		
			int count = 0;
			for(int columnIndex=0 ; columnIndex<columns ; columnIndex++) {
				
				if((board[columnIndex][rowIndex] == currentPlayer)) {
					count++;
				}
			}
			if(count == rows) {
				return true;
			}
		}
		return false;
	}
	
	//checks for diagonal win
	public Boolean checkForDiagonal1Win() {
			
		int count1 = 0;
		for(int index=0 ; index<rows ; index++) {
				
			if(board[index][index] == currentPlayer) {
				count1++;
			}
		}
		if(count1 == rows) {
			return true;
		}
		return false;
	}
		
	//checks for diagonal win
	public Boolean checkForDiagonal2Win() {
			
		int count2 = 0;
		for(int index=0 ; index<rows ; index++) {

			if(board[index][rows-index-1] == currentPlayer) {
				count2++;
			}
		}
		if(count2 == rows) {
			return true;
		}
		return false;
	}
	
	//this method checks for all types of win
	public Boolean CheckForWin() {
		
		if(checkForHorizontalWin() || checkForVerticalWin()	|| checkForDiagonal1Win() || checkForDiagonal2Win()) {
			return true;
		}
		return false;
	}
	
	//checks if the match is drawn or not
	public Boolean checkForDraw() {
		
		for(int rowIndex=0 ; rowIndex<rows ; rowIndex++) {
			for (int colIndex = 0; colIndex < columns; colIndex++) {
				
				if(board[rowIndex][colIndex] == ' ') {	
					return false;
				}
			}
		}
		return true;
	}
}