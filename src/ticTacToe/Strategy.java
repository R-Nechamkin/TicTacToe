package ticTacToe;

public interface Strategy {
	
	public Position choosePosition(TableGameBoard board) throws IllegalArgumentException;


}
