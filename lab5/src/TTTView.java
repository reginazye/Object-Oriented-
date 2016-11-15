
public class TTTView {
	// The board object from the game
	private int[][] board;

	/**
	 * constructor initializes the board array
	 * 
	 * @param board
	 */
	public TTTView(int[][] board) {
		this.board = board;
	}

	/**
	 * Print the board to the console
	 */
	public void printBoard() {
		// loop through board and add appropriate character based on board
		// contents

		// for each board column
		for (int row = 0; row < board.length; row++) {
			// for each board row
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == 0) {
					System.out.println(" ");
				} else if (board[row][col] == 1) {
					System.out.println("X");
				} else if (board[row][col] == 2) {
					System.out.println("0");
				}

				// set the dividers
				if (col < board[row].length) {
					System.out.print("|");
				} else {
					System.out.println();
					System.out.println("-----");

				}
			}
		}

		// check if the board is occupied by player X, or player O, or neither
		// Print the correct character to the screen depending on the contents
		// of the square
		// System.out.print("stuff") will print things on the same row

		// System.out.print("/n") or System.out.println() will print a new line
		// Don't forget to add in the grid lines!
	}
}
