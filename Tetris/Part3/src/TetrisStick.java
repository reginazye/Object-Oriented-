/**
 * tetris piece that looks like stick
 * 
 * @author ReginaYe
 *
 */

public class TetrisStick extends TetrisPiece {
	/**
	 * constructor for tetris piece shaped as "----"
	 */
	public TetrisStick() {

		filledSquares = new boolean[][][] {
				{ { false, false, false, false }, { false, false, false, false }, { true, true, true, true },
						{ false, false, false, false } },
				{ { false, false, true, false }, { false, false, true, false }, { false, false, true, false },
						{ false, false, true, false } } };
	}
}
