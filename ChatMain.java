/*
 * Name: Kota Naga Tejaswi LNU
 * Class: 2336
 * Assignment: Rest API Project
 */
import org.jibble.pircbot.*;

public class ChatMain {
	//main
	public static void main(String[] args) throws Exception{
		//connecting to the server
		ChatBot bot = new ChatBot();
		bot.setVerbose(true);
		bot.connect("irc.freenode.net");
		bot.joinChannel("#pircbot");

	}
}
