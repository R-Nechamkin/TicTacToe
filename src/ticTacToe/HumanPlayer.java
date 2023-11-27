package ticTacToe;

import java.util.Scanner;// needed for Strategy

import gridGames.GameInfo;


public class HumanPlayer extends Player{
	
	public HumanPlayer() {
		this("The human");
	}
	
	public HumanPlayer(String name){
		super('X', 5, name,  new HumanTicTacToeStrategy(new Scanner(System.in)));
	}





	
	

}
