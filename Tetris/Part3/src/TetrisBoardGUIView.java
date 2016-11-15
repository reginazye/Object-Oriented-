import java.awt.Graphics;
import javax.swing.JPanel;


public class TetrisBoardGUIView extends JPanel{
	
	public TetrisBoard board;
	
	public TetrisBoardGUIView(TetrisBoard b){
		this.board = b;
	}
	
	public void paint(Graphics g){
		paintBoardOutline(g, computeBlockSize());
		for (int i=0; i<board.getNumRows(); i++){
			for (int j=0;j<board.getNumCols();j++){
				paintBlock(g,i, j, computeBlockSize());
			}
		}
	}
	
	private void paintBoardOutline(Graphics g, int blockSize){
		g.drawRect(0, 0, blockSize*board.getNumCols(), blockSize*board.getNumRows());
		
	}
	
	private void paintBlock(Graphics g, int row, int col, int blockSize){
				if (board.hasBlock(row,col)==true){
					g.fillRect(blockSize*row, blockSize*col, blockSize, blockSize);
				}			
		}
		
	private int computeBlockSize(){
		int width = this.getWidth()/10;
		return width;
	}
}
