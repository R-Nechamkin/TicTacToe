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
		GameInfo info = new TTTGameInfo(new HumanPlayer(), new ComputerPlayer(), new TicTacToeBoard());
		game = new TicTacToe(info);
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
