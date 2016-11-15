
public class TetrisSquare extends TetrisPiece {
	/**
	 * constructor for tetris that looks like square
	 */
	public TetrisSquare() {
		filledSquares = new boolean[][][] { { { false, false, false, false }, { false, true, true, false },
				{ false, true, true, false }, { false, false, false, false } } };
	}

}
