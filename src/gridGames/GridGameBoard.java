package gridGames;

import java.util.List;
import java.util.ArrayList;

import exceptions.IllegalMoveException;
import general.GameBoard;

public abstract class GridGameBoard implements GameBoard{
	private Character[][] board;
	private  int height;
	private  int width;
	private String gameName;

	
	/**
	 * 
	 * @param height The number of rows on the board
	 * @param width The number of columns on the board
	 * @param gameName The name of the game
	 */
	public GridGameBoard(int height, int width, String gameName) {
		this.height = height;
		this.width = width;
		board = new Character[height][width];
		this.gameName = gameName;

	}
	/**
	 * This method is used to place pieces on the board
	 * @param piece - A String with the name of the piece
	 * @param row - An int holding the row the piece should be placed in
	 * @param col - An int holding the column the piece should be placed in
	 * @throws IllegalMoveException if the piece was placed illegally
	 */
	public void placePiece(Character piece, int row, int col) throws IllegalMoveException{
		if (piece == null) {
			throw new IllegalArgumentException("You just tried to place a piece of value null.");
		}
		if (row >= height || col >= width) {
			throw new IllegalMoveException(gameName + " uses a " + height + "*" + width + " board.");
		}
		if (board[row][col] != null) {
			throw new IllegalMoveException("There is already a piece in this position");
		}
		board[row][col] = piece;
	}
	

	/**
	 * Returns the piece at the given spot on the board.
	 * 	Note that the parameters represent the array indices of the cell on the board.
	 *  For a more user-friendly method, use the getPiece method which takes a {@code Position} parameter
	 * @param row
	 * @param col
	 * @return
	 */
	public Character getPiece(int row, int col) {
		return board[row][col];
	}
	
	/**
	 * Returns the piece at the given position on the board
	 * @param p a {@code Position} object
	 * @return A char representing the piece at that position
	 */
	public Character getPiece(Position p) {
		return getPiece(p.getRowIndex(), p.getColIndex());
	}
	
	
	/**
	 * @return the number of rows which the board has
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @return the number of columns which the board has
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Returns true if the board is full (i.e.: every spot on the board has a piece in it)
	 * @return
	 */
	public boolean isFull() {
		for(Character[] row: board) {
			for (Character box: row) {
				if (box == null)
					return false;
			}
		}
		return true;
	}

	public void placePiece(String[] info) throws IllegalMoveException {
		placePiece(info[0].charAt(0), Integer.parseInt(info[1]), Integer.parseInt(info[2]));
		
	}
	
	public abstract Character getWinner();

}
