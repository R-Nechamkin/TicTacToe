package ticTacToe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.IllegalGameSetupException;
import exceptions.IllegalMoveException;
import gridGames.GameInfo;
import gridGames.GridGameBoard;

/**
 * This class is intended to test the Player class
 * @author rnech
 *
 */
class PlayerTest {
	static Player human;
	static GridGameBoard board;
	
	/**
	 * Sets up the human player which will be used to play
	 */
	@BeforeEach
	void setUp(){
		human = new HumanPlayer();
		board = new TicTacToeBoard();
	}
	
	@Test
	void OneLessPieceAfterPlayMethodIsCalled() {
		int startPieces = human.getNumPieces(); 
		try {
			human.play(new TTTPosition('A', '1'), board);
		} catch (IllegalMoveException e) {
			fail("Placing a piece in position A1 threw an IllegalMoveException\n" + e.getStackTrace());
		}
		assertEquals(startPieces - 1, human.getNumPieces());
	}
	
	@Test
	void PlayMethodReturnsProperDescriptionOfMove() throws IllegalArgumentException, IllegalMoveException {
		char[] move = {'X', 'A', '1'};
		char[] result = human.play(new TTTPosition('A', '1'), board);
		assertArrayEquals(move, result);
	}

}
