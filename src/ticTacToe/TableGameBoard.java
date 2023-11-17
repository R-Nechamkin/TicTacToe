package ticTacToe;

public class TableGameBoard implements GameBoard{
	private String[][] board;
	private  int height;
	private  int width;
	private String gameName;
	
	/**
	 * 
	 * @param height The number of rows on the board
	 * @param width The number of columns on the board
	 * @param gameName The name of the game
	 */
	public TableGameBoard(int height, int width, String gameName) {
		this.height = height;
		this.width = width;
		board = new String[height][width];
		this.gameName = gameName;
	}
	/**
	 * This method is used to place pieces on the board
	 * @param piece - A String with the name of the piece
	 * @param row - An int holding the row the piece should be placed in
	 * @param col - An int holding the column the piece should be placed in
	 * @throws IllegalMoveException if the piece was placed illegally
	 */
	public void placePiece(String piece, int row, int col) throws IllegalMoveException{
		if (row >= height || col >= width) {
			throw new IllegalMoveException(gameName + " uses a " + height + "*" + width + " board.");
		}
		if (board[row][col] != null) {
			throw new IllegalMoveException("There is already a piece in this position");
		}
		board[row][col] = piece;
	}
	
	/**
	 * Returns the pieces at the given spot on the board
	 * @param row
	 * @param col
	 * @return
	 */
	public String getPiece(int row, int col) {
		return board[row][col];
	}
	
	/**
	 * Returns true if the board is full (i.e.: every spot on the board has a piece in it)
	 * @return
	 */
	public boolean isFull() {
		for(String[] row: board) {
			for (String box: row) {
				if (box == null)
					return false;
			}
		}
		return true;
	}

	public void placePiece(String[] info) throws IllegalMoveException {
		placePiece(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]));
		
	}
}
