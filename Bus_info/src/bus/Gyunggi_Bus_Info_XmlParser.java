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

                String companyId = eElement.getElementsByTagName("companyId").item(0).getTextContent();
                String companyName = eElement.getElementsByTagName("companyName").item(0).getTextContent();
                String companyTel = eElement.getElementsByTagName("companyTel").item(0).getTextContent();
                String districtCd = eElement.getElementsByTagName("districtCd").item(0).getTextContent();
                String downFirstTime = eElement.getElementsByTagName("downFirstTime").item(0).getTextContent();
                String downLastTime = eElement.getElementsByTagName("downLastTime").item(0).getTextContent();
                String endMobileNo = eElement.getElementsByTagName("endMobileNo").item(0).getTextContent();
                String endStationId = eElement.getElementsByTagName("endStationId").item(0).getTextContent();
                String endStationName = eElement.getElementsByTagName("endStationName").item(0).getTextContent();
                String peekAlloc = eElement.getElementsByTagName("peekAlloc").item(0).getTextContent();
                String regionName = eElement.getElementsByTagName("regionName").item(0).getTextContent();
                String routeId = eElement.getElementsByTagName("routeId").item(0).getTextContent();
                String routeName = eElement.getElementsByTagName("routeName").item(0).getTextContent();
                String routeTypeCd = eElement.getElementsByTagName("routeTypeCd").item(0).getTextContent();
                String routeTypeName = eElement.getElementsByTagName("routeTypeName").item(0).getTextContent();
                String startMobileNo = eElement.getElementsByTagName("startMobileNo").item(0).getTextContent();
                String startStationId = eElement.getElementsByTagName("startStationId").item(0).getTextContent();
                String startStationName = eElement.getElementsByTagName("startStationName").item(0).getTextContent();
                String upFirstTime = eElement.getElementsByTagName("upFirstTime").item(0).getTextContent();
                String upLastTime = eElement.getElementsByTagName("upLastTime").item(0).getTextContent();
                String nPeekAlloc = eElement.getElementsByTagName("nPeekAlloc").item(0).getTextContent();

                System.out.printf("Company ID: %s\n", companyId);
                System.out.printf("Company Name: %s\n", companyName);
                System.out.printf("Company Tel: %s\n", companyTel);
                System.out.printf("District Code: %s\n", districtCd);
                System.out.printf("Down First Time: %s\n", downFirstTime);
                System.out.printf("Down Last Time: %s\n", downLastTime);
                System.out.printf("End Mobile No: %s\n", endMobileNo);
                System.out.printf("End Station ID: %s\n", endStationId);
                System.out.printf("End Station Name: %s\n", endStationName);
                System.out.printf("Peek Alloc: %s\n", peekAlloc);
                System.out.printf("Region Name: %s\n", regionName);
                System.out.printf("Route ID: %s\n", routeId);
                System.out.printf("Route Name: %s\n", routeName);
                System.out.printf("Route Type Code: %s\n", routeTypeCd);
                System.out.printf("Route Type Name: %s\n", routeTypeName);
                System.out.printf("Start Mobile No: %s\n", startMobileNo);
                System.out.printf("Start Station ID: %s\n", startStationId);
                System.out.printf("Start Station Name: %s\n", startStationName);
                System.out.printf("Up First Time: %s\n", upFirstTime);
                System.out.printf("Up Last Time: %s\n", upLastTime);
                System.out.printf("Non-Peek Alloc: %s\n", nPeekAlloc);
                System.out.println();
            }
        }
    }
}
