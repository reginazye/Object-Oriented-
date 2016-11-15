import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D; // optional, for drawing lines with varying thickness
import java.awt.BasicStroke; // optional, for drawing lines with varying thickness
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import java.util.Random;

/**
 * create the class where one can click and draw a tree, the class displays one
 * Recursive TreePainting.
 * 
 * @author Regina Ye
 **/

public class RecursiveTreePainting extends JComponent implements MouseListener {

	/** Number of branches **/
	public static final int NUM_BRANCHES = 3;

	/**
	 * Golden ratio makes the trunk length:branch length ratio aesthetically
	 * appealing
	 **/
	public static final double GOLDEN_RATIO = 1.618;

	/**
	 * Number of generations to create branches. Play with this for
	 * coarser/finer detail.
	 **/
	public static final int NUM_GENERATIONS = 8;

	/** Maximum branching angle of children from a parent stick **/
	public static final double MAX_BRANCHING_ANGLE = .5 * Math.PI;

	/** Diameter of the blossoms. **/
	public static final int BLOSSOM_DIAM = 10;

	/**
	 * Mark where the trunk starts and end, also mark where the branches end
	 **/

	public Point2D pstart;
	public Point2D pend;
	public Point2D branchEnd;
	/**
	 * Mark the beginning and end points of the lines
	 **/
	public int xstart;
	public int ystart;
	public int xend;
	public int yend;

	public double trunkLength;
	public double trunkAngle;

	public RecursiveTreePainting() {
		addMouseListener(this);
	}

	/**
	 * Paint a tree, first paint the background, then paint the trunk, lastly
	 * paint the branches
	 **/
	public void paint(Graphics g) {
		paintBackground(g);
		if (pend != null) {
			// change the thickless of the lines
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(3));
			paintTrunk(g);
			for (int i = 0; i < NUM_BRANCHES; i++) {
				paintBranch(g, pend, trunkLength, trunkAngle, NUM_GENERATIONS - 1);
				System.out.println("kjahsfg");
			}
		}

	}

	// the find end point menthod that returns the end point
	public Point2D computeEndpoint(Point2D p, double length, double angle) {
		return new Point2D.Double(p.getX() + length * Math.cos(angle), // x is
																		// cos
				p.getY() + length * Math.sin(angle)); // y is sin
	}

	/** paint a trunk method **/
	public void paintTrunk(Graphics g) {
		// set the trunk color to green
		g.setColor(Color.green);
		g.drawLine(xstart, ystart, xend, yend);
		trunkLength = Math.sqrt((xend - xstart) * (xend - xstart) + (yend - ystart) * (yend - ystart));
	}

	/**
	 * paint the branches at random angles draw random colors of flowers at the
	 * ends of the branches
	 **/

	public void paintBranch(Graphics g, Point2D startingP, double length, double angle, int generation) {
		if (generation == 0) {
			Random rand = new Random();
			float r = rand.nextFloat();
			float green = rand.nextFloat();
			float b = rand.nextFloat();
			Color randomColor = new Color(r, green, b);
			g.setColor(randomColor);
			g.fillOval((int) startingP.getX(), (int) startingP.getY(), BLOSSOM_DIAM, BLOSSOM_DIAM);
		} else {
			g.setColor(Color.green);
			angle = Math.random() * Math.PI - Math.PI + trunkAngle;
			length = length / GOLDEN_RATIO;
			branchEnd = new Point2D.Double(length * Math.cos(angle) + startingP.getX(),
					length * Math.sin(angle) + startingP.getY());
			g.drawLine((int) startingP.getX(), (int) startingP.getY(), (int) branchEnd.getX(), (int) branchEnd.getY());
			startingP = branchEnd;
			for (int n = 0; n < NUM_BRANCHES; n++) {
				paintBranch(g, startingP, length, angle, generation - 1);
			}
		}

	}

	/** paint the background to black **/
	public void paintBackground(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	/**
	 * Invoked when the mouse enters the component. when mouse is pressed,
	 * remember the current location
	 * 
	 * @param e
	 *            the current state of the mouse
	 */
	public void mousePressed(MouseEvent e) {
		xstart = e.getX();
		ystart = e.getY();
		pstart = new Point2D.Double(xstart, ystart);
	}

	/**
	 * Invoked when the mouse enters the component. when mouse is released,
	 * remember the location, the trunk angle  
	 * 
	 * @param e
	 *            the current state of the mouse
	 */
	public void mouseReleased(MouseEvent e) {
		xend = e.getX();
		yend = e.getY();
		pend = new Point2D.Double(xend, yend);
		repaint();
		trunkAngle = Math.atan2(xend - xstart, yend - ystart);
	}

	/**
	 * Invoked when the mouse enters the component.
	 * 
	 * @param e
	 *            the current state of the mouse
	 */
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Invoked when the mouse leaves the component.
	 * 
	 * @param e
	 *            the current state of the mouse
	 */
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * Invoked when the mouse is clicked (pressed down and released).
	 * 
	 * @param e
	 *            the current state of the mouse
	 */
	public void mouseClicked(MouseEvent e) {
	}

}
