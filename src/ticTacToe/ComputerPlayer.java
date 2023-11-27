package ticTacToe;


public class ComputerPlayer extends Player{
	
	public ComputerPlayer() {
		this("The computer");
	}

	public ComputerPlayer(String name) {
		super('O', 4, name, new ComputerTicTacToeStrategy());
	}

}
