package ticTacToe;

import java.util.Scanner;

import general.HumanStrategy;
import gridGames.GameInfo;
import gridGames.GridGameBoard;
import gridGames.Position;
import validation.*;

public class HumanTicTacToeStrategy extends HumanStrategy {
	private Validation val;
	private GameInfo gameDetails;

	private final static char[] rowOptions = {'A', 'B', 'C'};
	private final static char[] colOptions = {'1', '2', '3'};
	
	public HumanTicTacToeStrategy(Scanner keyboard, GameInfo gInfo) {
		super(keyboard);
		this.gameDetails = gInfo;
		val = new ConsoleValidation(keyboard);
	}
	
	/**
	 * This method lets the human user choose what position they want to place their piece in for the turn
	 * To do this, it prints things out to the console and reads from a scanner which is assumed to be connected to Standard In
	 */
	public Position choosePosition() throws IllegalArgumentException{

		Position pos = getInputtedPosition();
		while(!positionEmpty(pos)) {
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

		System.out.println("Type the position you would like to place your piece in (row, space, then column): ");
		char row = keyboard.next().charAt(0);
		keyboard.nextLine(); // Clear buffer
		row = val.validateChar(row, rowOptions, "Please type the letter of the row you would like to place your piece in: ");
		
		char col = keyboard.next().charAt(0);
		keyboard.nextLine(); // Clear buffer
		col = val.validateChar(col, colOptions, "Please type the number of the column you would like to place your piece in: ");
		
		return new TTTPosition(row, col);
	}
	
	/**
	 * This method checks whether there is already a piece in a position.
	 * @param p the Position to be checked
	 * @return
	 */
	private boolean positionEmpty(Position p) {
		if(gameDetails.getBoard().getPiece(p.getRowIndex(), p.getColIndex()) != null) {
			return false;
		}
		return true;
	}

}


