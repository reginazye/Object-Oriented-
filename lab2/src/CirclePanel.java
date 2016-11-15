/** 
 * Creates a panel to draw circles in
 *
 * @author Regina Ye
 * 
 */
 
import java.awt.*;
import javax.swing.*;

public class CirclePanel extends JPanel 
{
	/**
	 * declare the variable
	 **/
	private CircleDisplay circleDisplay;
	
	/**
	 * Constructor, to create a new panel
	 **/
	public CirclePanel()
	{
		// Set the layout to be border-style
		super(new BorderLayout());
		// Create panel defaults
		initPanel();
	}
	
	/** 
	 * Create GUI components.
	 **/
	public void initPanel()
	{		
		// Display the circles in the center of the panel
		this.add(createCircleDisplay(), BorderLayout.CENTER);
	}
	
	/**
	 * Create and return the circle display.
	 * 
	 * @return the display to draw the bubbles in
	 **/
	public CircleDisplay createCircleDisplay()
	{	
		circleDisplay = new CircleDisplay();
		return circleDisplay;
	}
	
}