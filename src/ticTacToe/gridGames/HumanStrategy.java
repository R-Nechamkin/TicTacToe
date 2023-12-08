package gridGames;

import java.util.Scanner;

public abstract class HumanStrategy implements Strategy{
	private Scanner input;
	
	public HumanStrategy(Scanner in) {
		this.setInput(in);
	}
	
	public abstract Position choosePosition(GridGameBoard board) throws IllegalArgumentException;

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}
	

}
