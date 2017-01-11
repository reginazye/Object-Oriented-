package File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

import DataStructures.DefaultBinaryTree;
import DataStructures.DefaultBinaryTreeNode;

import java.io.*;

/**
 * File Reader
 * 
 * @author ReginaYe
 *
 */
public class FileReader {
	static DefaultBinaryTree<String> tree;

	/**
	 * main method that executes the file parsing
	 * 
	 * @param args
	 */
	public FileReader(){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			//set up the file reader
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File("Makeup.xml");
			Document document = builder.parse(xmlFile);
			//parse the document 
			parseFile(document);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

/**
 * parse file, generate a binary tree 
 * @param document
 * @return the binary decision tree
 */
	public static DefaultBinaryTree<String> parseFile(Document document) {
		tree = new DefaultBinaryTree<String>();
		Node docRoot = document.getDocumentElement();
		tree.setRoot(parseNode(docRoot));
		return tree;
	}

/**
 * parse XML node and make Binary Tree Node 
 * @param n
 * @return binary tree node 
 */
	private static DefaultBinaryTreeNode<String> parseNode(Node n) {
		DefaultBinaryTreeNode<String> node = new DefaultBinaryTreeNode<String>(null);

		if (n.getNodeType() == Element.ELEMENT_NODE) {
			Element currentElt = (Element) n;
			// cast away the element nodes not needed
			if (currentElt.hasAttribute("text")) {
				//get questions 
				node.setData(currentElt.getAttribute("text"));
			}
			//get object if the answer is "thing"
			if (currentElt.getNodeName().equals("thing")) {
				node.setData(currentElt.getTextContent());
				return node;
			}

			//recursive function to get all the child nodes 
			if (n.hasChildNodes()) {
				NodeList children = n.getChildNodes();
				//for all of the children nodes 
				for (int i = 0; i < children.getLength(); i++) {
					if (children.item(i).getNodeType() == Element.ELEMENT_NODE) {
						Element childEl = (Element) children.item(i);
						//parse answers 
						if (childEl.getAttribute("useranswer").equals("yes")) {
							//set left children if yes
							node.setLeftChild(parseNode(parseAnswer(children.item(i))));
						} else if (childEl.getAttribute("useranswer").equals("no")) {
							//set right children if no
							node.setRightChild(parseNode(parseAnswer(children.item(i))));
						}
					}
				}
			}
		}
		return node;
	}

/**
 * parse answer node
 * @param n
 * @return
 */
	private static Node parseAnswer(Node n) {
		if (n.hasChildNodes()) {
			NodeList childlist = n.getChildNodes();
			for (int i = 0; i < childlist.getLength(); i++) {
				if (childlist.item(i).getNodeType() == Element.ELEMENT_NODE) {
					return childlist.item(i);
				}
			}
		}

		return n;
	}

/**
 * get tree method
 * @return binary tree 
 */
	public static DefaultBinaryTree<String> getTree(){
		return tree;
	}
}
