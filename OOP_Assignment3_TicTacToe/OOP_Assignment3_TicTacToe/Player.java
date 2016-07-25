package OOP_Assignment3_TicTacToe;

public class Player {

	private int rows;
	private int columns;
	private char currentPlayer;
	private char[][] board;
	
	public Player(int rows, int columns, char currentPlayer, char[][] board) {
		
		this.rows = rows;
		this.columns = columns;
		this.currentPlayer = currentPlayer;
		this.board = board;
	}
	
	public int humanPlayer(int row, int column) {
	
		PlayersInput player = new PlayersInput();
		if(row<0 || column<0) {			//for a correct input	
			return 0;
		} else if(!player.playerInput(row, column, rows, columns, currentPlayer, board)) {		////returns true if the input is correct
			return 1;
		}
		return 2;
	}
	
	public int computerPlayer() {
		
		PlayersInput player = new PlayersInput();

		//returns true if the input is correct
		if(!player.computerInput(rows, columns, currentPlayer, board)) {
			return 1;
		}
		return 2;
	}
}
