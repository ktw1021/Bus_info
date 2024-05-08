package bus;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main_Application {

private static String cityCode;
private static String bus_num;
	
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
    	  Scanner scanner = new Scanner(System.in);  // 사용자 입력을 위한 Scanner 객체 생성
    	  try {
              // API Explorer 객체 생성 및 XML 데이터 가져오기
              CityCode_Api_Explorer cc_explorer = new CityCode_Api_Explorer();
              String cc_xmlData;
              cc_xmlData = cc_explorer.getXMLData();
              // Manager 객체 생성 및 데이터 파싱
              CityCode_Manager manager = new CityCode_Manager(cc_xmlData);

              // 사용자 입력을 받아 도시 코드 조회
              System.out.println("Enter the name of the city you want to find the code for:");
              String inputCity = scanner.nextLine();  // 도시 이름 입력 받기
              cityCode = manager.getCityCode(inputCity);
              System.out.println("The code for " + inputCity + " is: " + cityCode);
              setCityCode(cityCode);
              System.out.println("검색할 버스 번호를 입력하세요");
              bus_num = scanner.next();
              setBus_num(bus_num);
              
    	  	} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
        
    	 Route_Num_Api_Explorer busNum_explorer = new Route_Num_Api_Explorer();
    	 Route_Num_Api_XmlParser busNum_parser = new Route_Num_Api_XmlParser();
    	 
    	 try {
    		 String busNum_xmlData = busNum_explorer.getXMLData();
    		 busNum_parser.parseXML(busNum_xmlData);
    	 } catch(Exception e) {
    		 e.printStackTrace();
    	 }
    	 
    	 
    	  
    	RouteId_Api_Explorer explorer = new RouteId_Api_Explorer();
        RouteId_Api_XmlParser parser = new RouteId_Api_XmlParser();

        try {
            String xmlData = explorer.getXMLData();
            parser.parseXML(xmlData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        scanner.close();  // Scanner 자원 해제
    }
}
