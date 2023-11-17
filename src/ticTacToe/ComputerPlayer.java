package ticTacToe;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer implements Player{
	
	private List<String> pieces = new ArrayList<>();
	private String name;
	
	public ComputerPlayer() {
		this("The computer");
	}
	
	public ComputerPlayer(String name) {
		this.name = name;
	}
	
	public List<String> seePieces(){
		return new ArrayList<>(pieces);
	}

	@Override
	public char[] play() {
		// TODO Auto-generated method stub
		return null;
	}
}
