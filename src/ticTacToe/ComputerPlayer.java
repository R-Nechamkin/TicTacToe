package ticTacToe;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer extends Player{
	
	private char pieceType = 'O';
	private int numPieces = 4;
	private String name;
	
	public ComputerPlayer() {
		this("The computer");
	}

	public ComputerPlayer(String name) {
		super('O', 4, name, new ComputerTicTacToeStrategy());
	}

}
