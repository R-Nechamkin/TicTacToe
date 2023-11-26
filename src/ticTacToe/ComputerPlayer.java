package ticTacToe;

import gridGames.GameInfo;

public class ComputerPlayer extends Player{
	
	public ComputerPlayer(GameInfo gInfo) {
		this("The computer", gInfo);
	}

	public ComputerPlayer(String name, GameInfo gInfo) {
		super('O', 4, name, new ComputerTicTacToeStrategy(gInfo), gInfo);
	}

}
