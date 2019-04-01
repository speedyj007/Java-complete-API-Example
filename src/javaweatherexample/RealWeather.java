package javaweatherexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class RealWeather{
    
    public static void main(String[] args) throws Exception {
        
        String country = "Pune";
        String url = "http://api.apixu.com/v1/current.json?key=3e61d4a187704cccb1a195826193003&q="+country;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        
        int rc = con.getResponseCode();
        System.out.println("\nSending  'GET' Request to URL : "+url);
        System.out.println("Response Code : "+rc);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        String inputLine;
        
        StringBuffer response = new StringBuffer();
        
        while((inputLine = in.readLine())!=null)
        {
            response.append(inputLine);
        }
        in.close();
        
        
        
        JSONObject myresponse = new JSONObject(response.toString());

        
        System.out.println("");
        
        JSONObject country_object = new JSONObject(myresponse.getJSONObject("location").toString());
        
        
        
        JSONObject location_object = new JSONObject(myresponse.getJSONObject("current").toString());
        
        System.out.println("");
        System.out.println("Country : "+country_object.getString("country"));
        System.out.println("City : "+country_object.getString("name"));
        System.out.println("Last updated on : "+country_object.getString("localtime"));
        
        
        System.out.println("");
        
        
        System.out.println("Temperature : "+location_object.getInt("temp_c"));
        System.out.println("TimeStamp : "+location_object.getString("last_updated"));
        System.out.println("Wind Degree : "+location_object.getInt("wind_degree"));
        System.out.println("Wind Speed : "+location_object.getInt("gust_kph"));
        System.out.println("Wind Pressure : "+location_object.getInt("pressure_in"));
        System.out.println("humidity : "+location_object.getInt("humidity"));
    }
    
}
