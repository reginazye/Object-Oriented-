import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* TreeCollagePanel is a JPanel. It will hold all the 
* seasonal TreePaintings we want to display. It uses
* a GridLayout to specify how they are arranged in the GUI.
* @author Regina Ye
*/
public class TreeCollagePanel extends JPanel
{
	 /**
	  *declare the JLabel for intructions and the JPanel for the tree display
	  */

	 private JLabel instructions;
	 private JPanel mainCollagePanel;
	
 	 
	 /**
	  * Calls super (the superclass constructor) and sets a BorderLayout.
	  * 
	  * In the NORTH region, adds 'instructions', a JLabel, that will 
	  * display the instructions.
	  * 
	  * In the CENTER panel, adds 'mainCollagePanel', a JPanel, that will
	  * be organized with a GridLayout to hold a basic TreePainting object
	  * plus each of the four seasonal TreePainting subclass objects:
	  * WinterTreePainting, SpringTreePainting, SummerTreePainting, 
	  * FallTreePainting.
	  * 
	  */
	 public TreeCollagePanel(String instructionsText)
	 {
		 super(new BorderLayout());

		 instructions = new JLabel(instructionsText);

	 	 super.add(instructions, BorderLayout.NORTH);

	 	 /**
	 	  * put five different TreePaintin objects onto the mainPanel, 
	 	  * then put the main panel in the center 
	 	  **/

	 	 mainCollagePanel = new JPanel(new GridLayout (0, 5));
	 	 mainCollagePanel.add(new TreePainting());
	 	 mainCollagePanel.add(new SpringTreePainting());
	 	 mainCollagePanel.add(new SummerTreePainting());
	 	 mainCollagePanel.add(new FallTreePainting());
	 	 mainCollagePanel.add(new WinterTreePainting());

		 super.add(mainCollagePanel, BorderLayout.CENTER);
	 }




}