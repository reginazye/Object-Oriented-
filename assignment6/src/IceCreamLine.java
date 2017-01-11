import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * Ice-cream line
 * extends Box
 * @author ReginaYe
 *
 */
public class IceCreamLine extends Box {
	//have two queues to hold the ice creams and the views 
	QueueLL<IceCreamCone> orderLine;
	QueueLL<IceCreamConeView> orderLineView;

	/**
	 * the ice cream line constructor 
	 */
	public IceCreamLine() {
		//have a box layout that lines up vertically
		super(BoxLayout.Y_AXIS);
		//have two queues to hold the ice creams and the views 
		orderLine = new QueueLL<IceCreamCone>();
		orderLineView = new QueueLL<IceCreamConeView>();
	}

	/**
	 * see if the line is empty 
	 * @return
	 */
	public boolean hasOrder() {
		return orderLine.isEmpty();
	}


	/**
	 * to add a random new ice cream
	 */
	public void addRandomOrder() {
		IceCreamCone cone = new IceCreamCone();
		IceCreamConeView view = new IceCreamConeView(cone);

		cone.addRandomScoops();
		//enqueue the new ice cream 
		orderLine.enqueue(cone);
		orderLineView.enqueue(view);
		
		add(view);
		validate();
		repaint();
	}

	/**
	 * delete the top order 
	 */
	public void deleteFirst() {
		if (!orderLine.isEmpty()) {
			orderLine.dequeue();
			orderLineView.dequeue();
		}
	}
	
	/**
	 * @return the ice cream queue 
	 */
	public QueueLL<IceCreamCone> getConeQueue(){
		return orderLine;
	}

	/**
	 * @return the next order in line to be served 
	 */
	public IceCreamCone getNextOrder() {
		return orderLine.peek();
	}

}
