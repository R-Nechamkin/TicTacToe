package ticTacToe;

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
	 * @param winner typically holds the index of the winning player, -1 for a tie, or -2 for a game which ended early
	 */
	void endGame(int winner); 
}
