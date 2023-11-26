package general;

import exceptions.IllegalMoveException;
import gridGames.Position;

public abstract class ComputerStrategy implements Strategy {


	@Override
	public abstract Position choosePosition() throws IllegalMoveException;
	

}
