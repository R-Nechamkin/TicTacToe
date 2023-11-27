package ticTacToe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.IllegalGameSetupException;
import general.BoardGame;

class TicTacToeTest {
	static BoardGame game;
	
	@BeforeEach
	void setUp() throws IllegalGameSetupException {
		Queue<Player> p = new ArrayDeque<>(2);
		p.add(new HumanPlayer(true));
		p.add(new ComputerPlayer(false));
		game = new TicTacToe(p);
	}
	@Test
	void ConstructorSetsUpBoardAndPlayers() {
		TicTacToe tGame = (TicTacToe) game;
		assertNotNull(tGame.seeBoard(), "Board was not created.");
		List<Player> players = game.getPlayers();
		assertNotNull(players.get(0), "Player 1 was not created.");
		assertNotNull(players.get(1), "Player 2 was not created.");
	}


}
