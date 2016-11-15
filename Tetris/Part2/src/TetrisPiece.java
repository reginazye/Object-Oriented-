/**
 * the model for all the specific shaped tetris pieces
 * 
 * @author ReginaYe
 *
 */
public class TetrisPiece {

	public boolean[][][] filledSquares;
	public int pieceRotation;

	/**
	 * general Tetris Piece constructor, empty by default
	 * 
	 */
	public TetrisPiece() {
		filledSquares = new boolean[][][] { { { false, false, false, false }, { false, false, false, false },
				{ false, false, false, false }, { false, false, false, false } } };
		pieceRotation = 0;
	}

	/**
	 * rotate the piece clockwise
	 */
	public void rotateCW() {
		pieceRotation++;

		if (pieceRotation > 3) {
			pieceRotation = 0;
		}
	}

	/**
	 * rotate the piece counter-clockwise
	 */
	public void rotateCCW() {
		pieceRotation--;

		if (pieceRotation < 0) {
			pieceRotation = 3;
		}
	}

	/**
	 * get the piece's rotation index
	 * 
	 * @return
	 */
	public int getPieceRotation() {
		return pieceRotation;

	}

	/**
	 * to check if a block is filled inside a tetris matrix
	 * 
	 * @param rot
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isFilled(int rot, int row, int col) {
		rot = pieceRotation;
		return filledSquares[rot][row][col];
	}

}
