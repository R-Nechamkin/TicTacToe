package ticTacToe;

public class TicTacToeBoard implements GameBoard {
	private char [][] board;
	
	
	public TicTacToeBoard() {
		board = new char[3][3];
	}
	
	public void placePiece(char piece, int row, int col) throws IllegalMoveException {
		if (board[row][col] == 0) {
			throw new IllegalMoveException("There is already a piece in this position");
		}
		board[row][col] = piece;
	}
	
	

}
