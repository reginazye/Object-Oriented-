import javax.swing.JFrame;

/**
 * application class for ice cream maker 
 * @author ReginaYe
 *
 */
public class IceCreamMakerApplication extends JFrame{
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Ice Cream Maker by Regina Ye");
		frame.setSize(500, 600);
		//create an ice-cream controller 
		IceCreamController iceCream = new IceCreamController();
		iceCream.setFocusable(true);
		iceCream.requestFocusInWindow();
		//add an ice cream controller to the application
		frame.add(iceCream);
		frame.setVisible(true);

	}
}

