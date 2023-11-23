package ticTacToe;

public abstract class ComputerStrategy implements Strategy {


	@Override
	public abstract Position choosePosition(TableGameBoard board);
	

}
