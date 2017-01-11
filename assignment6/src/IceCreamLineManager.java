import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Ice Cream Line Manager
 * @author ReginaYe
 *
 */
public class IceCreamLineManager extends JPanel implements ActionListener{
	
	private IceCreamLine line;
	private JButton orderBtn;
	
	/**
	 * constructor for ice cream line manager class 
	 */
	public IceCreamLineManager(){
		super(new BorderLayout());
		line = new IceCreamLine();
		createNewOrderButton();
		add(orderBtn, BorderLayout.NORTH);
		add(line, BorderLayout.CENTER);
	}
	
	/**
	 * create the add order button 
	 */
	public void createNewOrderButton(){
		orderBtn = new JButton("Add a random order");
		orderBtn.addActionListener(this);
		
	}
	
	/**
	 * @return the ice cream line 
	 */
	public IceCreamLine getLine(){
		return line;
	}
	
	/**
	 * what happens when the buttons are clicked 
	 */
	public void actionPerformed(ActionEvent e) {
		//if clicking the add a new order button 
		if (e.getSource()==orderBtn){
			//add a random order to the line 
			line.addRandomOrder();
		}
		repaint();
	}	
}
