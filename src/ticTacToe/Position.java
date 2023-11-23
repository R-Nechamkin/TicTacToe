package ticTacToe;

public class Position {
	
	private char row;
	private char col;
	public Position(char row, char col) throws IllegalArgumentException{
		if(!(row == 'A' || row == 'B' || row == 'C')) {
			throw new IllegalArgumentException("The rows on this board are labeled A, B, and C");
		}
		if (!(col == '1' || col == '2' || col == '3')) {
			throw new IllegalArgumentException("The columns on this board are labeled 1, 2, and 3");
		}
		this.row = row;
		this.col = col;
	}
	
	/**
	 * 
	 * @return a char of the value 'A', 'B', or 'C'
	 */
	public char getRow() {
		return row;
	}
	
	/**
	 * 
	 * @return a char of the value '1', '2', or '3'
	 */
	public char getCol() {
		return col;
	}
	
	/**
	 * This method is used to convert the row name into an index on the double array board
	 * @return 0 if the row is 'A', 1 if it is 'B', and 2 if it is 'C'
	 */
	public int getRowIndex() {
		int rowInt;
		if (row == 'A')
			rowInt = 0;
		else if (row == 'B')
			rowInt = 1;
		else
			rowInt = 2;
		return rowInt;
	}
	
	/**
	 * This method is used to convert the column name into an index on the double array board
	 * @return 0 if col is '1', 1 if it is '2', and 2 if it is '3'
	 */
	public int getColIndex() {
		int colInt;
		if (col == '1')
			colInt = 0;
		else if (col == '2')
			colInt = 1;
		else
			colInt = 2;
		return colInt;
	}

}
