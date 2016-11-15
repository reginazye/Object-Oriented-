/** 
 *  Drawable Target
 *
 * @author Regina Ye
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
 
public class DrawableTarget extends DrawableCircle{

	
	
	/**
	 * Construct a new target
	 * 
	 **/
	public DrawableTarget(int newX, int newY, int newDiam, Color newColor) {
		super(newX, newY, newDiam, newColor);
	}
	
	/**
	 * Draw a set of concentric circles
	 * 
	 * 
	 **/
	public void draw(Graphics g) {
		drawConcentric (x-diam/2, y-diam/2, diam, true, g);
	}
	
	
	/**
	 * draw a set of concentric circles,
	 * the colors alternate each time
	 * use recursion, reduce size and change color each circle 
	 * @param x
	 * @param y
	 * @param diam
	 * @param altc
	 * @param g
	 */
	public void drawConcentric(int x, int y, int diam, boolean altc, Graphics g) {
			altc =!altc;
			if (altc == false){
				g.setColor(Color.BLUE);				
			}else if (altc == true){
				g.setColor(Color.white);
			}
			g.fillOval (x, y, diam, diam);
			x = x +2;
			y = y+2;
			diam = diam - 4;
			
			if (diam>0){
				drawConcentric(x, y, diam, altc, g);
			}
			
		}
	}
