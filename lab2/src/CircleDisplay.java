/** 
 * Draws circular objects on a screen
 *
 * @author Regina Ye
 * 
 */
import java.util.LinkedList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

public class CircleDisplay extends JComponent implements MouseListener
{
	//Holds the list of circles to draw
	private LinkedList<DrawableCircle> CircleList;
	private int n = 0;
	
	/**
	 * Constructor to draw circles
	 **/
	public CircleDisplay()
	{
		// have this be a mouse listener for its own mouse events
		addMouseListener(this);
		CircleList = new LinkedList<DrawableCircle>();
	}
	
	/**
	 * Draws circles using the paint method
	 * 
	 * @param g graphics object to draw on
	 **/
	public void paint(Graphics g)
	{
		for (DrawableCircle circ : CircleList) {
			circ.draw(g);
		}
	}
	
	/**
	 * Invoked when the mouse is pressed down. Adds a circle at the current location.
	 * 
	 * @param e the current state of the mouse
	 */
	public void mousePressed(MouseEvent e)
	{
		/**
	 * Draw a new cirlce around the point clicked 
	 */
		DrawableCircle newCirc = new DrawableBubble(e.getX(), e.getY(), 10+n*5, new Color(120, 160, 200), Color.white);
		CircleList.add(newCirc);
		repaint();
		n = n+1;
    }
    
	/**
	 * Invoked when the mouse is released.
	 * 
	 * @param e the current state of the mouse
	 */
	public void mouseReleased(MouseEvent e){
	/**
	 * When mouse is released, draw a drawable target
	 */
		DrawableTarget newTarg = new DrawableTarget (e.getX(), e.getY(), 10+ (n-1)*5, new Color(250, 100,100));
		CircleList.add(newTarg);
		repaint();
	}
	
	/**
	 * Invoked when the mouse enters the component.
	 * 
	 * @param e the current state of the mouse
	 */
	public void mouseEntered(MouseEvent e){}

	/**
	 * Invoked when the mouse leaves the component.
	 * 
	 * @param e the current state of the mouse
	 */
	public void mouseExited(MouseEvent e){}

	/**
	 * Invoked when the mouse is clicked (pressed down and released).
	 * 
	 * @param e the current state of the mouse
	 */
	public void mouseClicked(MouseEvent e){}
	
}