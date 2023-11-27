package ticTacToe;


import exceptions.IllegalMoveException;
import gridGames.Position;
import gridGames.Strategy;
import gridGames.GameInfo;
import gridGames.GridGameBoard;

/**
 * This class is the abstract Player class, parent of the HumanPlayer and ComputerPlayer classes.
 * Note that the class is abstract even though all of its methods are implemented.
 * This is because the class itself should never be implemented, only its children should be.
 * The truth is that the main difference between {@code HumanPlayer} and {@code ComputerPlayer} is just
 *  their different {@code Strategy} objects.
 * @author R Nechamkin
 *
 */
public abstract class Player {
	
	private char pieceType;
	private int numPieces;
	private String name;
	private Strategy strat;

	
	public Player(char pieceType, int numPieces, String name, Strategy s) {
		this.pieceType = pieceType;
		this.numPieces = numPieces;
		this.name = name;
		this.strat = s;
	}
	
	/**
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return a char holding the type of pieces which the player is using
	 */
	public char getPieceType() {
		return pieceType;
	}
	
	/**
	 * 
	 * @return the number of pieces the player has left
	 */
	public int getNumPieces() {
		return numPieces;
	}
	
	/**
	 * Has the player play its turn, placing a piece according to the position which is passed in
	 * @param pos a {@code Position} object holding the position for the player to place their next piece in during this turn
	 * @param board the board that this player is playing with
	 * @return A char array with 3 elements in this order: the piece played, the row it was played in, and the column it was played in. <br>
	 * 	As an example, a return value of ['X', 'A', '1'] means that a player has placed an X piece in the top left corner of the board
	 * @throws IllegalMoveException 
	 */
	public char[] play(Position pos, GridGameBoard board) throws IllegalMoveException {
		if (numPieces <= 0) {
			throw new IllegalMoveException(name + " has no more pieces left to play.");
		}
		numPieces --;
		board.placePiece(pieceType, pos.getRowIndex(), pos.getColIndex());
		char[] move = {pieceType, pos.getRow(), pos.getCol()};
		return move;
	}
	
	/**
	 * Has the player play its turn, placing a piece according to the position which is passed in
	 * The two parameters give the position on the board where the player should place their piece
	 * @param row a char holding one of these values: 'A', 'B', or 'C' (representing the top, middle, or bottom row, respectively)
	 * @param col a char holding one of these values: '1', '2', or '3' (representing the left, middle, or right column respectively)
	 * @param board the board that this player is playing with
	 * @return A char array with 3 elements in this order: the piece played, the row it was played in, and the column it was played in. <br>
	 * 	As an example, a return value of ['X', 'A', '1'] means that a player has placed an X piece in the top left corner of the board
	 * @throws IllegalMoveException
	 */
	public char[] play(char row, char col, GridGameBoard board) throws IllegalMoveException {
		Position p;
		try {
			p = new TTTPosition(row, col);
		} catch (IllegalArgumentException e) {
			throw new IllegalMoveException(e.getMessage());
		}
		return play(p, board);
	}
	
	/**
	 * Has the player play its turn
	 * This method calls {@code choosePosition()} to decide what position to use and then plays the turn with that position
	 * @param board the board that this player is playing with
	 * @return A char array with 3 elements in this order: the piece played, the row it was played in, and the column it was played in. <br>
	 * 	As an example, a return value of ['X', 'A', '1'] means that a player has placed an X piece in the top left corner of the board
	 * @throws IllegalMoveException 
	 * @throws IllegalArgumentException 
	 */
	public char[] play(GridGameBoard board) throws IllegalArgumentException, IllegalMoveException {
		Position p = choosePosition(board);
		char[] move = null;
		
		try {
			move = play(p, board);
		} catch (IllegalMoveException e) {
			// Since choosePosition() has input validation to only allow picking valid moves, we want to hide the
			//  possibility of the IllegalMoveException being thrown by play(Position pos) 
		}
		return move;
	}
	
	/**
	 * In this method, the player chooses what position on the board they would like to place their piece
	 * Note that all this method actually does is call the {@code choosePosition()} method of the player's {@code Strategy} object
	 * @param board the board that this player is playing with
	 * Note that the strategy object is what differentiates HumanPlayer from ComputerPlayer
	 * @return a {@code Position} object holding the position for the player to place their next piece in
	 * @throws IllegalMoveException 
	 * @throws IllegalArgumentException 
	 */
	public Position choosePosition(GridGameBoard board) throws IllegalArgumentException, IllegalMoveException {
		return strat.choosePosition(board);
	}

}
