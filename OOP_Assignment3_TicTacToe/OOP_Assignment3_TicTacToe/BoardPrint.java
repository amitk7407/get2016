package OOP_Assignment3_TicTacToe;

public class BoardPrint {

	//this method prints the board every time there is an input
	public void printBoard(int rows, int columns, char[][] board) {
		
		for(int rowIndex=0 ; rowIndex<rows ; rowIndex++) {
			
			for(int index=0 ; index<rows*4+1 ; index++) {

				System.out.print("-");
			}
			System.out.println();
			System.out.print("| ");
			for( int colIndex=0 ; colIndex<columns ; colIndex++) {
				
				System.out.print(board[rowIndex][colIndex]);					
				System.out.print(" | ");
			}
			System.out.println();
		}
		for(int index=0 ; index<rows*4+1 ; index++) {

			System.out.print("-");
		}
		System.out.println();
	}
}