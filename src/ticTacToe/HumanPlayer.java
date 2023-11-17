package ticTacToe;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner; // needed for the play() method which interacts directly with the user using the console

public class HumanPlayer implements Player{
	private Deque<String> pieces = new ArrayDeque<>();
	private String name;
	private Strategy strat;
	
	public HumanPlayer() {
		this("The human");
	}
	
	public HumanPlayer(String name) {
		this.name = name;
		strat = new HumanTicTacToeStrategy(new Scanner(System.in));
	}
	@Override
	public List<String> seePieces() {
		return new ArrayList<>(pieces);
	}
	
	
	/**
	 * Note that this method directly interacts with the user
	 * For this reason, it is obviously not recommended to use this method
	 * Use the other play() method instead if you can
	 */
	@Override
	public char[] play() {

		
		return new char[] {pieces.pop().charAt(0), row, col};
	}
	
	public void play(char row, int col) {
		
	}
	
	

}
