package javaweatherexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class cyproRates{
    
    public static void main(String[] args) throws Exception {
        
        String rate = "INR";
        String url = "https://api.coinmarketcap.com/v1/ticker/ethereum/?apikey=b54bcf4d-1bca-4e8e-9a24-22ff2c3d462c&convert="+rate;
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
        
        
        System.out.println("");
        
        JSONObject myresponse = new JSONObject(inputLine);
        
        System.out.println("Currency "+myresponse);
        System.out.println("");
        
        
              
        
        
    }
    
}
