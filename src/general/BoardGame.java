package general;

import java.util.List;

import exceptions.IllegalMoveException;
import gridGames.GridGameBoard;
import ticTacToe.Player;

public interface BoardGame {
	
	/**
	 * This method prepares the game to be played
	 */
	void setUpGame();
	
	
	/**
	 * This method tests whether the game is finished or not
	 * @return "null" if the game is not yet over or a String representing the winner if it is
	 * 	This is typically the name of the winning player, "TIE" for a tie, or "NO_WINNER" for a game which ended early.
	 * @throws IllegalMoveException 
	 */
	String isGameOver() throws IllegalMoveException;
	
	/**
	 * 
	 * @param winner 
	 * @return a String stating the results of the game
	 */
	String endGame(String winner); 
	
	/**
	 * Returns a list of players
	 * Note that in most games, the players will be internally stored as a queue or in some other data structure, not in a list
	 * @return
	 */
	List<Player> getPlayers();
	
	/**
	 * Returns a {@code String} showing what the board looks like
	 * @return a {@code String} showing what the board looks like
	 */
	String seeBoard();
	
	
	/**
	 * Starts the game.
	 * This usually has the game continue playing until the game is over.
	 * Think of it like a main() method for the game class.
	 * @return a String representing the winner of the game.
	 * 	This is typically the name of the winning player, "TIE" for a tie, or "NO_WINNER" for a game which ended early.
	 */
	String startGame();
	
	/**
	 * Clears everything and starts the game again
	 */
	void playAgain();




	
}
