
/** 
 * Draws circular objects on a screen
 *
 * @author Amy Tayloe
 * @version 2
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;

public class CircleDisplay extends JComponent implements KeyListener {
	// Starting circle
	private DrawableCircle circ;

	/**
	 * Constructor to draw circles
	 **/
	public CircleDisplay(int circType) {
		// add the key listener
		setFocusable(true);
		addKeyListener(this);

		int startX = 600;
		int startY = 400;
		int diameter = 50;
		// based on what's passed in, draw a bubble, target, or circle (default)
		switch (circType) {
		case 1:
			circ = new DrawableBubble(startX, startY, diameter, Color.black, Color.gray);
			break;
		case 2:
			circ = new DrawableTarget(startX, startY, diameter, Color.blue, Color.lightGray);
			break;
		case 3:
			circ = new NewCircle(startX, startY, diameter, Color.ORANGE);
			break;
		default:
			circ = new DrawableCircle(startX, startY, diameter, Color.green);
			break;
		}
	};

	/**
	 * Draws circles using the paint method
	 * 
	 * @param g
	 *            graphics object to draw on
	 **/
	public void paint(Graphics g) {
		circ.draw(g);
	}

	/**
	 * Do something when a key is pressed
	 * 
	 * @param e
	 *            the key that is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
	}

	/**
	 * Move the circle when a key is released
	 * 
	 * @param e
	 *            the key that is released
	 */
	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			circ.setY(circ.getY() - 10);
		}

		else if (key == KeyEvent.VK_DOWN) {
			circ.setY(circ.getY() + 10);
		} else if (key == KeyEvent.VK_LEFT) {
			circ.setX(circ.getX() - 10);
		} else if (key == KeyEvent.VK_RIGHT) {
			circ.setX(circ.getX() + 10);
		} else if (key == KeyEvent.VK_SPACE) {
			circ.setY(getHeight() - 50);
		}
		repaint();
	}

	/**
	 * Do something when a key is pressed and released
	 * 
	 * @param e
	 *            the key that is pressed and released
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

}