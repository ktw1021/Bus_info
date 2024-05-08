package bus;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class CityCode_Api_XmlParser {

    public Map<String, String> parseXML(String xmlData) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new InputSource(new StringReader(xmlData)));
        doc.getDocumentElement().normalize();

        NodeList itemList = doc.getElementsByTagName("item");
        Map<String, String> cityMap = new HashMap<>();
        cityMap.put("서울시","11");
        for (int i = 0; i < itemList.getLength(); i++) {
            Node itemNode = itemList.item(i);

            if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                Element itemElement = (Element) itemNode;
                String cityCode = getElementTextContent(itemElement, "citycode");
                String cityName = getElementTextContent(itemElement, "cityname");
                cityMap.put(cityName, cityCode);
                System.out.printf("%s, %s%n",cityName,cityCode);
            }
        }
        return cityMap;
    }
   
    
    private String getElementTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node != null) {
                return node.getTextContent();
            }
        }
        return "Not Available";
    }
}
