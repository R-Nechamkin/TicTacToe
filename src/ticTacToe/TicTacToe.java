package ticTacToe;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TicTacToe implements BoardGame{
	private Deque<Player> players;
	private TableGameBoard board;
	
	public TicTacToe() {
		players = new ArrayDeque<>();
		setUpGame();
	}
	
	public TicTacToe(Player player1, Player player2) throws IllegalGameSetupException {
		// Check that there is one human player and one computer player
		if (!(player1 instanceof HumanPlayer && player2 instanceof ComputerPlayer) || 
				!(player1 instanceof ComputerPlayer && player2 instanceof HumanPlayer)){
			throw new IllegalGameSetupException("I'm sorry; this game is intended for one human player and one computer player.");
		}
		players = new ArrayDeque<>();
		players.add(player1);
		players.add(player2);
		
		board = new TicTacToeBoard();
	}
	
	/**
	 * Sets up a new game
	 * This method should be used either when the old 
	 */
	@Override
	public void setUpGame() {
		board = new TicTacToeBoard();
		players.clear();
		players.add(new HumanPlayer());
		players.add(new ComputerPlayer());
				
	}
	
	public void nextPlayerGo() {
		Player currPlayer = players.pop();
		currPlayer.play();
		players.add(currPlayer);
		System.out.println("This is the current state of the board:\n" + board);
	}

	@Override
	public boolean isGameOver() {
		return board.isFull();
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

	
}
