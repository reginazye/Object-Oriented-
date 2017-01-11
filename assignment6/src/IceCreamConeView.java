import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * the view class for the ice-cream application
 * @author ReginaYe
 *
 */
public class IceCreamConeView extends JComponent{
	//create an array of colors that correspond to the flavors
	public final Color[] PAINT_COLORS = new Color[]{Color.pink, Color.green, Color.orange, Color.magenta};
	//set constants for the sizes of the ice-cream
	public final int CONE_WIDTH = 40;
	public final int CONE_HEIGHT = 80;
	public final int SCOOP_DIAMETER = 40;
	public final int SCOOP_OVERLAP = 5;
	private IceCreamCone cone;
	
	/**
	 * constructor for the view class
	 * @param c
	 */
	public IceCreamConeView(IceCreamCone c){
		this.cone = c;
	}
	
	/**
	 * paint the cone and the scoop
	 */
	public void paint(Graphics g){
		paintCone(g);
		paintScoop(g);
	}
	
	/**
	 * paint cone method 
	 * @param g
	 */
	public void paintCone(Graphics g){
		g.setColor(Color.blue);
		g.fillPolygon(new int[] {this.getWidth()/2-CONE_WIDTH/2, this.getWidth()/2+CONE_WIDTH/2, this.getWidth()/2}, 
				new int[] {this.getHeight()-CONE_HEIGHT, this.getHeight()-CONE_HEIGHT, this.getHeight()}, 3);
	}
	
	/**
	 * paint the scoop method 
	 * @param g
	 */
	public void paintScoop(Graphics g){
		//create a reversed stack to hold the colors in correct order 
		StackLL<Integer> reversed = new StackLL<>();

		int x = (int)(this.getWidth()/2-SCOOP_DIAMETER/2);
		int y = this.getHeight()-CONE_HEIGHT-SCOOP_DIAMETER+SCOOP_OVERLAP;
		int scoopNum = 0;
		
		//while the original flavor stack is not empty
		while (!cone.getScoopFlavorStack().isEmpty()){
			//add the flavors into the reversed stack
			reversed.push(cone.getScoopFlavorStack().pop());
		}
		
		//when the reversed stack is not empty
		while (!reversed.isEmpty()){
			//draw the correspondent flavor scoop
			int flavoridx = reversed.pop();
			for(int i=0; i<4; i++){
				if (flavoridx==i){
					g.setColor(PAINT_COLORS[i]);
					g.fillOval(x, y-scoopNum*SCOOP_DIAMETER+scoopNum*SCOOP_OVERLAP, SCOOP_DIAMETER, SCOOP_DIAMETER);
					cone.getScoopFlavorStack().push(flavoridx);
				}
			}
			//update the number of scoops 
			scoopNum++;
		}		
	}
}
