import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TetrisGameGUIController extends JComponent implements KeyListener, ActionListener{
	public static final int DEFAULT_DROP_RATE = 400;
	private TetrisGame game=new TetrisGame();;
	private TetrisBoardGUIView view;
	private JLabel linesLabel;
	private JLabel tetrisesLabel;
	private JButton quitButton;
	private JPanel scoreBoard;
	private Timer gameTimer;
	private int dropRate = 400;
	
	public TetrisGameGUIController(){
		
		createView();
		createScore();
		refreshDisplay();
	}
	
	private void setupTimer(){
		gameTimer = new Timer(dropRate,this);
	}
	
	private void createView(){
		view = new TetrisBoardGUIView(game.getTetrisBoard());
		view.setSize(500, 900);
		add(view);
	}
	
	private void createScore(){
		linesLabel = new JLabel ("You have canceled" + 0 +"lines");
		tetrisesLabel = new JLabel ("You have canceled"+0+"Tetrises");
		scoreBoard = new JPanel();
		scoreBoard.setLayout(new GridLayout(2,1));
		scoreBoard.add(linesLabel);
		scoreBoard.add(tetrisesLabel);
	}
	
	public JPanel getScore(){
		return scoreBoard;
	}
	
	public void refreshDisplay(){
		linesLabel = new JLabel (game.getNumLines()+"");
		tetrisesLabel = new JLabel (game.getNumTetrises()+"");
		repaint();
	}	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==quitButton){
			System.exit(0);
		}
	}

	public void keyTyped(KeyEvent e) {
			
	}

	public void keyPressed(KeyEvent e) {
		
		System.out.println("kjlfghalfkg");

		int key = e.getKeyCode();
		switch (key){
		case KeyEvent.VK_DOWN:
			game.attemptMove(2);
			break;
		case KeyEvent.VK_UP:
			game.attemptMove(3);
			break;
		case KeyEvent.VK_LEFT:
			game.attemptMove(1);
			break;
		case KeyEvent.VK_RIGHT:
			game.attemptMove(0);
			break;	
		default:
			break;
		}
		repaint();
	}

	
	public void keyReleased(KeyEvent e) {
	
	}
	
}
