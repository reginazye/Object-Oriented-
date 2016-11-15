/* BubbleDisplay
Draws some bubbles
Date: 9/14/16
Author: Regina Ye
Modified: 
 */
 
import java.awt.*;
import javax.swing.*;

public class BubbleDisplay extends JComponent
{
	//Global constants
	public static Color COLOR_BUBBLE = new Color(219,112,147);
	public static Color COLOR_OUTLINE = COLOR_BUBBLE.darker();
	public static Color COLOR_HIGHLIGHT = Color.WHITE;
	public static int DIAM_BUBBLE = 50;
	
	/**
	 * Constructor to draw bubbles
	 **/
	public BubbleDisplay()
	{
		// Call the superclass' constructor
		super();
	}
	
	/**
	 * Override the paint method to draw bubbles
	 **/
	public void paint( Graphics g )
	{
		//Start with the x and y values of the upper left corner of the bubble
		int x = 0;
		int y = 0;
		int width = this.getWidth();
		int height = this.getHeight();
		//Draw ten bubbles in a row
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++)
			drawBubble(g, x+DIAM_BUBBLE*i, y+DIAM_BUBBLE*j);
		}
	}
	
	/**
	 * Draw a single bubble
	 **/
	public void drawBubble(Graphics g, int x, int y)
	{
		// Set the color of the inside of the bubble
		g.setColor(COLOR_BUBBLE);
		
		// Draw the inside of the bubble (upper left x, upper left y, width, height)
		g.fillOval(x, y, DIAM_BUBBLE, DIAM_BUBBLE);

		//Set the color of the outside of the bubble
		g.setColor(COLOR_OUTLINE);
		
		//Draw the outline of the bubble 
		g.drawOval(x, y, DIAM_BUBBLE, DIAM_BUBBLE);
		
		//Set the color of a highlight
		g.setColor(COLOR_HIGHLIGHT);
		
		//Draw the highlight as a rounded rectangle (upper left x, upper left y, width, hight, arc width, arc height)
		g.fillRoundRect(x+(DIAM_BUBBLE*3/5), y+(DIAM_BUBBLE/5), 10, 10, 5, 5);
	}
	
}