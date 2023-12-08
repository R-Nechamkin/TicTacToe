package gridGames;

import tTTGameClasses.Player;

public interface GameInfo {

	/**
	 * @return the first player
	 */
	Player getPlayer1();

	/**
	 * @return a Player representing the second player
	 */
	Player getPlayer2();

	/**
	 * @return the board
	 */
	GridGameBoard getBoard();

}
