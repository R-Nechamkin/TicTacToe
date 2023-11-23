package ticTacToe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTacToeBoardTest {

	@Test
	void PlacingPieceWhereThereAlreadyIsOneThrowsException() {
		TicTacToeBoard board = new TicTacToeBoard();
		
		Position a1 = new Position('A', '1');
		// setup
		try {
			board.placePiece('X', a1);
		} catch (IllegalMoveException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		assertThrows(IllegalMoveException.class, () -> {board.placePiece('X', a1);});
	}
	
	@Test
	void PlacingPieceOutOfBoundsThrowsIllegalMoveException() {
		TicTacToeBoard board = new TicTacToeBoard();
		assertThrows(Throwable.class, () -> {
			board.placePiece('X', 'D', '2');
		}, "Was able to place a piece in a nonexistent row");
		
		assertThrows(Throwable.class, () -> {
			board.placePiece('X', 'B', '4');
		}, "Was able to place a piece in a nonexistent column");
		
	}

}
