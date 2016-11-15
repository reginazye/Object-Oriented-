/**
 * tetris piece that looks like "Z"
 * 
 * @author ReginaYe
 *
 */
public class TetrisS2 extends TetrisPiece {
	/**
	 * constructor for tetris Z
	 */
	public TetrisS2() {
		filledSquares = new boolean[][][] {
				{ { true, true, false, false }, { false, true, true, false }, { false, false, false, false },
						{ false, false, false, false } },
				{ { false, false, true, false }, { false, true, true, false }, { false, true, false, false },
						{ false, false, false, false } },
				{ { true, true, false, false }, { false, true, true, false }, { false, false, false, false },
							{ false, false, false, false } },
					{ { false, false, true, false }, { false, true, true, false }, { false, true, false, false },
							{ false, false, false, false } }};
	}
}
