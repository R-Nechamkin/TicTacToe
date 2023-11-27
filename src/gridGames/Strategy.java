package gridGames;

import exceptions.IllegalMoveException;

public interface Strategy {
	
	public Position choosePosition(GridGameBoard board) throws IllegalArgumentException, IllegalMoveException;


}
