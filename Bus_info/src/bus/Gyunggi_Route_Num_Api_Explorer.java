package bus;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class Gyunggi_Route_Num_Api_Explorer {
    public static String getXMLData() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6410000/busrouteservice/getBusRouteList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=aFaYNwN4cILVTvYDfYL3Cq37TtGoDHXLhbbk2qfEwXuVVhMMUtTdaJCoFAP%2F0%2F22YRvXvWs9OKOQB036Tj31Rg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode(Main_Application.getRouteName(), "UTF-8")); /*노선번호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
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

        return sb.toString();
    }
}
