package general;

import java.util.List;
import java.util.Queue;

import exceptions.IllegalMoveException;
import tTTGameClasses.Player;

public interface BoardGame {
	
	/**
	 * This method prepares the game to be played
	 * @param oldQueue a queue of players whose contents will determine what the BoardGame's internal 
	 *  list of players will be
	 */
	void setUpGame(Queue<Player> oldQueue);
	
	
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
	String playGame();
	
	/**
	 * Clears everything and starts the game again
	 */
	void playAgain();

	
	/**
	 * This method returns the player whose turn it is to go next.
	 * It also places the player on the back of the queue as if it has taken its turn.
	 * If you only want to see who the next player is without moving it off the queue, use
	 * pollNextPlayer()
	 * @return
	 */
	Player getNextPlayer();
	
	/**
	 * This method returns the player whose turn it is to go next.
	 * Unlike getNextPlayer, this method does not move the player from its spot on the queue.
	 * @return
	 */
	Player pollNextPlayer();




	
}
