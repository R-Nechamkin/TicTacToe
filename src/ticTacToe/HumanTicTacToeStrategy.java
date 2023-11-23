package ticTacToe;

import java.util.Scanner;

import validation.*;

public class HumanTicTacToeStrategy extends HumanStrategy {
	private Validation val;
	private final static String rowOptions = "ABC";
	private final static String colOptions = "123";
	
	public HumanTicTacToeStrategy(Scanner keyboard) {
		super(keyboard);
		val = new ConsoleValidation(keyboard);
	}
	
	/**
	 * This method lets the human user choose what position they want to place their piece in for the turn
	 * To do this, it prints things out to the console and reads from a scanner which is assumed to be connected to Standard In
	 */
	public Position choosePosition(TableGameBoard board) throws IllegalArgumentException{
		System.out.println("Type the position you would like to place your piece in (row, space, then column): ");
		String row = input.next();
		String col = input.next();
		val.validateCharacter(row, rowOptions, "Please type the letter of the row you would like to place your piece in: ");
		val.validateCharacter(col, colOptions, "Please type the number of the column you would like to place your piece in: ");
		
		
		Position pos = null;
		pos = new Position(row.charAt(0), col.charAt(0));

		return pos;
	}

}


