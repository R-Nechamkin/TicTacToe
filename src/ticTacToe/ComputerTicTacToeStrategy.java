package ticTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import exceptions.IllegalGameSetupException;
import exceptions.IllegalMoveException;

import java.util.HashSet;
import java.util.LinkedList;

import general.*;
import gridGames.*;

public class ComputerTicTacToeStrategy extends ComputerStrategy {
	private GameInfo gameDetails;
	private char myPiece = 'O'; 
	private char humanPiece = 'X';
	
	private Map<Position, Integer> priorities;
	private static final Position[] CORNERS = 
		{new TTTPosition('A', '1'), new TTTPosition('A', '3'), new TTTPosition('C', '1'), new TTTPosition('C', '3')};
	private static final Position[] EDGES =
		{new TTTPosition('A', '2'), new TTTPosition('B', '1'), new TTTPosition('B', '3'), new TTTPosition('C', '2')};
	private static final Position CENTER = new TTTPosition('B', '2');
	private static final Position[][] WINS = TicTacToeBoard.getWinningRows();

		
	public ComputerTicTacToeStrategy(GameInfo gInfo) {
		priorities = new HashMap<>();
		setUp();
		this.gameDetails = gInfo;
	}

	@Override
	public Position choosePosition() throws IllegalMoveException {
		updatePriorities();
		// If have two in row, put down third
		Position p = placeThirdInRow();
		if (p != null)
			return p;
		// Prevent other player from putting down third
		p = stopHumanThreeInRow();
		if (p != null)
			return p;
		// Place the most strategic piece	
		return placeOther();
	}
	
	private void setUp() {
		priorities.put(CENTER, 2);
		for (Position p: CORNERS) {
			priorities.put(p, 3);
		}
		for (Position p: EDGES) {
			priorities.put(p, 1);
		}	
	}
	
	/**
	 * This method finds if the computer has the option to place three in a row this turn
	 * @return the position of that third 
	 * @throws IllegalMoveException
	 */
	private Position placeThirdInRow() throws IllegalMoveException {
		for (Position[] row: WINS) {
			Position p = twoInRow(row, myPiece); 
			if (p != null) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * This method finds if the human has two in a row
	 * @return the Position in which the computer should place a piece to block the human from winning
	 * @throws IllegalMoveException
	 */
	private Position stopHumanThreeInRow() throws IllegalMoveException{
		for (Position[] row: WINS) {
			Position p = twoInRow(row, humanPiece); 
			if (p != null) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * This method finds if there are two of a player in a given row and a third empty position on the same board
	 * @param row A Position[] which represents a set of three Positions on the board.
	 * 	This can be a literal row, a column, or a diagonal.	 
	 * @param piece the player's piece
	 * @param other the piece of the other player
	 * @return the position of the 
	 * @throws IllegalMoveException
	 */
	private Position twoInRow(Position[] row, char piece) throws IllegalMoveException  {
		int count = 0;
		Position third = null;
		for (Position p: row) {
			if (gameDetails.getBoard().getPiece(p) == null) {
				third = p;
			}
			else if (gameDetails.getBoard().getPiece(p) == piece) {
				count++;
			}
			else{
				return null;
			}
		}
		if (count == 2) {
			return third;
		}
		if (count == 3) {
			throw new IllegalMoveException("Something is very wrong. "
					+ "\nThe computer found in the middle of its turn that " + piece + " has already won");
		}
		return null;
	}
	
	/**
	 * This method returns the Position which the computer should place a key in if 
	 *  neither it nor the human has two-in-a-row
	 * @return the Position which has not yet been filled with the max priority
	 */
	private Position placeOther() {
		return max(priorities);
	}
	
	/**
	 * This method removes from the map of priorities any position which has already been filled
	 */
	public void updatePriorities() {
		TTTGameInfo gInfo = (TTTGameInfo) gameDetails;
		for (Position p: gInfo.getBoard().getAllFilledSets()) {
			priorities.remove(p);
		}
	}
	
    /**
     * This method returns the key of a HashMap which has the greatest value associated with it
     * 	If there are multiple keys with the same value, it returns the first such key
     * @param map
     * @return
     */
    private Position max (Map<Position,Integer> map) {
    	// We need to create a List of the keys so that we make sure maxKey is some key
    	// If we just set maxKey to null, we'll run into a problem if no key has maxPriority
    	List<Position> keyArray = new ArrayList<>(map.keySet());
    	Position maxKey = keyArray.get(0);
    	int maxValue = Integer.MIN_VALUE;
    	for (Position p: keyArray) {
    		if (map.get(p) > maxValue) {
    			maxValue = map.get(p);
    			maxKey = p;
    		}
    	}
    	return maxKey;
    }

	/**
	 * @return the gameDetails
	 */
	public GameInfo getGameDetails() {
		return gameDetails;
	}


}
