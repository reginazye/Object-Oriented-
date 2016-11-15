import javax.swing.*;
import java.awt.event.*;


public class Game extends JFrame implements ActionListener, KeyListener{
	

/**
 * constructor, create new instances of the shape and the board Ï
 * then add them to the main application
 */
	public Game(){
		Board a = new Board();
		Shape b = new Shape();
	}
	
/**
 * start playing the game
 * @param args
 */
	public static void main(String[] args){
		new Game();
	}
	
	
/**
 * press the according key to make changes 
 */
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		/**
		 * arrow keys to move the shape;
		 * z, x to rotate the shape
		 */
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		
}
