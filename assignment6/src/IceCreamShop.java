import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * create the ice cream shop 
 * where all the components come together 
 * 
 * @author ReginaYe
 *
 */
public class IceCreamShop extends JComponent implements ActionListener{
	public final int CORRECT_MATCH_SCORE = 10;
	public final int INCORRECT_MATCH_SCORE = -5;
	public final String INSTRUCTIONS = "<html>Make ice cream cones to match the next order"
				+ "<br>Every correct order served earns you 10 points"
				+ "<br>Make the wrong cone and you'll lose 5 points."
				+ "<br>    "
				+ "<br>    <html>";
	
	protected IceCreamLineManager lineManager = new IceCreamLineManager();
	private IceCreamController maker = new IceCreamController();
	private int score;
	private JLabel scoreLabel = new JLabel("Score: " + score);
	private JButton nextBtn;
	
	/**
	 * constructor for the ice cream shop 
	 */
	public IceCreamShop(){
		super.setLayout(new BorderLayout());
		//add the components 
		add(textBoard(), BorderLayout.NORTH);
		add(ServeNext(), BorderLayout.SOUTH);
		add(lineManager, BorderLayout.WEST);
		add(maker, BorderLayout.CENTER);
		
	}
	
	/**
	 * design and add the text field 
	 * where the instruction and the score are showed 
	 * @return the panel that has the texts
	 */
	public JPanel textBoard(){
		JPanel tboard = new JPanel();
		tboard.setLayout(new BorderLayout());
		tboard.add(new JLabel(INSTRUCTIONS), BorderLayout.CENTER);
		tboard.add(scoreLabel, BorderLayout.SOUTH);
		
		return tboard;
	}
	
	/**
	 * create the serve the order button 
	 * @return the serve the order button
	 */
	public JButton ServeNext(){
		nextBtn = new JButton("Serve the Next Order");
		//resize the button to make it bigger 
	    nextBtn.setPreferredSize(new Dimension(this.getWidth(), 80));
	    nextBtn.addActionListener(this);
	    return nextBtn;
	}

	/**
	 * what happens when the user clicks the serve the order button 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextBtn){
			//if the cones are the same 
			if (compareCone()){
				score = score+10;
				lineManager.getLine().deleteFirst();
			}
			//if the cones are not the same 
			else if (!compareCone()){
				score = score-5;
			}
			//up date the score label
			scoreLabel = new JLabel("Score: " + score);
		revalidate();
		repaint();
	}
	}
	
	
	/**
	 * a boolean method to test if the ordered and 
	 * the ice cream served are the same  
	 * @return true or false 
	 */
	private boolean compareCone(){
		//get the two cones 
		IceCreamCone cone1 = lineManager.getLine().getNextOrder();
		IceCreamCone cone2 = maker.getCone();
		//remember the sizes
		int cone1Size = cone1.getConeSize();
		int cone2Size = cone2.getConeSize();
		//first see if the sizes are the same 
		if (cone1Size == cone2Size){
			//to check if the ice creams are completely equal
			while(!cone1.isEmpty()){
				if (cone1.deleteScoop() != cone2.deleteScoop()){
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
