/** 
 * Main application for the circle application
 * 
 * @author Regina Ye
 **/

import javax.swing.*;
 
 	/**
	* create the circle application class
	 */

public class CircleApplication
{
	/**
	 * Sets the width of the frame to 1200 pixels
	 */
    public static int FRAME_WIDTH = 1200;
	
	/**
	 * Sets the height of the frame to 800 pixels
	 */
    public static int FRAME_HEIGHT = 800;

	/**
	 * Creates and draws the frame for the circles
	 * 
	 * @param args not used
	*/
    public static void main(String[] args)
    {
		JFrame circleFrame = new JFrame("Regina Ye -- Draw by clicking!");
		circleFrame.add(new CirclePanel());
		circleFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		circleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		circleFrame.setVisible(true);

    }
}