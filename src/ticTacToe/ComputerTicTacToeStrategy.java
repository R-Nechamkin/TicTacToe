package ticTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerTicTacToeStrategy extends ComputerStrategy {
	
	private Map<Position, Integer> priorities;
	private List<Position> corners; // holds all the corners which have not been taken yet
	private List<Position> edges; // holds all the edges which have not been taken yet
	private List<Position> center; // holds the center if it hasn't been taken yet
	
	
	public ComputerTicTacToeStrategy() {
		priorities = new HashMap<>();
		setUp();
	}

	@Override
	public Position choosePosition(TableGameBoard board) {
		// If have two in row, put down third
		// Prevent other player from putting down third
		// Work towards a double trap
		
		return null;
	}
	
	private void setUp() {
		fillCorners();
		fillEdges();
		fillCenter();
	}
	
	private void fillCorners() {
		corners = new ArrayList<>(4);
		
		corners.add(new Position('A', '1'));
		corners.add(new Position('A', '3'));
		corners.add(new Position('C', '1'));
		corners.add(new Position('C', '3'));
	}
	
	private void fillEdges() {
		edges = new ArrayList<>(4);
		
		edges.add(new Position('A', '2'));
		edges.add(new Position('B', '1'));
		edges.add(new Position('B', '3'));
		edges.add(new Position('C', '2'));
	}
	
	private void fillCenter() {
		center = new ArrayList<>(1);
		
		center.add(new Position('B', '2'));
	}

}
