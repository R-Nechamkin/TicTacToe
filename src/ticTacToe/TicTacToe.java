package ticTacToe;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import exceptions.IllegalMoveException;
import general.BoardGame;
import gridGames.GameInfo;
import gridGames.GridGameBoard;
import validation.ConsoleValidation;
import validation.Validation;

public class TicTacToe implements BoardGame{
	private Deque<Player> players;
	private GridGameBoard board;
	private Validation val;
	private GameInfo info;
	
	public TicTacToe(GameInfo info) {
		players = new ArrayDeque<>();
		this.info = info;
		setUpGame();
		val = new ConsoleValidation(new Scanner(System.in));
	}
	
	@Override
	public void setUpGame() {
		this.board = info.getBoard();
		players.clear();
		players.add(info.getHuman());
		players.add(info.getComputer());
				
	}
	
	public void nextPlayerGo() throws IllegalMoveException {
		Player currPlayer = players.pop();
		char[] move = currPlayer.play();
		players.add(currPlayer);
		System.out.println(currPlayer.getName() + " has gone in the position of " + move[1] + move[2] + ".");
		System.out.println("This is the current state of the board:\n" + board);
	}

	@Override
	public String isGameOver() throws IllegalMoveException {
		if (board.isFull())
			return "NO_WINNER";
		Character winner = board.getWinner();
		if (winner == null)
			return null;
		else {
			for (Player p: players) {
				if (p.getPieceType() == winner)
					return p.getName();
			}
		}
		throw new IllegalMoveException("Something is very wrong");
	}

	@Override
	public String endGame(String winner) {
		return winner + " won the game";
		
	}

	@Override
	public List<Player> getPlayers() {
		return new ArrayList<>(players);
	}
	
	public String seeBoard() {
		return board.toString();
	}
	

	@Override
	public String startGame() {
		String winner = null;
		while (winner == null) {
			try {
				nextPlayerGo();
				winner = isGameOver();
			} catch (IllegalMoveException e) {
				System.out.println("Something went wrong.");
				if (val.askAgain("Would you like to see the error message", "see the error message" , "continue")){
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				if (val.askAgain("Would you like to try playing again", "play again" , "quit")){
					setUpGame();
					return "NO_WINNER";
				}
			}
		}
		return winner;
	}

	@Override
	public void playAgain() {
		setUpGame();
	}
	
	/**
	 * Returns the game board. Note that this method is not part of the interface.
	 * @return the board this game is playing with as a GridGameBoard
	 */
	public GridGameBoard getBoard() {
		return board;
	}

	
}
