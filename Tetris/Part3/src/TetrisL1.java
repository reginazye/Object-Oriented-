/**
 * Tetris piece that looks like L
 * 
 * @author ReginaYe
 *
 */
public class TetrisL1 extends TetrisPiece {

	public TetrisL1() {
		/**
		 * four kinds of rotation then 2d arrays to hold the shape "L-piece"
		 */
		filledSquares = new boolean[][][] {
				{ { true, true, true, false }, { true, false, false, false }, { false, false, false, false },
						{ false, false, false, false } },
				{ { true, false, false, false }, { true, false, false, false }, { true, false, false, false },
						{ true, true, false, false } },
				{ { false, false, false, false }, { false, false, true, false }, { true, true, true, false },
						{ false, false, false, false } },
				{ { false, true, true, false }, { false, false, true, false }, { false, false, true, false },
						{ false, false, false, false } } };
	}

}
