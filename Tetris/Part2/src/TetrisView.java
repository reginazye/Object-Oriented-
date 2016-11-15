/**
 * Tetris view class
 * 
 * @author ReginaYe
 *
 */
public class TetrisView {

	private TetrisBoard board;

	/**
	 * constructor for the view
	 * 
	 * @param b
	 */
	public TetrisView(TetrisBoard b) {
		this.board = b;
	}

	/**
	 * return the board, which is a long string with different lines
	 * 
	 * @return
	 */
	public String getBoardString() {
		String s = "";

		for (int i = 0; i < board.getNumRows(); i++) {
			for (int j = 0; j < board.getNumCols(); j++) {
				if (board.hasBlock(i, j)) {
					s = s + "X";
				} else {
					s = s + " ";
				}
			}
			s = s + "\n";
		}
		return s;
	}
}
