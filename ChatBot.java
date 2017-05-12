/*
 * Name: Kota Naga Tejaswi LNU
 * Class: 2336
 * Assignment: Rest API Project
 */
import java.text.DecimalFormat;
import org.jibble.pircbot.*;

public class ChatBot extends PircBot {
	
	public ChatBot(){
		this.setName("MyChatBot");
	}
	//checks message and then does the following
	public void onMessage(String channel, String sender, String login, String hostname, String message){
		//for weather
		if(message.equalsIgnoreCase("weather") || message.endsWith("weather") 
				|| message.contains("weather") || message.matches("weather") ||
				message.startsWith("weather")){
			//WeatherAPI weath = new WeatherAPI();
			WeatherAPI.uCity = "Dallas";
			//calling WeatherAPI's main method
			WeatherAPI.main(null);
			//to only display two decimal points
			DecimalFormat df = new DecimalFormat("#.##");
			String cur = df.format(WeatherAPI.parseTemp(WeatherAPI.result.toString()));
			String min = df.format(WeatherAPI.parseMinTemp(WeatherAPI.result.toString()));
			String max = df.format(WeatherAPI.parseMaxTemp(WeatherAPI.result.toString()));
			sendMessage(channel, ": Dallas Weather:" + " Cur Temp: "+ cur + "°F" + "  |  Min Temp: " + min + "°F  |  Max Temp: " + max + "°F");
		}
		//if anyone says twitter or timeline
		if(message.equalsIgnoreCase("twitter") || message.endsWith("twitter") 
				|| message.contains("twitter") || message.matches("twitter") ||
				message.startsWith("twitter") || message.equalsIgnoreCase("timeline") || message.endsWith("timeline") 
				|| message.contains("timeline") || message.matches("timeline") ||
				message.startsWith("timeline")){
			TwitterAPI.main(null);
			
			//sends message to the server with twitter names and statuses
			sendMessage(channel, sender + " Timeline:");
			for(int i = 0; i < TwitterAPI.names.size(); i++){
				sendMessage(channel, sender + " @" + TwitterAPI.names.get(i) + " tweeted: " + TwitterAPI.stats.get(i));
			}
		}
		//for time
		if (message.equalsIgnoreCase("time")) {
	        String time = new java.util.Date( ).toString( );
	        sendMessage(channel, sender + ": The time is " + time);
	    }
	}
}
