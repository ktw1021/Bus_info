package bus;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class RouteId_Api_Explorer {
	public String getXMLData() throws IOException {
	    StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1613000/BusRouteInfoInqireService/getRouteInfoIem");
	    urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=aFaYNwN4cILVTvYDfYL3Cq37TtGoDHXLhbbk2qfEwXuVVhMMUtTdaJCoFAP%2F0%2F22YRvXvWs9OKOQB036Tj31Rg%3D%3D");
	    urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8"));
	    urlBuilder.append("&" + URLEncoder.encode("cityCode", "UTF-8") + "=" + URLEncoder.encode("25", "UTF-8"));
	    urlBuilder.append("&" + URLEncoder.encode("routeId", "UTF-8") + "=" + URLEncoder.encode("DJB30300004", "UTF-8"));
	    URL url = new URL(urlBuilder.toString());
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Content-type", "application/xml");

	    int responseCode = conn.getResponseCode();
	    System.out.println("Response code: " + responseCode);

	    BufferedReader rd;
	    if (responseCode >= 200 && responseCode <= 300) {
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
