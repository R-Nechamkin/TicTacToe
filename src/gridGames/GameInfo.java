package gridGames;

import ticTacToe.Player;

public interface GameInfo {

	/**
	 * @return a Player representing the human player
	 */
	Player getHuman();

	/**
	 * @return a Player representing the computer player
	 */
	Player getComputer();

	/**
	 * @return the board
	 */
	GridGameBoard getBoard();

}
