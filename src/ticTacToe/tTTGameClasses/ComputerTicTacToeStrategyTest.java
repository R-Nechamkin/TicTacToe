package tTTGameClasses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.IllegalMoveException;
import gridGames.GameInfo;
import gridGames.Position;

class ComputerTicTacToeStrategyTest {

	@Test
	void UpdatePrioritiesWorks() {
		TicTacToeBoard board = new TicTacToeBoard();
		
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
