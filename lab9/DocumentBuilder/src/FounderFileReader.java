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
		parseFounderFile(document);
	}

/**
 * a method to parse the founder file 
 * @param document
 */
	private static void parseFounderFile(Document document) {
		Node docRoot = document.getDocumentElement();
		parseNode(docRoot);
	}

/**
 * parse the nodes in the file 
 * 
 * @param n
 */
	private static void parseNode(Node n) {

		if (n.hasChildNodes()) {
			//cast away the element nodes not needed 
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element currentElt = (Element) n;
				if (n.getNodeName().equals("name") || n.getNodeName().equals("year")
						|| n.getNodeName().equals("college")) {
					System.out.println(n.getNodeName() + ": " + n.getTextContent());
				}
				if (currentElt.hasAttribute("id")) {
					// print out the ID
					System.out.println("id: " + currentElt.getAttribute("id"));
				}
			}
			// generate a list of children nodes
			NodeList children = n.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				// parse all notes in the list
				parseNode(children.item(i));
			}
		}
	}

}
