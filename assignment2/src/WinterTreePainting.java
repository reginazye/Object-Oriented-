import java.awt.Color;
import java.awt.Graphics;

/**
 * create a WinterTreePainting that extends TreePainting 
 **/

public class WinterTreePainting extends TreePainting{

	/** paint the background to light yellow **/
	public void paintBackground(Graphics g){
		g.setColor(new Color(255, 255, 102));
		g.fillRect(0, 0, getWidth(), getHeight());
	}


}