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
 * create the class where one can click and draw a tree,
 * the class displays one basic TreePainting.
 * @author Regina Ye
 **/

public class TreePainting extends JComponent implements MouseListener {


	/** Number of branches **/
	public static final int NUM_BRANCHES = 8; 
 
	/** Diameter of the blossoms. **/
	public static final int BLOSSOM_DIAM = 25;
 
	/** Golden ratio makes the trunk length:branch length ratio aesthetically appealing **/
	public static final double GOLDEN_RATIO = 1.618;

	/** Mark where the trunk starts and end, 
	 * also mark where the branches end
	 **/

	public Point2D pstart;
	public Point2D pend;
	public Point2D branchEnd;

	public int  xstart;
	public int  ystart;
	public int xend;
	public int yend;

	//length of the tree
	public double length;
	public double angle;

	public TreePainting () {

		addMouseListener(this);
	}

	/**
	 * Paint a tree,
	 * first paint the background, 
	 * then paint the trunk, 
	 * lastly paint the branches
	 **/
	public void paint(Graphics g) {
		paintBackground(g);
		if (pend!=null) {
		paintTrunk(g);
		paintBranches(g);
		}
		
	}

	//the find end point menthod that returns the end point 
	public Point2D computeEndpoint( Point2D p, double length, double angle )
	{
	    return new Point2D.Double( p.getX() + length*Math.cos(angle), // x is cos
 	    p.getY() + length*Math.sin(angle)); // y is sin
	}

	/** paint a trunk method **/
	public void paintTrunk(Graphics g){
		//set the trunk color to green 
		g.setColor(Color.green);
		g.drawLine(xstart,ystart,xend,yend);
	}

	/** paint the branches at random angles 
	 *  draw random colors of flowers at the ends of the branches
	 **/

	public void paintBranches(Graphics g){
		for (int i= 0; i < 8; i++) {
				double randomAngle = Math.random();
				length = Math.sqrt((xend - xstart)*(xend-xstart) + (yend-ystart)*(yend-ystart));
				branchEnd = computeEndpoint (pend, length/GOLDEN_RATIO, randomAngle);
				g.setColor(Color.green);
				g.drawLine(xend, yend, (int)branchEnd.getX(), (int)branchEnd.getY());
				Random rand = new Random();
				float r = rand.nextFloat();
				float green = rand.nextFloat();
				float b = rand.nextFloat();
				Color randomColor = new Color(r, green, b);
				g.setColor(randomColor);
				g.fillOval ((int)branchEnd.getX()-BLOSSOM_DIAM/2, (int)branchEnd.getY()-BLOSSOM_DIAM/2, (int)BLOSSOM_DIAM, (int)BLOSSOM_DIAM);	}
	}


	/** paint the background to black **/
	public void paintBackground(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
	}


	/**
	 * Invoked when the mouse enters the component.
	 * when mouse is pressed, remember the current location
	 * @param e the current state of the mouse
	 */
	public void mousePressed(MouseEvent e){
		xstart = e.getX();
		ystart = e.getY();
		pstart = new Point2D.Double( xstart, ystart);
	}

	/**
	 * Invoked when the mouse enters the component.
	 * when mouse is released, remember the location
	 * execute the paint method again
	 * @param e the current state of the mouse
	 */
	public void mouseReleased(MouseEvent e){
		xend = e.getX();
		yend = e.getY();
		pend = new Point2D.Double(xend, yend);
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



