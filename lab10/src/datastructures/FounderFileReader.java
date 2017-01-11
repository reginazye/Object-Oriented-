package datastructures;

import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import org.w3c.dom.*;
import java.io.*;

/**
 * Founder File Document Reader
 * 
 * @author ReginaYe
 *
 */
public class FounderFileReader {

	/**
	 * main function for document builder 
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws DOMException
	 */
	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, DOMException {
		// Setup XML Document
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File xmlFile = new File(args[0]);
		Document document = builder.parse(xmlFile);
		//parse the document 
		System.out.println( parseFounderFile( document ).toString());
	}

/**
 * a method to parse the founder file 
 * @param document
 */
	private static CollegeFounders parseFounderFile(Document document) {
		Node docRoot = document.getDocumentElement();
		CollegeFounders founders = new CollegeFounders();
		parseNode(docRoot, founders);
		return founders;
	}

/**
 * parse the nodes in the file 
 * 
 * @param n
 */
	private static void parseNode(Node n, CollegeFounders founders) {
//
//		if (n.hasChildNodes()) {
//			//cast away the element nodes not needed 
//			if (n.getNodeType() == Node.ELEMENT_NODE) {
//				Element currentElt = (Element) n;
//				if (n.getNodeName().equals("name") || n.getNodeName().equals("year")
//						|| n.getNodeName().equals("college")) {
//					System.out.println(n.getNodeName() + ": " + n.getTextContent());
//				}
//				if (currentElt.hasAttribute("id")) {
//					// print out the ID
//					System.out.println("id: " + currentElt.getAttribute("id"));
//				}
//			}
			//If it's a Founder Node parse the Founder
				if( n.getNodeType() == Node.ELEMENT_NODE)	
				{	
					Element currentElt = (Element)n;
					if( currentElt.getTagName().equals("founder") )
					{
						Founder f = parseFounderElement(currentElt);
						founders.addFounder(f);
					}
				}
		
			// generate a list of children nodes
			NodeList children = n.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				// parse all notes in the list
				parseNode(children.item(i), founders);
			}
			
			
	}
/**	
 * parse the founder node to return a founder object 
 * 
 * @param founder
 * @return
 */
	private static Founder parseFounderElement(Node founder)
			{
				String ID = "";
				String name = "";
				String year = "";
				String college = "";
				//cast a founder node to be a founder element
				Element currentElt = (Element) founder;
				//get the ID information from the element	
				ID = currentElt.getAttribute("id");
		 
		        NodeList childNodes = founder.getChildNodes();
		        //extract information from different nodes 
				for ( int i = 0; i<childNodes.getLength() ; i++ )
				{
					Node childNode = childNodes.item(i);
					if( childNode.getNodeName().equals("name")){
						name = childNode.getTextContent();
					}
					else if(childNode.getNodeName().equals("year") )
					{
						year = childNode.getTextContent();
					}
					else if(childNode.getNodeName().equals("college"))
					{
						college = childNode.getTextContent();
					}
				}
				//return a new founder object with the extracted information 
				return new Founder(ID, name, year, college) ;
			}
	
	

}
