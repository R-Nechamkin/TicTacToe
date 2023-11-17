package ticTacToe;

import java.util.Scanner;

public class HumanTicTacToeStrategy extends HumanStrategy {

	public HumanTicTacToeStrategy(Scanner in) {
		super(in);
	}

	public String[] choosePosition(TableGameBoard board) {
		System.out.println("Type the position you would like to place your piece in (row, space, then column): ");
		String row = input.next();
		String col = input.next();
		
		String[] position = {row, col};
		return position;
	}

	@Override
	public String validateInput(String s, String[] options) {
		// TODO Auto-generated method stub
		return null;
	}

}
