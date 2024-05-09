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

        // 오류 메시지 처리
        if (doc.getDocumentElement().getNodeName().equals("OpenAPI_ServiceResponse")) {
            NodeList nList = doc.getElementsByTagName("header");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String resultCode = eElement.getElementsByTagName("resultCode").item(0).getTextContent();
                    String resultMsg = eElement.getElementsByTagName("resultMsg").item(0).getTextContent();
                    System.out.println("Error Code: " + resultCode);
                    System.out.println("Error Message: " + resultMsg);
                }
            }
        } else {
            // 정상적인 데이터 처리 로직
            NodeList nList = doc.getElementsByTagName("busRouteList");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String routeId = eElement.getElementsByTagName("routeid").item(0).getTextContent();
                    String routeNo = eElement.getElementsByTagName("routeno").item(0).getTextContent();
                    String routeTp = eElement.getElementsByTagName("routetp").item(0).getTextContent();
                    System.out.printf("Route ID : %s\n", routeId);
                    System.out.printf("Route No : %s\n", routeNo);
                    System.out.printf("Route Type : %s\n", routeTp);
                }
            }
        }
    }
}
