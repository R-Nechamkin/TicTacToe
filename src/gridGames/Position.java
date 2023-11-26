package gridGames;

import java.util.Arrays;
import java.util.Objects;

public abstract class Position {

	private char row;
	private char col;
	private char[] rowOptions;
	private char[] colOptions;
	private String rOptionsDescription;
	private String cOptionsDescription;

	public Position(char row, char col, char[] rOptions, char[] cOptions) throws IllegalArgumentException{
		this.rowOptions = rOptions;
		this.colOptions = cOptions;
		rOptionsDescription = createOptionStrings(rOptions);
		cOptionsDescription = createOptionStrings(cOptions);
		// We need both the rowOptions and the String descriptions of the row options before we can validate 
			// that the row and column name is valid
		validateCharInput(row, col);
		this.row = row;
		this.col = col;
	}
	
	public Position(int row, int col, char[] rOptions, char[] cOptions) throws IllegalArgumentException{
		this.rowOptions = rOptions;
		this.colOptions = cOptions;
		this.row = convertIndexToRow(row);
		this.col = convertIndexToCol(col);

		rOptionsDescription = createOptionStrings(rOptions);
		cOptionsDescription = createOptionStrings(cOptions);
	}
	
	
	/**
	 * This constructor creates a position based on a String of length 2 which is of the same syntax as 
	 * 	a string created by the toString() method of this class. That is to say, the first  character of the String
	 *  should be the name of the row, the second the name of the column.
	 * This means that if {@code p} is an instance of a class which extends Position, {@code Position(p.toString())} would create a
	 *  {@code Position} object identical to {@code p}. 
	 * @param position
	 * @throws IllegalArgumentException if the string is is not of length 2 or if the {@code char} which is meant to
	 *  describe the row/column of the position does not match the name of any row/column on the board.
	 */
	public Position(String position, char[] rOptions, char[] cOptions) throws IllegalArgumentException{
		if (position.length() != 2) {
			throw new IllegalArgumentException("This constructor only accepts strings of length 2");
		}

		this.rowOptions = rOptions;
		this.colOptions = cOptions;
		rOptionsDescription = createOptionStrings(rOptions);
		cOptionsDescription = createOptionStrings(cOptions);
		// We need both the rowOptions and the String descriptions of the row options before we can validate 
		// that the row and column name is valid
		char r = position.charAt(0);
		char c = position.charAt(1);
		validateCharInput(r, c);
		this.row = r;
		this.col = c;
	}
	

	/**
	 * 
	 * @return a char holding the name of the row of the position
	 */
	public char getRow() {
		return row;
	}

	/**
	 * 
	 * @return a char holding the name of the column of the position
	 */
	public char getCol() {
		return col;
	}

	/**
	 * This method is used to convert the row name into an index on the double array board
	 * @return 
	 */
	public int getRowIndex() {
		return indexOf(row, rowOptions);
	}

	/**
	 * This method is used to convert the column name into an index on the double array board
	 * @return 
	 */
	public int getColIndex() {
		return indexOf(col, colOptions);
	}

	@Override
	public String toString() {
		return "" + row + col;
	}
	
	

	/**
	 * This method converts an array index into the {@code char} which that row is named on the
	 * 	game board associated with the position
	 * @param r
	 * @return
	 * @throws IllegalArgumentException if the parameter row is out of the game board's bounds
	 */
	public char convertIndexToRow(int r) throws IllegalArgumentException {
		if (r < 0)
			throw new IllegalArgumentException("Row was negative");
		if (r >= rowOptions.length)
			throw new IllegalArgumentException("Row is out of bounds");
		return rowOptions[r];
	}

	/**
	 * This method converts an array index into the {@code char} which that column is named
	 * 	on the game board associated with the position.
	 * @param col
	 * @return
	 * @throws IllegalArgumentException if the parameter column is out of the game board's bounds
	 */
	public char convertIndexToCol(int c) throws IllegalArgumentException {
		if (c < 0)
			throw new IllegalArgumentException("Column was negative");
		if (c >= colOptions.length)
			throw new IllegalArgumentException("Column is out of bounds");
		return colOptions[c];
	}

	/**
	 * This method checks whether a row and column define a valid position on the game board associated with the position.
	 * 	If the {@code char} which is meant to describe the row of the position is not a valid row on the board, this method will 
	 * 	throw an IllegalArgumentException with that message. It will do the same if the {@code char} which is meant to describe the column of
	 *  the position is not a valid column on the board.
	 * @param row
	 * @param col
	 * @throws IllegalArgumentException if the row or column is not a valid row on the board
	 */
	private void validateCharInput(char row, char col) throws IllegalArgumentException {
		String message = "";
		boolean problem = false;
		if(!(holds(this.rowOptions, row))) {
			message = "The rows on this board are labeled " + rOptionsDescription + "\n"
					+ "You sent in " + row + " as the value for the row of this position.";
			problem = true;
		}
		if (!(holds(this.colOptions, col))) {
			message += "The columns on this board are labeled " + cOptionsDescription + "\n"
					+ "You sent in " + col + " as the value for the column of this position.";
			problem = true;
		}
		if (problem)
			throw new IllegalArgumentException(message);
		
	}
	
	/**
	 * This method checks whether a char[] array holds a certain character
	 * @param array  an array of {@code char}s
	 * @param c  the {@code char} to be checked
	 * @return {@code true} if the array contains the char and {@code false} if it does not
	 */

	private static boolean holds(char[] array, char c) {
		for (int i = 0; i < array.length; i++) {
			if (c == array[i])
				return true;
		}
		return false;
	}
	
	/**
	 * This method returns the first index that a {@code char} occurs in a given {@code char[]} array
	 * @param array a {@code char[]} array
	 * @param c the char whose index is desired
	 * @return the first index that the char appears or -1 if the char is not in the array
	 */
	private static int indexOf(char c, char[] array) {
		for (int i = 0; i < array.length; i++) {
			if (c == array[i])
				return i;
		}
		return -1;
	}
	
	private static String createOptionStrings(char[] arr) {
		StringBuilder sb = new StringBuilder();
		if (arr.length > 1) {
			for (int i = 0; i< arr.length - 1; i++) {
				sb.append(arr[i] + ", ");
			}
			sb.append("and " + arr[arr.length - 1]);
		}
		else {
			sb.append(arr[0]);
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(colOptions);
		result = prime * result + Arrays.hashCode(rowOptions);
		result = prime * result + Objects.hash(cOptionsDescription, col, rOptionsDescription, row);
		return result;
	}

	@Override
	public abstract boolean equals(Object obj);
	
	
}