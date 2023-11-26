package ticTacToe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.IllegalGameSetupException;
import gridGames.GameInfo;

class TTTGameInfoTest {

	@Test
	void ClassCanBeConstructed() throws IllegalGameSetupException {
		GameInfo info = null;
		info = new TTTGameInfo(new HumanPlayer(info), new ComputerPlayer(info), new TicTacToeBoard());
		assertNotNull(info);
	}
	
	@Test
	void OtherClassesCanUseThisClass() throws IllegalGameSetupException {
		GameInfo temp = new TTTGameInfo();
		GameInfo info = new TTTGameInfo(new HumanPlayer(temp), new ComputerPlayer(temp), new TicTacToeBoard());
		temp =info;
	//	assertNotNull(human.getGameDetails());
		Player human = new HumanPlayer(info);
		Player computer = new ComputerPlayer(info);
		assertNotNull(info.getHuman().getGameDetails());


	}

}
