package ticTacToe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.IllegalGameSetupException;
import gridGames.GameInfo;

class TTTGameInfoTest {

	@Test
	void ClassCanBeConstructed() throws IllegalGameSetupException {
		GameInfo info = null;
		info = new TTTGameInfo(new HumanPlayer(), new ComputerPlayer(), new TicTacToeBoard());
		assertNotNull(info);
	}
	

}
