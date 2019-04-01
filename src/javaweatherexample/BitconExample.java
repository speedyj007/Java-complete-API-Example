package javaweatherexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class BitconExample{
    
    public static void main(String[] args) throws Exception {
        
        String rate = "INR";
        String url = "https://api.coindesk.com/v1/bpi/currentprice/"+rate+".json";
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
        
        JSONObject rate_object = new JSONObject(myresponse.getJSONObject("bpi").getJSONObject("INR").toString());
        
        
        System.out.println("");
        System.out.println("Currency : "+rate_object.getString("description"));
        System.out.println("Bitcoin Price : "+rate_object.getString("rate"));
        
        JSONObject time_object = new JSONObject(myresponse.getJSONObject("time").toString());
        System.out.println("Last updated on : "+time_object.getString("updated"));
        System.out.println("Last updated on : "+time_object.getString("updatedISO"));
        System.out.println("Last updated on : "+time_object.getString("updateduk"));
        
        
        System.out.println("");
        
        
        
    }
    
}
