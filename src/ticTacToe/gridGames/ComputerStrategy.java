package gridGames;

import exceptions.IllegalMoveException;

public abstract class ComputerStrategy implements Strategy {


	@Override
	public abstract Position choosePosition(GridGameBoard board) throws IllegalMoveException;
	

}
