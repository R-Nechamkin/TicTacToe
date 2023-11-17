package ticTacToe;

import java.util.Scanner;

public abstract class HumanStrategy implements Strategy{
	Scanner input;
	
	public HumanStrategy(Scanner in) {
		this.input = in;
	}
	
	public abstract String[] choosePosition(TableGameBoard board);
	
	public abstract String validateInput(String s, String[] options);

}
