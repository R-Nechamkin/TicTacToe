package ticTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import exceptions.IllegalMoveException;
import general.BoardGame;
import gridGames.GameInfo;
import gridGames.GridGameBoard;
import playerQueue.PlayerQueue;
import validation.ConsoleValidation;
import validation.Validation;

public class TicTacToe implements BoardGame{
	private Queue<Player> players;
	private GridGameBoard board;
	private Validation val;
	private GameInfo info;
	
	public TicTacToe(GameInfo info) {
		players = new PlayerQueue<>(2);
		this.info = info;
		setUpGame();
		val = new ConsoleValidation(new Scanner(System.in));
	}
	
	/*
	 * See the interface for a description of the method
	 */
	@Override
	public void setUpGame() {
		this.board = info.getBoard();
		players.clear();
		players.add(info.getHuman());
		players.add(info.getComputer());
				
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
		if (board.isFull())
			return "NO_WINNER";
		Character winner = board.getWinner();
		if (winner == null)
			return null;
		else {
			Player p = players.remove();
			if (p.getPieceType() == winner)
					return p.getName();
			players.add(p);
			p = players.remove();
			if (p.getPieceType() == winner)
				return p.getName();
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
	
	/*
	 * See the interface for a description of the method
	 */
	public void nextPlayerGo() throws IllegalMoveException {
		Player currPlayer = players.remove();
		char[] move = currPlayer.play(board);
		players.remove(currPlayer);
		System.out.println(currPlayer.getName() + " has gone in the position of " + move[1] + move[2] + ".");
		System.out.println("This is the current state of the board:\n" + board);
	}

	/*
	 * See the interface for a description of the method
	 */
	@Override
	public void playAgain() {
		setUpGame();
	}
	


	
}
