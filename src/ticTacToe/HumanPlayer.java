package ticTacToe;

import java.util.Scanner; // needed for Strategy

public class HumanPlayer extends Player{
	private char pieceType = 'X';
	private int numPieces = 5;
	private String name;
	
	public HumanPlayer() {
		this("The human");
	}
	
	public HumanPlayer(String name) {
		super('X', 5, name,  new HumanTicTacToeStrategy(new Scanner(System.in)));
	}





	
	

}
