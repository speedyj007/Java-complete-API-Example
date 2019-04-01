package javaweatherexample;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class JavaWeatherExample {

    public static void main(String[] args) throws Exception {

        Object ob = new JSONParser().parse(new FileReader("D:\\prabeer\\Data\\java\\Coding\\weatherData.json"));
        
        JSONObject jo = (JSONObject) ob;
        
        
        Map location = (Map) jo.get("location");
        
        Iterator<Map.Entry> itrl = location.entrySet().iterator();
        while(itrl.hasNext())
        {
            Map.Entry pair = itrl.next();
            System.out.println(pair.getKey()+" : "+pair.getValue());
            
            
        }
        
        System.out.println("");
        
        
        Map current = (Map) jo.get("current");
        
        Iterator<Map.Entry> itrl2 = current.entrySet().iterator();
        while(itrl2.hasNext())
        {
            Map.Entry pair = itrl2.next();
            System.out.println(pair.getKey()+" : "+pair.getValue());
            
            
        }
        
    }
    
}
