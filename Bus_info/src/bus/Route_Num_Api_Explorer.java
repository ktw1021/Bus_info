package bus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Route_Num_Api_Explorer {

    public String getXMLData() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1613000/BusRouteInfoInqireService/getRouteNoList");
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=aFaYNwN4cILVTvYDfYL3Cq37TtGoDHXLhbbk2qfEwXuVVhMMUtTdaJCoFAP%2F0%2F22YRvXvWs9OKOQB036Tj31Rg%3D%3D");
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("cityCode","UTF-8") + "=" + URLEncoder.encode(Main_Application.getCityCode(), "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("routeNo","UTF-8") + "=" + URLEncoder.encode(Main_Application.getBus_num(), "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/xml"); // 데이터 타입에 맞게 수정
        System.out.println("Request URL: " + url.toString()); // 요청 URL 확인을 위한 출력
        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        String responseXML = sb.toString();
        System.out.println("Response XML: " + responseXML); // 전체 응답 출력
        return responseXML;
    }
}
