package org.catchup.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.catchup.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author vashisth
 * Google's Implementation of Fetcher. It is used for fetching data from Google News and storing it into JsonObject.
 */
public class GoogleFetcher implements Fetcher{

	Logger logger = LoggerFactory.getLogger(App.class);

	/**
	 * Builds a Query, Sends to google api and retrieves the data from there.
	 */
	public JSONObject Fetch(Query query) throws IOException, JSONException {
		URL url = new URL(query.returnQuery());
		URLConnection connection = url.openConnection();
		
		String line;
		StringBuilder builder = new StringBuilder();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		while((line = reader.readLine()) != null) {
			builder.append(line);
		}
		
		JSONObject json = new JSONObject(builder.toString());
		return json;
	}
	
}
