package ticTacToe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.IllegalGameSetupException;
import general.BoardGame;
import gridGames.GameInfo;

class TicTacToeTest {
	static BoardGame game;
	
	@BeforeEach
	void setUp() throws IllegalGameSetupException {
		GameInfo info = null;
		game = new TicTacToe(info);
	}
	@Test
	void ConstructorSetsUpBoardAndPlayers() {
		TicTacToe tGame = (TicTacToe) game;
		assertNotEquals(tGame.getBoard(), null, "Board was not created.");
		List<Player> players = game.getPlayers();
		assertNotEquals(players.get(0), null, "Player 1 was not created.");
		assertNotEquals(players.get(1), null, "Player 2 was not created.");
	}
	
	@Test
	void NextPlayerGoWorks() {
		Player p1 = game.getPlayers().get(0);
		Player p2 = game.getPlayers().get(1);
	}

}
