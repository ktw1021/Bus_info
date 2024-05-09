package bus;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Gyunggi_Route_Num_Api_XmlParser {

    private List<RouteInfo> routeList = new ArrayList<>();

	public List<RouteInfo> getRouteList() {
		return routeList;
	}

	public void setRouteList(List<RouteInfo> routeList) {
		this.routeList = routeList;
	}

	public List<RouteInfo> parseXML(String xmlData) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        InputSource is = new InputSource(new StringReader(xmlData));
        Document doc = builder.parse(is);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("busRouteList");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String routeName = eElement.getElementsByTagName("routeName").item(0).getTextContent();
                String routeId = eElement.getElementsByTagName("routeId").item(0).getTextContent();

                routeList.add(new RouteInfo(routeName, routeId));
            }
        }
        return routeList;
    }

    static class RouteInfo {
        private String routeName;
        private String routeId;

        public RouteInfo(String routeName, String routeId) {
            this.routeName = routeName;
            this.routeId = routeId;
        }

        public String getRouteName() {
            return routeName;
        }

        public String getRouteId() {
            return routeId;
        }
    }
}
