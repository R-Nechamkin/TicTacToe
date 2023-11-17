package ticTacToe;

import java.util.List;

public interface BoardGame {
	
	/**
	 * This method prepares the game to be played
	 */
	void setUpGame();
	
	/**
	 * This method tests whether the game is finished or not
	 * @return
	 */
	boolean isGameOver();
	
	/**
	 * 
	 * @param winner typically holds the name of the winning player, "TIE" for a tie, or "NO_WINNER" for a game which ended early
	 * @return a String stating the results of the game
	 */
	String endGame(String winner); 
	
	/**
	 * Returns a list of players
	 * Note that in most games, the players will be internally stored as a queue or in some other data structure, not in a list
	 * @return
	 */
	List<Player> getPlayers();

	String seeBoard();
}
