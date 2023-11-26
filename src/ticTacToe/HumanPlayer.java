package ticTacToe;

import java.util.Scanner;// needed for Strategy

import gridGames.GameInfo;


public class HumanPlayer extends Player{
	
	public HumanPlayer(GameInfo gInfo) {
		this("The human", gInfo);
	}
	
	public HumanPlayer(String name, GameInfo gInfo){
		super('X', 5, name,  new HumanTicTacToeStrategy(new Scanner(System.in), gInfo), gInfo);
	}





	
	

}
