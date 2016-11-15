import java.awt.Color;
import java.awt.Graphics;

/**
 * Create SpringTreePanel that extends SingleTreePanel 
 * and displays one spring TreePainting.
 * @author Regina Ye
 **/

public class SpringTreePainting extends TreePainting{

/**
 *paint the background white 
 **/
	public void paintBackground(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
	}


}