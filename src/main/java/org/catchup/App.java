package org.catchup;

import java.io.IOException;
import java.text.ParseException;

import org.apache.sling.commons.json.JSONArray;
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
	
    public static void main(String args[] ) throws IOException, JSONException, ParseException
    {	
    	//TODO: Has to look into query formation, Depending on Ayubi's Code
    	Query query=new GoogleQuery("1.0","Barack Obama","121.242.198.2");
    	Fetcher fetcher=new GoogleFetcher();
    	JSONObject jsonObject=fetcher.Fetch(query);
    	logger.info(jsonObject.toString());
    	GoogleParser parser=new GoogleParser(jsonObject);
    	parser.getResultsAsJSONArray();
    	for(int i=0;i<parser.getResults().length();i++)
    	{
    		News news=parser.getNews(parser.getResults().getJSONObject(i));
    		logger.info(news.toString());
    	}
    }
}
