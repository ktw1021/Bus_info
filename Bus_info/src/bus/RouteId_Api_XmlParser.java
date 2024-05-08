package bus;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class RouteId_Api_XmlParser {
    public void parseXML(String xmlData) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new InputSource(new StringReader(xmlData)));
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("item");

        System.out.println("Parsing " + nList.getLength() + " items");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                // 데이터 항목 출력
                System.out.println("End Node Name: " + getElementTextContent(eElement, "endnodenm"));
                System.out.println("End Vehicle Time: " + getElementTextContent(eElement, "endvehicletime"));
                System.out.println("Interval Sat Time: " + getElementTextContent(eElement, "intervalsattime"));
                System.out.println("Interval Sun Time: " + getElementTextContent(eElement, "intervalsuntime"));
                System.out.println("Interval Time: " + getElementTextContent(eElement, "intervaltime"));
                System.out.println("Route ID: " + getElementTextContent(eElement, "routeid"));
                System.out.println("Route No: " + getElementTextContent(eElement, "routeno"));
                System.out.println("Route Type: " + getElementTextContent(eElement, "routetp"));
                System.out.println("Start Node Name: " + getElementTextContent(eElement, "startnodenm"));
                System.out.println("Start Vehicle Time: " + getElementTextContent(eElement, "startvehicletime"));
            }
        }
    }

    private String getElementTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return "Not Available"; // 태그가 없는 경우 예외 처리
    }
}
