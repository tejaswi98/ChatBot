/*
 * Name: Kota Naga Tejaswi LNU
 * Class: 2336
 * Assignment: Rest API Project
 */

import java.util.ArrayList;

import twitter4j.*;
import twitter4j.auth.AccessToken;

public class TwitterAPI {
	static ResponseList<Status> statuses;
	static ArrayList<String> stats;
	static ArrayList<String> names;
	public static void main(String[] args){
		//OAuth
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer("oG16G5RriwlGDLQcfxwz10bOn", "CXpwxZSVowI1tWxrXfedOMftkPuLwW1KxgGEvRF6MkTZECco7D");
		twitter.setOAuthAccessToken(new AccessToken("1881491874-U9LpvlNzOmozCsB9dlVv1GaF3jBjaZHe0WZwsr4","RtuNFU7CxGPJmFKVrH234x58araYm8zZqipg5LgLmSn2N"));
		
		try {
            //verify credentials
            User kota = twitter.verifyCredentials();
            ResponseList<Status> statuses = twitter.getHomeTimeline();
            //using arraylists to  send messages easier
            stats = new ArrayList<String>();
			names = new ArrayList<String>();
            for (Status s : statuses) {
              names.add(s.getUser().getScreenName());
              stats.add(s.getText());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Attempt Failed: " + te.getMessage());
            System.exit(-1);
        }
	}
}
