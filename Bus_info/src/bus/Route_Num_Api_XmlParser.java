package bus;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.IOException;

public class Route_Num_Api_XmlParser {
    public void parseXML(String xmlData) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        InputSource is = new InputSource(new StringReader(xmlData));
        Document doc = builder.parse(is);
        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("busRouteList");
        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String routeId = eElement.getElementsByTagName("routeId").item(0).getTextContent();
                String routeNo = eElement.getElementsByTagName("routeNo").item(0).getTextContent();
                String routeTp = eElement.getElementsByTagName("routeTp").item(0).getTextContent();

                System.out.printf("Route ID : %s\n", routeId);
                System.out.printf("Route No : %s\n", routeNo);
                System.out.printf("Route Type : %s\n", routeTp);
            }
        }
    }
}
