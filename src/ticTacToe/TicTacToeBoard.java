package ticTacToe;

public class TicTacToeBoard extends TableGameBoard {
	private Character [][] board;
	private static final int SIZE = 3;
	
	
	public TicTacToeBoard() {
		super(SIZE,SIZE, "Tic Tac Toe");
	}
	
	/**
	 * As this method is intended to be called by other classes, rows and columns start counting from 0
	 * @param piece
	 * @param row the row the piece should be placed in; this can be 0, 1, or 2
	 * @param col the column the piece should be placed in; this can be 0, 1, or 2
	 * @throws IllegalMoveException
	 */
	public void placePiece(char piece, Position p) throws IllegalMoveException {
		int row = p.getRowIndex();
		int col = p.getColIndex();
		if (board[row][col] != null) {
			throw new IllegalMoveException("There is already a piece in this position");
		}
		board[row][col] = piece;
	}
	
	/**
	 * 
	 * @param piece
	 * @param row the row the piece should be placed in; this can be A, B, or C
	 * @param col the column the piece should be placed in; this can be 1, 2, or 3
	 * @throws IllegalMoveException
	 */
	public void placePiece(char piece, char row, char col) throws IllegalMoveException{
		Position pos = new Position(row, col);

		placePiece(piece, pos);
		
	}
	

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" \t1\t2\t3\n");
		char[] rowNames = {'A', 'B', 'C'};
		for (int i = 0; i < SIZE; i++) {
			sb.append(rowNames[i]);
			for (int j = 0; j < SIZE; j++) {
				String value = board[i][j] == null? "_": String.valueOf(board[i][j]);
				sb.append("\t" + value);
			}
			sb.append("\n");
		}
		return sb.toString();
	}	

}
