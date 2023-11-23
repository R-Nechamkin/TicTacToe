package ticTacToe;

import java.util.Scanner;

public abstract class HumanStrategy implements Strategy{
	Scanner input;
	
	public HumanStrategy(Scanner in) {
		this.input = in;
	}
	
	public abstract Position choosePosition(TableGameBoard board) throws IllegalArgumentException;
	

}
