package tTTGameClasses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gridGames.Position;

class TTTPositionTest {

	/**
	 * Tests that a Position object created using the string constructor is equal to 
	 * 	a Position object created using the char constructor
	 */
	@Test
	void StringConstructorWorks() {
		Position p1 = new TTTPosition("A1");
		Position p2 = new TTTPosition('A', '1');
		assertEquals(p1, p2);
	}
	
	@Test
	void IntConstructorWorks() {
		Position p1 = new TTTPosition(0,0);
		Position p2 = new TTTPosition('A', '1');
		assertEquals(p1, p2);
	}
	
	@Test
	void GetRowNamesWorks() {
		char[] rows = {'A', 'B', 'C'};
		assertArrayEquals(TTTPosition.getRowNames(), rows, TTTPosition.getRowNames().toString());
	}

}
