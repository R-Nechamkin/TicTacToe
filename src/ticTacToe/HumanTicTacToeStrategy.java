package ticTacToe;

import java.util.Scanner;

import gridGames.GridGameBoard;
import gridGames.HumanStrategy;
import gridGames.Position;
import validation.*;

public class HumanTicTacToeStrategy extends HumanStrategy {
	private Validation val;

	private final static char[] rowOptions = {'A', 'B', 'C'};
	private final static char[] colOptions = {'1', '2', '3'};
	
	public HumanTicTacToeStrategy(Scanner keyboard) {
		super(keyboard);
		val = new ConsoleValidation(keyboard);
	}
	
	/**
	 * This method lets the human user choose what position they want to place their piece in for the turn
	 * To do this, it prints things out to the console and reads from a scanner which is assumed to be connected to Standard In
	 * @param board the board that this player is playing with
	 * @return the Position the user desires to play their next piece in
	 */
	public Position choosePosition(GridGameBoard board) throws IllegalArgumentException{

		Position pos = getInputtedPosition();
		while(!positionEmpty(pos, board)) {
			System.out.println("Sorry, there is already a piece in this position");
			pos = getInputtedPosition();
		}

		return pos;
	}
	
	/**
	 * This method collects input from the user to find out where the human player would like to go next
	 * To do this, it prints things out to the console and reads from a scanner which is assumed to be connected to Standard In
	 */
	private Position getInputtedPosition() {
		Scanner keyboard = getInput();

		System.out.println("Type the row that you would like to place your piece in and then press enter.");
		char row = keyboard.nextLine().toUpperCase().charAt(0);
		row = val.validateChar(row, rowOptions, "Please type the letter of the row you would like to place your piece in"
				+ "\n The rows are A, B, and C: " );
		
		System.out.println("Type the column that you would like to place your piece in.");
		char col = keyboard.nextLine().toUpperCase().charAt(0);
		col = val.validateChar(col, colOptions, "Please type the number of the column you would like to place your piece in and then press enter"
				+ "\n The columns are 1, 2, and 3: ");
		
		return new TTTPosition(row, col);
	}
	
	/**
	 * This method checks whether there is already a piece in a position.
	 * @param board the board that this player is playing with
	 * @param p the Position to be checked
	 * @return
	 */
	private boolean positionEmpty(Position p, GridGameBoard board) {
		if(board.getPiece(p.getRowIndex(), p.getColIndex()) != null) {
			return false;
		}
		return true;
	}

}


