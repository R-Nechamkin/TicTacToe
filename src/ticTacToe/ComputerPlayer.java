package ticTacToe;


public class ComputerPlayer extends Player{
	
	public ComputerPlayer(boolean first) {
		this("The computer", first);
	}

	public ComputerPlayer(String name, boolean first) {
		super(name, new ComputerTicTacToeStrategy(), first);
	}

}
