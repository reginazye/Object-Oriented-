
public class TetrisL2 extends TetrisPiece {
	public TetrisL2() {
		/**
		 * four kinds of rotation then 2d arrays to hold the shape "L-piece"
		 */
		filledSquares = new boolean[][][] {
				{ 
					{ true, true, true, false }, 
					{ false, false, true, false }, 
					{ false, false, false, false },
					{ false, false, false, false } 
				},
				{ 
					{ true, true, false, false }, 
					{ true, false, false, false }, 
					{ true, false, false, false },
					{ false, false, false, false } 
					},
				{ 
					{false, false, false, false }, 
					{ true, false, false, false }, 
					{ true, true, true, false },
					{ false, false, false, false } 
					},
				{ 
					{false, false, true, false },
					{ false, false, true, false }, 
					{ false, true, true, false },
					{false, false, false, false } } };
	}

}

