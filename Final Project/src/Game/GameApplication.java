package Game;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Game Application class
 * 
 * @author ReginaYe
 *
 */
public class GameApplication extends JFrame {
	public static void main(String[] args) {
		//create and add the game 
		JFrame frame = new JFrame("20Q by Regina Ye");
		frame.setSize(1200, 900);
		frame.setLayout(new BorderLayout());
		frame.add(new GameController(), BorderLayout.CENTER);
		frame.setVisible(true);
	}

}
