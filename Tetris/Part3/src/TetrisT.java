/**
 * Tetris piece that has the T shape 
 * 
 * @author ReginaYe
 *
 */
public class TetrisT extends TetrisPiece{
	/**
	 * constructor for the T-shaped tetris
	 */
	public TetrisT(){
		filledSquares = new boolean[][][]{
			{
				{false, false,false, false},
				{false, true, true, true},
				{false, false, true, false},
				{false, false, false, false}
			},{
				{false, false, true, false},
				{false, false, true, true},
				{false, false, true, false},
				{false, false, false, false}
			},{
				{false, false, true, false},
				{false, true, true, true},
				{false, false, false, false},
				{false, false, false, false}
			},{
				{false, false, true, false},
				{false, false, true, true},
				{false, false, true, false},
				{false, false, false, false}
			}
		};
	}
}
