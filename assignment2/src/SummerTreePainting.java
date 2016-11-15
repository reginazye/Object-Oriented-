import java.awt.Color;
import java.awt.Graphics;



/**
 * create SummerTreePanel that extends SingleTreePanel 
 * and displays one summer TreePainting.
 * @author Regina Ye
 **/

public class SummerTreePainting extends TreePainting{

	public void paintBackground(Graphics g){
/**
 *paint the background light blue
 **/
		g.setColor(new Color(153, 204, 255));
		g.fillRect(0, 0, getWidth(), getHeight());
	}


}