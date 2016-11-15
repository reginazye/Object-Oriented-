import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TetrisGameGUIApplication extends JFrame{
	
	public static void main(String[] args)
	{
										JFrame frame = new JFrame("Tetris Game by Regina Ye");
					frame.setLayout(new BorderLayout());
					frame.setVisible(true);
					frame.setSize(1000,900);
					frame.add(new TetrisGameGUIController(), BorderLayout.CENTER);
				}
		
	}

