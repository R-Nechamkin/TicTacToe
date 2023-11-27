package ticTacToe;

import java.util.Scanner;// needed for Strategy

import gridGames.GameInfo;


public class HumanPlayer extends Player{
	
	public HumanPlayer(boolean first) {
		this("Human", first);
	}
	
	public HumanPlayer(String name, boolean first){
		super(name, new HumanTicTacToeStrategy(new Scanner(System.in)), first);
	}





	
	

}
