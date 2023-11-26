package ticTacToe;

import exceptions.IllegalGameSetupException;
import gridGames.GameInfo;
import gridGames.GridGameBoard;

/**
 * This class contains the info about the game
 * @author rnech
 *
 */
public class TTTGameInfo implements GameInfo{
	
	private Player human;
	private Player computer;
	private TicTacToeBoard board;
	
	/**
	 * @param p1
	 * @param p2
	 * @param board
	 * @throws IllegalGameSetupException 
	 */
	public TTTGameInfo(Player p1, Player p2, GridGameBoard board) throws IllegalGameSetupException {
		if (!(p1 instanceof HumanPlayer && p2 instanceof ComputerPlayer)) {
			throw new IllegalGameSetupException
			("This version of Tic-Tac-Toe requires the first player to be human and the second player to be a computer");
		}
		this.human = p1;
		this.computer = p2;
		this.board = (TicTacToeBoard) board;
	}
	
	/**
	 * This is a dummy constructor
	 */
	public TTTGameInfo() {
		
	}

	/**
	 * @return the p1
	 */
	@Override
	public Player getHuman() {
		return human;
	}

	/**
	 * @return the p2
	 */
	@Override
	public Player getComputer() {
		return computer;
	}

	/**
	 * @return the board
	 */
	@Override
	public TicTacToeBoard getBoard() {
		return board;
	}
	
	

}
