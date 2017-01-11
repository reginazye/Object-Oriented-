import java.awt.Dimension;
import java.util.Random;

import javax.swing.JComponent;

/**
 * the model class for the ice-cream application
 * 
 * @author ReginaYe
 *
 */
public class IceCreamCone extends JComponent{
	public final static String[] FLAVORS = new String[]{"Strawberry", "Green Tea", "Burnt Caramel", "Raspberry"};
	private StackLL<Integer> scoopFlavorStack;

	/**
	 * constructor for the class ice-cream cone
	 */
	public IceCreamCone(){
		//create a new stack to hold the flavors
		scoopFlavorStack = new StackLL<Integer>();
	}
	
	/**
	 * get the stack
	 * @return the scoop stack
	 */
	public Stack<Integer> getScoopFlavorStack(){
		return scoopFlavorStack;
	}
	
	/**
	 * find the index of a specific flavor
	 * @param flavor
	 * @return flavor index 
	 */
	public int findFlavorIdx(String flavor){
		for(int i=0; i<FLAVORS.length; i++){
			if (FLAVORS[i].equals(flavor)){
			return i;
			}
		}
		return 0;
	}
	
	/**
	 * add a new flavor into the stack
	 * @param flavor
	 */
	public void addScoop(String flavor){
		scoopFlavorStack.push(findFlavorIdx(flavor));
	}
	

	public void addRandomScoops(){		
		Random timesGenerator = new Random();
		int times = timesGenerator.nextInt(3) + 1;
		for (int i=0; i<times; i++){
			Random numGenerator = new Random();
			int num = numGenerator.nextInt(4);
			scoopFlavorStack.push(num);
		}
	}
	
	/**
	 * delete the top scoop from the stack
	 */
	public int deleteScoop(){
		return scoopFlavorStack.pop();
	}
	
	public boolean isEmpty(){
		return scoopFlavorStack.isEmpty();
	}
	
	public int getConeSize(){
		if (!scoopFlavorStack.isEmpty()){
			return scoopFlavorStack.getStackSize();
		}
		return 0;
	}
	
}
