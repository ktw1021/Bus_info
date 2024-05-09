package bus;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import bus.Gyunggi_Route_Num_Api_XmlParser.RouteInfo;

public class Main_Application {

private static String cityCode;
private static String bus_num;
private static String routeName;	
private static Scanner scanner = new Scanner(System.in);
private static String bus_id;


public static String getBus_id() {
	return bus_id;
}
public static void setBus_id(String bud_id) {
	Main_Application.bus_id = bud_id;
}
public static String getRouteName() {
	return routeName;
}
public static void setRouteName(String routeName) {
	Main_Application.routeName = routeName;
}
public static String getBus_num() {
	return bus_num;
}
public static void setBus_num(String bus_num) {
	Main_Application.bus_num = bus_num;
}
public static String getCityCode() {
	return cityCode;
}
public static void setCityCode(String cityCode) {
	Main_Application.cityCode = cityCode;
}

	public static void main(String[] args) {

		 
//    	 try {
//              // API Explorer 객체 생성 및 XML 데이터 가져오기
//              CityCode_Api_Explorer cc_explorer = new CityCode_Api_Explorer();
//              String cc_xmlData;
//              cc_xmlData = cc_explorer.getXMLData();
//              // Manager 객체 생성 및 데이터 파싱
//              CityCode_Manager manager = new CityCode_Manager(cc_xmlData);
//
//              // 사용자 입력을 받아 도시 코드 조회
//              System.out.println("Enter the name of the city you want to find the code for:");
//              String inputCity = scanner.nextLine();  // 도시 이름 입력 받기
//              cityCode = manager.getCityCode(inputCity);
//              System.out.println("The code for " + inputCity + " is: " + cityCode);
//              setCityCode(cityCode);
//              System.out.println("검색할 버스 번호를 입력하세요");
//              bus_num = scanner.next();
//              setBus_num(bus_num);
//              
//    	  	} catch (IOException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//    	  
		try {
	        // 사용자 입력을 받아 라우트 이름을 조회
	        System.out.print("Enter the Route Name to find the Route ID: ");
	        routeName = scanner.nextLine();
	        setRouteName(routeName);
	        
	        // API에서 XML 데이터 가져오기
	        String xmlData = Gyunggi_Route_Num_Api_Explorer.getXMLData();
	        
	        // 데이터 파싱
	        Gyunggi_Route_Num_Api_XmlParser parser = new Gyunggi_Route_Num_Api_XmlParser();
	        List<RouteInfo> routes = parser.parseXML(xmlData);

	        // 입력받은 라우트 이름에 해당하는 ID 찾기
	        boolean found = false;
	        for (RouteInfo info : routes) {
	            if (info.getRouteName().equals(routeName)) {
	                System.out.println("Route ID for " + routeName + " is: " + info.getRouteId());
	                setBus_id(info.getRouteId());
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("No route found for the name: " + routeName);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    	  
		 try {
	            String xmlData = Gyunggi_Bus_Info_Api_Explorer.getXMLData(); // XML 데이터를 API로부터 가져옵니다.
	            Gyunggi_Bus_Info_XmlParser parser = new Gyunggi_Bus_Info_XmlParser(); // 파싱 클래스를 인스턴스화합니다.
	            parser.parseXML(xmlData); // 가져온 XML 데이터를 파싱 메서드에 전달합니다.
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
//    	 Route_Num_Api_Explorer busNum_explorer = new Route_Num_Api_Explorer();
//    	 Route_Num_Api_XmlParser busNum_parser = new Route_Num_Api_XmlParser();
//    	 
//    	 try {
//    		 String busNum_xmlData = busNum_explorer.getXMLData();
//    		 busNum_parser.parseXML(busNum_xmlData);
//    	 } catch(Exception e) {
//    		 e.printStackTrace();
//    	 }
//    	 
//    	 
//    	  
//    	RouteId_Api_Explorer explorer = new RouteId_Api_Explorer();
//        RouteId_Api_XmlParser parser = new RouteId_Api_XmlParser();
//
//        try {
//            String xmlData = explorer.getXMLData();
//            parser.parseXML(xmlData);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
        
        scanner.close();  // Scanner 자원 해제
    }
}
