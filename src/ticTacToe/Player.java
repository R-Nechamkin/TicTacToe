package ticTacToe;

import java.util.List;

public interface Player {
	
	/**
	 * Allows the calling method to get the pieces which the player has left
	 * @return a List containing the piece names as Strings
	 */
	public List<String> seePieces();
	
	/**
	 * The method to make the player play its turn
	 * @return A char array with 3 elements in this order: the piece played, the row it was played in, and the column it was played in. <br>
	 * 	As an example, a return value of ['X', 'A', '1'] means that a player has placed an X piece in the top left corner of the board
	 */
	public char[] play();
}
