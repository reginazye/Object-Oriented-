import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

/**
 * application for the ice cream shop game 
 * @author ReginaYe
 *
 */
public class IceCreamShopApplication extends JFrame{
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		//create a game frame 
		JFrame frame = new JFrame("Ice Cream Shop by Regina Ye");
		frame.setLayout(new BorderLayout());
		frame.setSize(900, 800);
		
		//new shop added 
		IceCreamShop shop = new IceCreamShop();
		shop.setFocusable(true);
		shop.requestFocusInWindow();
		frame.add(shop);
		
		//activate the game 
		frame.validate();
		frame.repaint();
		frame.setVisible(true);
		
		
				
	}
	
	
	
}
