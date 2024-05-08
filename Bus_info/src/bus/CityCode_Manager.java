package bus;

import java.util.Map;

public class CityCode_Manager {
    private Map<String, String> cityCodeMap;

    // Constructor: XML 데이터를 받아 맵을 생성
    public CityCode_Manager(String xmlData) throws Exception {
        CityCode_Api_XmlParser xmlParser = new CityCode_Api_XmlParser();
        this.cityCodeMap = xmlParser.parseXML(xmlData);
    }

    // 도시 이름으로 도시 코드를 조회하는 메서드
    public String getCityCode(String cityName) {
        String key = cityCodeMap.keySet().stream()
            .filter(k -> k.contains(cityName) || cityName.contains(k))
            .findFirst()
            .orElse("Not Found");
        return cityCodeMap.getOrDefault(key, "Not Found");
    }


    // 맵에 있는 모든 도시 정보 출력 (옵션)
    public void printAllCities() {
        cityCodeMap.forEach((name, code) -> System.out.println("City Name: " + name + ", City Code: " + code));
    }
}
