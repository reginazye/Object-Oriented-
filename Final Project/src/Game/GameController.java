package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import DataStructures.DefaultBinaryTree;
import DataStructures.DefaultBinaryTreeNode;
import File.FileReader;

/**
 * Controller class for the game 
 * where the game takes place 
 * 
 * @author ReginaYe
 *
 */
public class GameController extends JPanel implements ActionListener {
	
	/**
	 * declare the variables 
	 */
	public DefaultBinaryTree<String> tree = new FileReader().getTree();
	public JPanel questionPanel = new JPanel();
	public JTextArea question;
	JButton yesBTN = new JButton("YES");
	JButton noBTN = new JButton("NO");
	JButton submitBTN = new JButton("Submit");
	JPanel BTNpanel = new JPanel();
	DefaultBinaryTreeNode<String> temp;
	JPanel gamePanel;
	JTextArea instructions;
	JTextField input = new JTextField(20);
	ImageIcon pIcon;
	JLabel picShow;

	/**
	 * constructor for the game controller class
	 */
	public GameController() {	
		//set up the controller  
		super(new BorderLayout());
	    super.setBackground(Color.blue);
		setOpaque(true); 
		//add questions 
	    showfirst();
		add(question, BorderLayout.CENTER);
		//add instructions 
		makeInstructions();
		add(instructions, BorderLayout.NORTH);
		//add buttons 
		setBTN();
		add(BTNpanel, BorderLayout.SOUTH);
		//add the picture in the game 
		pIcon = new ImageIcon(getClass().getResource("makeup.jpg"));
		picShow = new JLabel(pIcon);
		add(picShow, BorderLayout.WEST);
	}

	/**
	 * set up the buttons yes or no
	 */
	private void setBTN() {
		BTNpanel.setLayout(new FlowLayout());
		// yes button
		yesBTN.addActionListener(this);
		BTNpanel.add(yesBTN);
		// no button
		noBTN.addActionListener(this);
		BTNpanel.add(noBTN);
//		//submit button 
//		submitBTN.addActionListener(this);
//		BTNpanel.add(submitBTN);
//		submitBTN.setEnabled(false);
	}

	/**
	 * set up the initial interface 
	 * show the first question 
	 */
	private void showfirst() {
		temp = (DefaultBinaryTreeNode<String>) tree.getRoot();
		question = new JTextArea(temp.getData());
		question.setFont(new Font("Marker Felt", Font.ITALIC, 20));
		question.setBackground(Color.pink);

	}
	
	/**
	 * make instructions 
	 */
	private void makeInstructions(){
		//new text to show the instructions 
		instructions = new JTextArea("This is a mind-reading game. \n So think of one makeup product, \n and I will guess it.");
		instructions.setFont(new Font("Marker Felt", Font.BOLD, 20));
	}

	/**
	 * what happens when the buttons are clicked 
	 */
	public void actionPerformed(ActionEvent e) {
		/**
		 * when the user clicks yes button
		 */
		if (e.getSource() == yesBTN) {
			//if the node is not an object 
			if (temp.getLeftChild() != null) {
				//update the question
				question.setText(temp.getLeftChild().getData());
				question.setFont(new Font("Marker Felt", Font.BOLD, 20));
				//update the current node 
				temp = (DefaultBinaryTreeNode<String>) temp.getLeftChild();
			//if the node is what the user guessed 
			} else if (temp.getLeftChild() == null) {
				question.setText("I WIN!");
				question.setFont(new Font("Marker Felt", Font.BOLD, 20));
			}
		}
		/**
		 * when the user clicks no button 
		 */
		if (e.getSource() == noBTN) {
			//if the node is not the end of a tree 
			if (temp.getRightChild() != null) {
				//update the question
				question.setText(temp.getRightChild().getData());
				question.setFont(new Font("Marker Felt", Font.BOLD, 20));
				//upate the current node 
				temp = (DefaultBinaryTreeNode<String>) temp.getRightChild();
			//if the game fails to guess 
			} else if (temp.getRightChild() == null) {
				question.setText("I lose...");
				question.setFont(new Font("Marker Felt", Font.BOLD, 20));
//				add(input, BorderLayout.EAST);
//				//enable the submit button to add a new object 
//				submitBTN.setEnabled(true);
			}
		}
		
//		/**
//		 * when the user clicks submit button
//		 */
//		if(e.getSource() == submitBTN){
//			//get the input and convert to a node 
//			DefaultBinaryTreeNode<String> nodeAdded = new DefaultBinaryTreeNode<String>(input.getText());
//			//add the node to the tree
//			temp.setRightChild(nodeAdded);
//			//update node value 
//			temp = nodeAdded;
//			//guess again with the new object added 
//			question.setText("Is it: "+temp.getData()+"?");
//			question.setFont(new Font("Marker Felt", Font.BOLD, 20));
		}

	}


