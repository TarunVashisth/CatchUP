package org.catchup;

import java.io.IOException;

import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

/**
 * 
 * @author vashisth
 * Every Provider has to implement this interface to fetch data from respective providers
 */
public interface Fetcher {
	public JSONObject Fetch(Query query) throws IOException, JSONException;
	
}
