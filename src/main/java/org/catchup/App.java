package org.catchup;

import java.io.IOException;

import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.catchup.impl.GoogleFetcher;
import org.catchup.impl.GoogleQuery;
import org.slf4j.*;

/**
 * This Class is used to  
 *
 */
public class App 
{
	public final static Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main(String args[] ) throws IOException, JSONException
    {	
    	//TODO: Has to look into query formation, Depending on Ayubi's Code
    	Query query=new GoogleQuery("1.0","Barack Obama","121.242.198.2");
    	Fetcher fetcher=new GoogleFetcher();
    	JSONObject json=fetcher.Fetch(query);
    	logger.info(json.toString());
    }
}
