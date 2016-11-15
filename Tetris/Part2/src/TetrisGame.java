/**
 * Tetris Game 
 * 
 * a class to manage the inputs and coordinate the game 
 * 
 * @author ReginaYe
 *
 */
public class TetrisGame{
	public static final int RIGHT =0;
	public static final int LEFT =1;
	public static final int DOWN =2;
	public static final int CW =3;
	public static final int CCW =4;
	
	private int numLines =0;
	private int numTetrises=0;
	private TetrisBoard tetrisBoard;
	
/**
 * the game constructor 
 */
	public TetrisGame(){
		tetrisBoard = new TetrisBoard();
		
	}
		
/**
 * depending on the input, make different moves
 */
	public void attemptMove(int moveType){
		if (moveType == RIGHT){
			tetrisBoard.moveRight();
		}
		if (moveType == LEFT){
			tetrisBoard.moveLeft();
		}
		if (moveType == DOWN){
			tetrisBoard.moveDown();
		}
		if (moveType == CW){
			tetrisBoard.rotateCW();
		}
		if (moveType == CCW){
			tetrisBoard.rotateCCW();
		}
		endRound();
	}

/**
 * end the round to start dropping pieces
 */
	public void endRound(){
		if (!tetrisBoard.moveDown()){
			tetrisBoard.landPiece();
			
			if (tetrisBoard.numOfFilledLine()==4){
				numLines++;
				numTetrises= numTetrises+numLines*10;
			}
			tetrisBoard.addNewPiece();
		}
		
	}

	/**
	 * to return the number of lines 
	 * @return
	 */
	public int getNumLines(){
		return numLines;
	}
	
	/**
	 * to return the number of tetrises
	 * @return
	 */
	public int getNumTetrises(){
		return numTetrises;
	}
	
	/**
	 * to get the board
	 * @return
	 */
	public TetrisBoard getTetrisBoard(){
		return tetrisBoard;
	}
	
}
