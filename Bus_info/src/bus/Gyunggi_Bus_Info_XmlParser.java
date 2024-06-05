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

public class Gyunggi_Bus_Info_XmlParser {

    public void parseXML(String xmlData) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        InputSource is = new InputSource(new StringReader(xmlData));
        Document doc = builder.parse(is);
        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        
        NodeList nList = doc.getElementsByTagName("busRouteInfoItem");
        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                System.out.printf("Company ID: %s\n", getTagValue("companyId", eElement));
                System.out.printf("Company Name: %s\n", getTagValue("companyName", eElement));
                System.out.printf("Company Tel: %s\n", getTagValue("companyTel", eElement));
                System.out.printf("District Code: %s\n", getTagValue("districtCd", eElement));
                System.out.printf("Down First Time: %s\n", getTagValue("downFirstTime", eElement));
                System.out.printf("Down Last Time: %s\n", getTagValue("downLastTime", eElement));
                System.out.printf("End Mobile No: %s\n", getTagValue("endMobileNo", eElement));
                System.out.printf("End Station ID: %s\n", getTagValue("endStationId", eElement));
                System.out.printf("End Station Name: %s\n", getTagValue("endStationName", eElement));
                System.out.printf("Peek Alloc: %s\n", getTagValue("peekAlloc", eElement));
                System.out.printf("Region Name: %s\n", getTagValue("regionName", eElement));
                System.out.printf("Route ID: %s\n", getTagValue("routeId", eElement));
                System.out.printf("Route Name: %s\n", getTagValue("routeName", eElement));
                System.out.printf("Route Type Code: %s\n", getTagValue("routeTypeCd", eElement));
                System.out.printf("Route Type Name: %s\n", getTagValue("routeTypeName", eElement));
                System.out.printf("Start Mobile No: %s\n", getTagValue("startMobileNo", eElement));
                System.out.printf("Start Station ID: %s\n", getTagValue("startStationId", eElement));
                System.out.printf("Start Station Name: %s\n", getTagValue("startStationName", eElement));
                System.out.printf("Up First Time: %s\n", getTagValue("upFirstTime", eElement));
                System.out.printf("Up Last Time: %s\n", getTagValue("upLastTime", eElement));
                System.out.printf("Non-Peek Alloc: %s\n", getTagValue("nPeekAlloc", eElement));
                System.out.println();
            }
        }
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node != null) {
                return node.getTextContent();
            }
        }
       
        return "N/A";  // Default value if the tag is not found
    }
}
