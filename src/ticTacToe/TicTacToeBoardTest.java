package ticTacToe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTacToeBoardTest {

	@Test
	void PlacingPieceWhereThereAlreadyIsOneThrowsException() {
		GameBoard board = new TicTacToeBoard();
		
		// setup
		try {
			board.placePiece("X", 1, 1);
		} catch (IllegalMoveException e) {
			e.printStackTrace();
		}
		
		assertThrows(IllegalMoveException.class, () -> {board.placePiece("X", 1, 1);});
	}
	
	@Test
	void PlacingPieceOutOfBoundsThrowsIllegalMoveException() {
		GameBoard board = new TicTacToeBoard();
		assertThrows(IllegalMoveException.class, () -> {
			board.placePiece("X", 3, 2);
		}, "Was able to place a piece in a nonexistent row");
		
		assertThrows(IllegalMoveException.class, () -> {
			board.placePiece("X", 2, 3);
		}, "Was able to place a piece in a nonexistent column");
		
	}

}
