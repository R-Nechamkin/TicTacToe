package clientCode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

import exceptions.IllegalGameSetupException;
import general.BoardGame;
import gridGames.GameInfo;
import ticTacToe.ComputerPlayer;
import ticTacToe.HumanPlayer;
import ticTacToe.Player;
import ticTacToe.TTTGameInfo;
import ticTacToe.TicTacToe;
import ticTacToe.TicTacToeBoard;
import validation.*;

public class PlayTicTacToe {

	public static void main(String[] args) {
		Validation val = new ConsoleValidation(new Scanner(System.in));
		System.out.println("Let's play Tic Tac Toe!");
		System.out.println(getRules() + "\n");
		
		Queue<Player> players = new ArrayDeque<>();
		Player human = new HumanPlayer(true);
		players.add(human);
		Player computer = new ComputerPlayer(false);
		players.add(computer);
		
		int hWin = 0;
		int cWin = 0;
		int ties = 0;
		
		BoardGame game = new TicTacToe(players);
		do {
			if(val.askAgain("see the rules again", "see the rules of Tic-Tac-Toe again", "continue")) {
				System.out.println(getRules());
			}
			System.out.println(human.getName() + ", you are playing " + human.getPieceType() + " this game.\nPlay well!");
			
			game.playAgain();
			System.out.println(game.seeBoard());			
			String winner = game.playGame();
			
			System.out.println(winner + " won the game.");
			if (winner == human.getName())
				hWin ++;
			else if (winner == computer.getName())
				cWin ++;
			else
				ties ++;
		} while (val.askAgain("play another game", "play another game of Tic-Tac-Toe", "quit"));

		System.out.println("The final score is: Human: " + hWin);
		System.out.println("Computer: " + cWin);
		System.out.println("Ties/No Winners " + ties);
		System.out.println("Goodbye");
	}
	
	public static String getRules() {
		StringBuilder sb = new StringBuilder("\n");
		sb.append("In Tic-Tac-Toe, the players take turns placing pieces on the board\n");
		sb.append("'X' always goes first, 'O' always goes second. \n");
		sb.append("This might be confusing, but I did not make up the rules of the game. \n");
		sb.append("The first player to get 3 in a row (whether horizontally, vertically, or diagonally) wins.");
		return sb.toString();
	}

}
