package bus;

import java.util.Map;
import java.util.Scanner;

public class Main_Application {
	
    public static void main(String[] args) {
    	  Scanner scanner = new Scanner(System.in);  // 사용자 입력을 위한 Scanner 객체 생성

          try {
              // API Explorer 객체 생성 및 XML 데이터 가져오기
              CityCode_Api_Explorer explorer = new CityCode_Api_Explorer();
              String xmlData = explorer.getXMLData();

              // Manager 객체 생성 및 데이터 파싱
              CityCode_Manager manager = new CityCode_Manager(xmlData);

              // 사용자 입력을 받아 도시 코드 조회
              System.out.println("Enter the name of the city you want to find the code for:");
              String inputCity = scanner.nextLine();  // 도시 이름 입력 받기
              String cityCode = manager.getCityCode(inputCity);
              System.out.println("The code for " + inputCity + " is: " + cityCode);

          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              scanner.close();  // Scanner 자원 해제
          }
     
        
    	RouteId_Api_Explorer explorer = new RouteId_Api_Explorer();
        RouteId_Api_XmlParser parser = new RouteId_Api_XmlParser();

        try {
            String xmlData = explorer.getXMLData();
            parser.parseXML(xmlData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
}
