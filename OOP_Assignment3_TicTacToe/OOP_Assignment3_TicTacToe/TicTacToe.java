package OOP_Assignment3_TicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

	private char currentPlayer;						//variable used to keep track of current player
	private char[][] board;							//board used to play on
	
	//this constructor initializes the current player with x
	public TicTacToe() {	
		
		currentPlayer = 'x';
	}
	
	//this method initializes the board with a blank
	public int initBoard(int rows, int columns) {
		
		if(rows != columns) {				//the matrix should be a square matrix
			return 0;
		} else if(rows<1 || columns<1) {		//number of rows and columns should be greater than 0
			return 1;
		} else {
			
			board = new char[rows][columns];
			for(int rowIndex=0 ; rowIndex<rows ; rowIndex++) {
				for(int colIndex=0 ; colIndex<columns ; colIndex++) {
				
					board[rowIndex][colIndex] = ' ';
				}
			}
			return 2;
		}
	}
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {

			Boolean play = true;
			while(play) {
		
				System.out.println();
				System.out.println("The game begins");
				System.out.println("Please enter the number of rows and columns for the game");
				
				//input rows and columns(size of the game matrix)
				int rows = sc.nextInt();						
				int columns = sc.nextInt();
					
				TicTacToe ticTacToe = new TicTacToe();		//Constructor is called
				int check = ticTacToe.initBoard(rows, columns);
				if(check == 0) {				//the matrix should be a square matrix
					
					System.out.println("Number of rows and columns should be equal.");
					System.out.println("Please try again..");
					continue;
				} else if(check == 1) {		//number of rows and columns should be greater than 0
					
					System.out.println("Please enter a value greater than zero.");
					continue;
				} else if(check == 2) {
					
					System.out.println();
					System.out.println("Enter 1 to play with another human.");
					System.out.println("Enter 2 to play with the computer.");
					System.out.println("Enter your choice:");
					int playerChoice = sc.nextInt();
					
					Boolean nextMove = true;		//a variable to check if the game is continuing or ends
					
					while(nextMove) {
					
						Player player = new Player(rows, columns, ticTacToe.currentPlayer, ticTacToe.board);
						int inputCheck = 0;
						if(playerChoice == 1) {
						
							System.out.println("This is "+ticTacToe.currentPlayer+"(human) chance. Input the coordinates between[1-3][1-3]");
							//inputs the position in which the player enters his symbol 
							int row = sc.nextInt() - 1;
							int column = sc.nextInt() - 1;

							inputCheck = player.humanPlayer(row, column);
						} else if(playerChoice == 2) {
	
							if(ticTacToe.currentPlayer == 'x') {
							
								System.out.println("This is "+ticTacToe.currentPlayer+"(computer) chance. Input the coordinates between[1-3][1-3]");
								inputCheck = player.computerPlayer();
							} else {
								
								System.out.println("This is "+ticTacToe.currentPlayer+"(human) chance. Input the coordinates between[1-3][1-3]");
								int row = sc.nextInt() - 1;
								int column = sc.nextInt() - 1;
								inputCheck = player.humanPlayer(row, column);
							}
						} else {
							System.out.println("Enter from the given choices!!");
							System.out.println("Exited");
							break;
						}
						if(inputCheck == 0) {
							
							System.out.println("Please enter the number greater than zero.");
						} else if(inputCheck == 1) {
							
							System.out.println("The space is already occupied.");
							System.out.println("Please enter at a new place.");
							continue;
						}
						
						PlayersInput playerInput = new PlayersInput();
						CheckForResult result = new CheckForResult(rows, columns, ticTacToe.currentPlayer, ticTacToe.board);
						BoardPrint boardPrint = new BoardPrint();
						boardPrint.printBoard(rows, columns, ticTacToe.board);
						
						//returns true if the current player wins
						if(!result.CheckForWin()) {
							//returns true if the match is drawn
							if(result.checkForDraw()) {
								System.out.println("The game is drawn");
								nextMove = false;
							} else {
								//if game is in progress change the current user and print the board
								ticTacToe.currentPlayer = playerInput.playerChange(ticTacToe.currentPlayer);				
							}
						} else {
							System.out.println(ticTacToe.currentPlayer+" has won the game.");
							nextMove = false;
						}
					}
				}
				System.out.println();
				System.out.println();
				System.out.println("Do you want to play again(Enter yes to play again otherwise exited)??");
				String wantToPlay = sc.next();
				if(wantToPlay.equalsIgnoreCase("yes")) {
					play = true;
				} else {
					play = false;
					System.out.println("Exited");
				}
			}
		} catch(InputMismatchException exp) {
		
			System.out.println("Please enter a positive integer.");
			System.out.println("Please restart the game.");
		} catch(Exception exp) {
		
			System.out.println("Please enter a positive integer.");
			System.out.println("Please restart the game.");
		} finally {

			sc.close();
		}
	}
}