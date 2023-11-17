package ticTacToe;

public class IllegalMoveException extends Exception {

	public IllegalMoveException() {
		super("Someone attempted to make an illegal move");
	}

	public IllegalMoveException(String message) {
		super("Illegal move! " + message);
	}

}
