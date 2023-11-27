package ticTacToe;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import exceptions.IllegalMoveException;
import general.BoardGame;
import validation.ConsoleValidation;
import validation.Validation;

public class TicTacToe implements BoardGame{
	private Queue<Player> players;
	private TicTacToeBoard board;
	private Validation val;
	
	public TicTacToe(Queue<Player> players) {
		setUpGame(players);
		val = new ConsoleValidation(new Scanner(System.in));
	}
	
	/*
	 * See the interface for a description of the method
	 */
	@Override
	public void setUpGame(Queue<Player> oldQueue) {
		this.board = new TicTacToeBoard();

		this.players = new ArrayDeque<>(2);

		if (oldQueue.peek() instanceof HumanPlayer) {
			// if the old queue's first player is  human, we will make our first player be human
			// since we've previously determined that the first item in the queue is the human player, let's get
				// the human's name by doing oldQueue.remove()
			players.add(new HumanPlayer(oldQueue.remove().getName(), true));
			players.add(new ComputerPlayer(oldQueue.remove().getName(), false));
		}
		else {
			//otherwise, we will make our first player be the computer
			// since we've previously determined that the first item in the queue is the computer player, let's get
			// the computer's name by doing oldQueue.remove()
			players.add(new ComputerPlayer(oldQueue.remove().getName(), true));
			players.add(new HumanPlayer(oldQueue.remove().getName(), false));
		}
		
	}

	
	/*
	 * See the interface for a description of the method
	 */
	@Override
	public Player getNextPlayer() {
		Player p = players.remove();
		players.remove(p);
		return p;
	}
	
	/*
	 * See the interface for a description of the method
	 */
	@Override
	public Player pollNextPlayer() {
		return players.peek();
	}
	
	/*
	 * See the interface for a description of the method
	 */
	@Override
	public String isGameOver() throws IllegalMoveException {
		Character winner = board.getWinner();
		if (winner == null) {
			if (board.isFull()) {
				return "NO_WINNER";
			}	
			else {
				return null;
			}
		}
		else {
			for (Player p: players) {
				if (p.getPieceType() == winner)
					return p.getName();
			}
		}
		
		throw new IllegalMoveException("Something is very wrong");
	}

	/*
	 * See the interface for a description of the method
	 */
	@Override
	public String endGame(String winner) {
		return winner + " won the game";
		
	}

	/*
	 * See the interface for a description of the method
	 */
	@Override
	public List<Player> getPlayers() {
		return new ArrayList<>(players);
	}
	
	/*
	 * See the interface for a description of the method
	 */
	public String seeBoard() {
		return board.toString();
	}
	

	/*
	 * See the interface for a description of the method
	 */
	@Override
	public String playGame() {
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
					setUpGame(players);
					return "NO_WINNER";
				}
			}
		}
		return winner;
	}
	
	/*
	 * See the interface for a description of the method
	 */
	public void nextPlayerGo() throws IllegalMoveException {
		Player currPlayer = players.remove();
		char[] move = currPlayer.play(board);
		players.add(currPlayer);
		System.out.println(currPlayer.getName() + " has gone in the position of " + move[1] + move[2] + ".");
		System.out.println("This is the current state of the board:\n" + board);
	}

	/*
	 * See the interface for a description of the method
	 */
	@Override
	public void playAgain() {
		setUpGame(players);
	}
	


	
}
