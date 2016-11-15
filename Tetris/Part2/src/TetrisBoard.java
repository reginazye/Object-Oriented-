/**
 * TetrisBoard
 * the board that the game is played on 
 * 
 * @author ReginaYe
 *
 */
		
public class TetrisBoard {
	/**
	 * all the variables needed in the class
	 * 
	 */
	public final int NUM_ROWS = 18;
	public final int NUM_COLS = 10;	
	public int numCol =10;
	public int numRow =18;
	public boolean[][] blockMatrix; 
	public TetrisPiece currentPiece;
	public int[] currentPieceGP;
	
	/**
	 * the board constructor
	 */
	public TetrisBoard(){
		//create a new boolean matrix that is size of the board
		blockMatrix = new boolean[NUM_ROWS][NUM_COLS];
		//start the game by starting the board, piece
		initBoard();
		initCurrentGP();
		addNewPiece();
	}
	
	/**
	 * initialize an array to hold 
	 * the location of the current tetris piece
	 */
	public void initCurrentGP(){
		currentPieceGP = new int[]{0, 2};
	}
	
	/**
	 * initialize the game board 
	 */
	public void initBoard(){
		System.out.println("-------------------");
		for (int i=0;i<NUM_ROWS; i++){
			for (int j=0; j<NUM_COLS;j++){
				blockMatrix[i][j] = false;
				System.out.print(" ");
			}
		}	
		System.out.println("-------------------");
	}
	
	/**
	 * a function to make sure a piece has landed
	 * 
	 */
	public void landPiece(){
		for(int i=0; i<4; i++){
			for (int j=0; j<4; j++){
				if (currentPiece.isFilled(currentPiece.getPieceRotation(), i, j)){
					blockMatrix[currentPieceGP[0]+i][currentPieceGP[1]+j]=true;
					System.out.println("kfjg");
				}
			}
		}
		//if the piece has landed, now move on to a new piece
		addNewPiece();
	}
	
	/**
	 * a function to move the tetris piece to the left 
	 * @return
	 */
	public boolean moveLeft(){
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGP[0], currentPieceGP[1]-1)){
			currentPieceGP[1]-=1;
			return true;
		}
			return false;
	}
	
	/**
	 * a function to move the tetris piece to the right
	 * @return
	 */
	public boolean moveRight(){	

			if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGP[0], currentPieceGP[1]+1)){
				currentPieceGP[1]+=1;
				return true;
			}
			return false;
	}
	
	/**
	 * a function to move the tetris piece down
	 * @return
	 */
	public boolean moveDown(){
		if(validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGP[0]+1, currentPieceGP[1])){
			currentPieceGP[0]+=1;
			return true;
		}
		return false;
	}
	
	/**
	 * a function to rotate the current tetris piece clockwise 
	 * @return
	 */
	public boolean rotateCW(){
		boolean valid = validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGP[0], currentPieceGP[1]+1);
		if (valid){
			currentPiece.rotateCW();
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * a function to rotate the current piece counter-clockwise
	 * @return
	 */
	public boolean rotateCCW(){

		boolean valid = validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGP[0], currentPieceGP[1]+1);
		if (valid){
			currentPiece.rotateCCW();
		}
		return true;
	}
	
	/**
	 * detect if there is a collision 
	 * so the pieces are not on top of each other
	 * 
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return
	 */
	public boolean Collision(TetrisPiece piece, int rot, int gridRow, int gridCol){
		if (currentPiece!=null){
			piece = currentPiece;
		}
		for (int i=0; i<4; i++){
			for (int j=0; j<4;j++){
				
				if (piece.isFilled(rot, i, j) && blockMatrix[gridRow+i][gridCol+j]){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * detect if the pieces are out of bounds
	 * 
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return
	 */
	public boolean OutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol){
		if (currentPiece!=null){
			piece = currentPiece;	
		}
		//loop through the tetris piece matrix to check the blocks
		for (int i=0; i<4; i++){
			for (int j=0;j<4;j++){
				System.out.println(rot+","+i+","+j);
				if (piece.isFilled(rot, i, j)){
					if (gridRow+i >= NUM_ROWS 
							|| gridCol+j>=NUM_COLS 
							|| gridCol+j<0){
						return true;
				}
				}
			}
		}
		return false;
	}
	
	/**
	 * see if the move is valid 
	 * by checking if the move is out of bounds 
	 * and if the move has a potential collision with other pieces
	 * 
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return
	 */
	public boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol){
		if (
		!OutOfBounds(currentPiece, rot, gridRow, gridCol)
				&&!Collision(currentPiece, rot, gridRow, gridCol)){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * see what part of the board has block on it
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean hasBlock(int row, int col){
		for (int i=0; i<4; i++){
			for (int j=0; j<4; j++){
				if (currentPiece.isFilled(currentPiece.getPieceRotation(), i, j)&&
						currentPieceGP[0]+i==row && currentPieceGP[1]+j==col){
					return true;
				}
			}
		} 
		return blockMatrix[row][col];
	}

	/**
	 * get the new piece randomly 
	 */
	public void addNewPiece(){
		int idx = (int)(Math.random()*7);
		switch (idx){
		case 1: currentPiece = new TetrisL1();
		break;
		case 2: currentPiece = new TetrisS1();
		break;
		case 3: currentPiece = new TetrisS2();
		break;
		case 4: currentPiece = new TetrisSquare();
		break;
		case 5: currentPiece = new TetrisStick();
		break;
		case 6: currentPiece = new TetrisT();
		break;
		case 7: currentPiece = new TetrisL2();
		}
		initCurrentGP();
	}
		
	/**
	 * see if the line is full
	 * @param row
	 * @return
	 */
	public boolean fullLine(int row){
		int fullRow = 0;
		
		for (int i=0; i<NUM_COLS; i++){
			if (blockMatrix[row][i]){
				fullRow++;
			}
		}
		if (fullRow == numCol){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * remove the line when filled 
	 * @param row
	 */
	public void removeLine(int row){
		System.out.println("remove Line");
		while (row > 0){
		for(int i=0; i<NUM_COLS; i++){
			blockMatrix[row][i]=blockMatrix[row-1][i];
		}
		row--;
		}
	}
	
	/**
	 * the number of lines filled 
	 * @return the lines filled
	 */
	public int numOfFilledLine(){
			int line = 0;
		for (int i=0; i<NUM_ROWS; i++){
			if (fullLine(i)==true){
				line++;
			}
		}
		return line;
	}
	
	/**
	 * get the board matrix
	 * @return
	 */
	public boolean[][] getBlockMatrix(){
		return blockMatrix;
	}
	
	/**
	 * get the current piece 
	 * @return
	 */
	public TetrisPiece getCurrentPiece(){
		return currentPiece;
	}
	
	/**
	 * get the current piece's position
	 * @return
	 */
	public int[] getCurrentPieceGridPosition(){
		return currentPieceGP;
	}
	
	/**
	 * get the board's number of columns 
	 * @return
	 */
	public int getNumCols(){
		return numCol;
	}
	
	/**
	 * get the board's number of rows
	 * @return
	 */
	public int getNumRows(){
		return numRow;
	}
	
}
	
	
	
	

