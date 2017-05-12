/*
 * Name: Kota Naga Tejaswi LNU
 * Class: 2336
 * Assignment: Rest API Project
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
 
public class WeatherAPI
{
	//static variables
	static String uCity;
	static StringBuilder result;
	//main method
    public static void main(String[] args)
    {
        try {
        	//calls to the api
        	String weatherURL = "http://api.openweathermap.org/data/2.5/weather?q=" + uCity + "&APPID=2045126796536689aa40d7f7d49fd496";             //please get your own token to use from API.Openweathermap
        	//Json Response
        	result = new StringBuilder(); 
        	URL url = new URL(weatherURL);
        	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        	conn.setRequestMethod("GET");
        	BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        	String line;
        	//reads the output
        	while ((line = rd.readLine()) != null) {
        		result.append(line);
        	}
        	rd.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Minimum Temperature
    static double parseMinTemp(String json){
    	JsonElement jelement = new JsonParser().parse(json);
    	JsonObject MasterWeatherObject = jelement.getAsJsonObject();
    	JsonObject mainObject = MasterWeatherObject.getAsJsonObject("main");
    	double minTemp = mainObject.get("temp_min").getAsDouble();
    	double minTempF = minTemp * 9/5 - 459.67;
    	//Double minT = minTempF;
    	return minTempF;
    }
    //Maximum Temperature
    static double parseMaxTemp(String json){
    	JsonElement jelement = new JsonParser().parse(json);
    	JsonObject MasterWeatherObject = jelement.getAsJsonObject();
    	JsonObject mainObject = MasterWeatherObject.getAsJsonObject("main");
    	double maxTemp = mainObject.get("temp_max").getAsDouble();
    	double maxTempF = maxTemp * 9/5 - 459.67;
    	//Double minT = minTempF;
    	return maxTempF;
    }
    //Current Temperature
    static double parseTemp(String json){
    	JsonElement jelement = new JsonParser().parse(json);
    	JsonObject MasterWeatherObject = jelement.getAsJsonObject();
    	JsonObject mainObject = MasterWeatherObject.getAsJsonObject("main");
    	double temp = mainObject.get("temp").getAsDouble();
    	double tempF = temp * 9/5 - 459.67;
    	//Double minT = minTempF;
    	return tempF;
    }
       
}