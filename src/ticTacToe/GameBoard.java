package ticTacToe;

public interface GameBoard {
	
	/**
	 * This method is used to place pieces on the board
	 * @param information an array of Strings holding the information about the piece and its placement
	 * 	The implementing class should have a way to parse the array into data it can use
	 * @throws IllegalMoveException if the piece was placed illegally
	 */
	public void placePiece(String[] information) throws IllegalMoveException;
}
