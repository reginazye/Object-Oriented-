import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * the controller class for the ice cream application
 * @author ReginaYe
 *
 */
public class IceCreamController extends JPanel implements ActionListener{
	private IceCreamCone cone = new IceCreamCone();
	private IceCreamConeView coneView = new IceCreamConeView(cone);
	private JButton[] flavorBtns =  new JButton[4];
	private JButton trashButton;
	
	/**
	 * constructor of the controller class 
	 */
	public IceCreamController(){
		super(new BorderLayout());
		//add the menu 
		add(createFlavorMenu(), BorderLayout.NORTH);
		//add the cone view 
		add(coneView, BorderLayout.CENTER);
	}
	
	/**
	 * refresh display method 
	 */
	public void refreshDisplay(){
		repaint();
	}
	
	/**
	 * create flavor menu
	 * 
	 * @return menu panel
	 */
	private JPanel createFlavorMenu(){
		JPanel flavors = new JPanel(new FlowLayout());
		//create the strawberry button 
		flavorBtns[0] = new JButton("Stawberry");
		flavorBtns[0].setBackground(Color.pink);
		flavorBtns[0].setOpaque(true);
		flavorBtns[0].addActionListener(this);
		
		//create the green tea button
		flavorBtns[1] = new JButton("Green Tea");
		flavorBtns[1].setBackground(Color.green);
		flavorBtns[1].setOpaque(true);
		flavorBtns[1].addActionListener(this);

		//create the caramel button
		flavorBtns[2] = new JButton("Burnt Caramel");
		flavorBtns[2].setBackground(Color.orange);
		flavorBtns[2].setOpaque(true);
		flavorBtns[2].addActionListener(this);

		//create the raspberry button
		flavorBtns[3] = new JButton("Raspberry");
		flavorBtns[3].setBackground(Color.magenta);
		flavorBtns[3].setOpaque(true);
		flavorBtns[3].addActionListener(this);

		//add the flavor buttons to the panel
		for (int i=0; i<flavorBtns.length; i++){
			flavors.add(flavorBtns[i]);
		}
		
		//create the eat button
		trashButton = new JButton("Trash (or eat) the top scoop!");
		trashButton.addActionListener(this);
		trashButton.setBackground(Color.blue);
		trashButton.setOpaque(true);
		
		//add the menu on top of view
		JPanel menu = new JPanel(new BorderLayout());
		menu.add(flavors, BorderLayout.NORTH);
		menu.add(trashButton, BorderLayout.SOUTH);
		
		//return the flavor panel
		return menu;
	}
	
		/**
		 * activate the buttons 
		 * define the events 
		 */
	public void actionPerformed(ActionEvent e){
		//if clicking the strawberry button
		if (e.getSource() == flavorBtns[0]){
			//add a strawberry scoop
			cone.addScoop("Strawberry");
		}
		//if clicking the green tea button
		if (e.getSource() == flavorBtns[1]){
			//add a green-tea scoop
			cone.addScoop("Green Tea");
		}
		//if clicking the burnt caramel button
		if (e.getSource() == flavorBtns[2]){
			//add a caramel scoop
			cone.addScoop("Burnt Caramel");
		}
		//if clicking a raspberry button
		if (e.getSource() == flavorBtns[3]){
			//add a raspberry scoop
			cone.addScoop("Raspberry");
		}
		//if clicking the eat button 
		if (e.getSource() == trashButton){
			//eat the top scoop
			cone.deleteScoop();
		}
		repaint();
	}
}
