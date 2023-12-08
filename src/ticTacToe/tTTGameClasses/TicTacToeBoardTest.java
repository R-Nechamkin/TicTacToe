package tTTGameClasses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.IllegalGameSetupException;
import exceptions.IllegalMoveException;
import gridGames.GameInfo;
import gridGames.Position;

class TicTacToeBoardTest {
	static TicTacToeBoard board;
	private static final Position[] CORNERS = 
		{new TTTPosition('A', '1'), new TTTPosition('A', '3'), new TTTPosition('C', '1'), new TTTPosition('C', '3')};
	private static final Position[] EDGES =
		{new TTTPosition('A', '2'), new TTTPosition('B', '1'), new TTTPosition('B', '3'), new TTTPosition('C', '2')};
	private static final Position CENTER = new TTTPosition('B', '2');
	private static final Position[][] WINS = TicTacToeBoard.getWinningRows();

	@BeforeEach
	void setUp() {
		board = new TicTacToeBoard();
	}
	
	@Test
	void PlacingPieceWhereThereAlreadyIsOneThrowsException() {
		Position a1 = new TTTPosition('A', '1');
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
		assertThrows(Throwable.class, () -> {
			board.placePiece('X', 'D', '2');
		}, "Was able to place a piece in a nonexistent row");
		
		assertThrows(Throwable.class, () -> {
			board.placePiece('X', 'B', '4');
		}, "Was able to place a piece in a nonexistent column");
		
	}
	
	@Test
	void IsRowWinnerGetsWinner() {
		Position[] topRow = {WINS[0][0], WINS[0][1], WINS[0][2] };
		try {
			board.placePiece('X', WINS[0][2]);
			board.placePiece('X', WINS[0][0]);
			board.placePiece('X', WINS[0][1]);
		} catch (IllegalMoveException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		assertEquals(board.isRowWinner(topRow), 'X');
	}
	
	@Test
	void GetWinnerWorks() {
		try {
			board.placePiece('X', WINS[0][2]);
			board.placePiece('X', WINS[0][0]);
			board.placePiece('X', WINS[0][1]);
		} catch (IllegalMoveException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		assertEquals(board.getWinner(), 'X');	
	}
	
	@Test
	void FilledListWorks() throws IllegalGameSetupException {
		Position h1 = new TTTPosition('A', '1');
		Position h2 = new TTTPosition('B', '2');
		Player computer = new ComputerPlayer(false);
		Position c1 = null;
		Position c2 = null;
		try {
			board.placePiece('X', h1);
			assertTrue(board.getAllFilledSets().contains(h1));
			c1 = computer.choosePosition(board);
			assertFalse(board.getAllFilledSets().contains(c1), "The computer chose a position already taken, c1.");
			board.placePiece('O', c1);
			assertTrue(board.getAllFilledSets().contains(c1));
			board.placePiece('X', h2);
			assertTrue(board.getAllFilledSets().contains(h2));
			c2 = computer.choosePosition(board);
			assertFalse(board.getAllFilledSets().contains(c2), "The computer chose a position already taken, c2.");
			board.placePiece('O', c2);
			assertTrue(board.getAllFilledSets().contains(c2));
		} catch (IllegalMoveException e) {
			e.printStackTrace();
		}
	}
	

}
