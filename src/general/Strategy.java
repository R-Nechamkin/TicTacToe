package general;

import exceptions.IllegalMoveException;
import gridGames.Position;

public interface Strategy {
	
	public Position choosePosition() throws IllegalArgumentException, IllegalMoveException;


}
