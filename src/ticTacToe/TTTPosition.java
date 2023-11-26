package ticTacToe;

import java.util.Objects;

import gridGames.Position;


/**
 * Instances of this classs are immutable
 * @author rnech
 *
 */
public class TTTPosition extends Position {
	
	private final static char[] ROWS = {'A', 'B', 'C'};
	private final static char[] COLUMNS = {'1', '2', '3'};
	
	/**
	 * This constructor creates a position according to the names of the row and columns on the game board
	 * @param row
	 * @param col
	 * @throws IllegalArgumentException if the input are not valid names of rows and columns
	 */
	public TTTPosition(char row, char col) throws IllegalArgumentException{
		super(row, col, getRowNames(), getColumnNames());
	}
	
	/**
	 * This constructor creates a position according to int values which represent array indices
	 * @param row
	 * @param col
	 * @throws IllegalArgumentException if the array indices are out of bounds of the game board
	 */
	public TTTPosition(int row, int col)  throws IllegalArgumentException{
		super(row, col,  getRowNames(), getColumnNames());
	}
	

	/**
	 * This constructor creates a position based on a String of length 2 which is of the same syntax as 
	 * 	a string created by the toString() method of this class. That is to say, the first  character of the String
	 *  should be the name of the row, the second the name of the column.
	 * This means that if {@code p} is an instance of this class, {@code TTTPosition(p.toString())} would create a
	 *  {@code TTTPosition} object identical to {@code p}. 
	 * @param position
	 * @throws IllegalArgumentException if the string is is not of length 2 or if the {@code char} which is meant to
	 *  describe the row/column of the position does not match the name of any row/column on the board.
	 */
	public TTTPosition(String position)  throws IllegalArgumentException{
		super(position,  getRowNames(), getColumnNames());
	}
	
	public static char[] getRowNames() {
		return ROWS;
	}
	
	public static char[] getColumnNames() {
		return COLUMNS;
	}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TTTPosition))
			return false;
		TTTPosition other = (TTTPosition) obj;
		return this.getRow()  == other.getRow() && this.getCol() == other.getCol();
	}

	
	
	
	

}
