package gridGames;

/**
 * This class stores the position and piece of a cell
 * The piece is stored as a {@code Character} to allow nulls to be stored
 * The position is stored as a {@code Position}
 * @author rnech
 *
 */
public class Cell {
	private Position pos;
	private Character piece;
	
	public Cell(Position p, Character piece) {
		this.pos = p;
		this.piece = piece;
	}
	
	/**
	 * Returns the {@code Position} of a cell
	 * @return
	 */
	public Position getPosition() {
		return this.pos;
	}
	
	/**
	 * Returns the {@code Character} name of the piece
	 * Note that the piece is allowed to be {@code null}
	 * @return a {@code Character} representing the piece in the cell
	 */
	public char getPieceName() {
		return this.piece;
	}

}
