package ticTacToe;


import java.util.ArrayList;
import java.util.List;

import exceptions.IllegalMoveException;
import gridGames.*;

public class TicTacToeBoard extends GridGameBoard {
	private static final int SIZE = 3;
	
	private static final Position[] CORNERS = 
		{new TTTPosition('A', '1'), new TTTPosition('A', '3'), new TTTPosition('C', '1'), new TTTPosition('C', '3')};
	private static final Position[] EDGES =
		{new TTTPosition('A', '2'), new TTTPosition('B', '1'), new TTTPosition('B', '3'), new TTTPosition('C', '2')};
	private static final Position CENTER = new TTTPosition('B', '2');
	
	// This list keeps track of all the possible ways someone can win
	private static final Position[][] WINS = {
			{CORNERS[0], CENTER, CORNERS[3]},
			{CORNERS[1], CENTER, CORNERS[2]},
			{CORNERS[0], EDGES[0], CORNERS[1]},
			{EDGES[1], CENTER, EDGES[2]},
			{CORNERS[2], EDGES[3], CORNERS[3]},
			{CORNERS[0], EDGES[1], CORNERS[3]},
			{EDGES[0], CENTER, EDGES[3]},
			{CORNERS[1], EDGES[2], CORNERS[3]}			
	};

	// This list is really included as utility for other classes' use
	private List<Position> filled; 
	
	
	public TicTacToeBoard() {
		super(SIZE,SIZE, "Tic Tac Toe");		
		filled = new ArrayList<>();
	}
	
	/**
	 * This method is used to place pieces on the board using array indices
	 * @param piece - A Character with the name of the piece
	 * @param row - An int holding the row the piece should be placed in
	 * @param col - An int holding the column the piece should be placed in
	 * @throws IllegalMoveException if the piece was placed illegally
	 */
	@Override
	public void placePiece(Character piece, int row, int col) throws IllegalMoveException{
		placePiece(piece, new TTTPosition(row, col));
	}
	
	/**
	 * This method places a piece on the board using the {@code Position} class
	 * @param piece
	 * @param p the Position the piece should be placed in
	 * @throws IllegalMoveException
	 */
	public void placePiece(Character piece, Position p) throws IllegalMoveException {
		if (piece == null)
			throw new IllegalMoveException("You have attempted to place a piece of value null");
		int row = p.getRowIndex();
		int col = p.getColIndex();
		super.placePiece(piece, row, col);
		filled.add(p);
	}
	
	/**
	 * This method places a piece on the board using the {@code char} names for the rows and collumns
	 * @param piece
	 * @param row the row the piece should be placed in; this can be A, B, or C
	 * @param col the column the piece should be placed in; this can be 1, 2, or 3
	 * @throws IllegalMoveException
	 */
	public void placePiece(Character piece, char row, char col) throws IllegalMoveException{
		placePiece(piece, new TTTPosition(row, col));
	}
	
	/**
	 * Returns a set containing all the cells in the board which have pieces in them. 
	 * More formally, it returns a map of cells containing every position on the board such that 
	 *  board[Position] != {@code null}.
	 * This map is not connected to any internal set of this class(meaning that it can be 
	 * 	changed at will without affecting this class).
	 * @return A set with all positions which have had pieces placed in them
	 */
	public List<Position> getAllFilledSets(){
		return new ArrayList<>(this.filled);
	}
	
	/**
	 * This method checks whether anyone has won the game by getting 3 in a row
	 * @return the char of the winner's piece, or {@code null} if no player has won
	 */
	public Character getWinner() {
		for (Position[] row: WINS) {
			Character winner = isRowWinner(row); 
			if (winner != null)
				return winner;
		}
		return null;
	}
	
	/**
	 * This method checks whether a player has gotten 3 in  a row on a specific row/column
	 * @param row A Position[] which represents a set of three Positions on the board.
	 * 	This can be a literal row, a column, or a diagonal.
	 * @return the character of the winner, or null if the row is not a winner
	 */
	public Character isRowWinner(Position[] row) {
		if (row.length != 3) {
			throw new IllegalArgumentException();
		}
		Character player;
		if (getPiece(row[0]) == null)
			return null;
		else {
			player = getPiece(row[0]);
		}
		for (Position p: row) {
			if (getPiece(p) != player)
				return null;
		}
		return player;
	}
	
	public static Position[][] getWinningRows(){
		Position[][] copy = new Position[8][3];
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				copy[i][j] = WINS[i][j];
			}
		}
		return copy;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" \t1\t2\t3\n");
		char[] rowNames = {'A', 'B', 'C'};
		for (int i = 0; i < SIZE; i++) {
			sb.append(rowNames[i]);
			for (int j = 0; j < SIZE; j++) {
				Character piece = this.getPiece(i, j);
				String value = piece == null? "_": String.valueOf(piece);
				sb.append("\t" + value);
			}
			sb.append("\n");
		}
		return sb.toString();
	}	

}
