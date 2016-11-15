/** 
 * Parent class for drawable circular objects
 *
 * @author Regina Ye
 */
import java.awt.Color;
import java.awt.Graphics;
 
public class DrawableCircle {
	
	//Private variables holding default starting values
	protected int x;
	protected int y;
	protected int diam;
	protected Color fillColor;
	 
	/**
	 * Construct a new drawable circles
	 * 
	 * @param newX starting x value
	 * @param newY starting y value
	 * @param newDiam starting diameter
	 * @param newColor base color of the circle
	 **/
	public DrawableCircle(int newX, int newY, int newDiam, Color newColor) {
		x = newX;
		y = newY;
		diam = newDiam;
		fillColor = newColor;
	}
	
	/**
	 * Gets the current value of x
	 * 
	 * @return current value of x
	 **/
	public int getX() {
		return x;
	}
		
	/**
	 * Sets x to a new value
	 * 
	 * @param newX new x value
	 **/
	public void setX(int newX) {
		x = newX;
	}
		
	/**
	 * Gets the current value of y
	 * 
	 * @return current value of y
	 **/
	public int getY() {
		return y;
	}
		
	/**
	 * Sets y to a new value
	 * 
	 * @param newY new y value
	 **/
	public void setY(int newY) {
		y = newY;
	}
		
	/**
	 * Gets the current diameter
	 * 
	 * current diameter
	 **/
	public int getDiam() {
		return diam;
	}
		
	/**
	 * Sets the diameter to a new value
	 * 
	 *  newDiam new diameter
	 **/
	public void setDiam(int newDiam) {
		diam = newDiam;
	}
		
	/**
	 * Gets the current fill color
	 * 
	 * @return current fill color
	 **/
	public Color getFillColor() {
		return fillColor;
	}
		
	/**
	 * Sets fill color to a new color
	 * 
	 * newFillColor new fill color
	 **/
	public void setFillColor(Color newFillColor) {
		fillColor = newFillColor;
	}
	
	/**
	 * Draw a single circle
	 * 
	 *  g the graphics object to draw on
	 **/
	public void draw(Graphics g)
	{
		// Set the color of the inside of the circle
		g.setColor(fillColor);
		
		// Draw the inside of the circle (upper left x, upper left y, width, height)
		g.fillOval(x-diam/2, y-diam/2, diam, diam);
		
		//Draw the outline of the circle 
		g.drawOval(x-diam/2, y-diam/2, diam, diam);

		//Set the color of the outside of the circle
		g.setColor(fillColor.darker());
		

	}




	 
 }