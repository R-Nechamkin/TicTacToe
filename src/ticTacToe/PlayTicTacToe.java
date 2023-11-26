package ticTacToe;

import java.util.Scanner;

import exceptions.IllegalGameSetupException;
import general.BoardGame;
import gridGames.GameInfo;
import validation.*;

public class PlayTicTacToe {

	public static void main(String[] args) {
		Validation val = new ConsoleValidation(new Scanner(System.in));
		
		try {
			GameInfo gInfo;
			gInfo = new TTTGameInfo(new HumanPlayer(gInfo), new ComputerPlayer(gInfo), new TicTacToeBoard());
			
			BoardGame game = new TicTacToe(gInfo);
			do {
				game.setUpGame();
				System.out.println(game.seeBoard());
				String winner = game.startGame();
				System.out.println(winner + " won the game.");
			} while (val.askAgain("play another game", "play another game of Tic-Tac-Toe", "quit"));
		} catch (IllegalGameSetupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("Goodbye");
	}

}
