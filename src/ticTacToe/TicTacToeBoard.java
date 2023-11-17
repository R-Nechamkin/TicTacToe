package ticTacToe;

public class TicTacToeBoard extends TableGameBoard {
	private String [][] board;
	private static final int SIZE = 3;
	
	
	public TicTacToeBoard() {
		super(SIZE,SIZE, "Tic Tac Toe");
	}
	
	
	public void placePiece(String piece, int row, int col) throws IllegalMoveException {
		if (row >= SIZE || col >= SIZE) {
			throw new IllegalMoveException("Tic Tac Toe is played with a 3*3 board");
		}
		if (board[row][col] != null) {
			throw new IllegalMoveException("There is already a piece in this position");
		}
		board[row][col] = piece;
	}
	

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" \t1\t2\t3\n");
		char[] rowNames = {'A', 'B', 'C'};
		for (int i = 0; i < SIZE; i++) {
			sb.append(rowNames[i]);
			for (int j = 0; j < SIZE; j++) {
				String value = board[i][j] == null? "_": board[i][j];
				sb.append("\t" + value);
			}
			sb.append("\n");
		}
		return sb.toString();
	}	

}
