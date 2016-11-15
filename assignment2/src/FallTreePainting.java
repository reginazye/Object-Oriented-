
import java.awt.Color;
import java.awt.Graphics;
/**
 * FallTreePainting that extends SingleTreePanel 
 * and displays one fall TreePainting.
 * @author Regina Ye
 **/
public class FallTreePainting extends TreePainting{

 	/**
 	 *paint the background light green 
 	 **/
	public void paintBackground(Graphics g){
		g.setColor(new Color(153, 255, 204));
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}