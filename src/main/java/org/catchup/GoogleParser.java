package org.catchup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

public class GoogleParser extends Parser{

	private JSONArray results;
	
	public void getResultsAsJSONArray() throws JSONException
	{
		JSONObject obj2=(JSONObject) this.getResult().get(GoogleConstants.GO_OUTPUT_RESPONSEDATA);
    	JSONArray ar=obj2.getJSONArray(GoogleConstants.GO_OUTPUT_RESULTS);
    	this.setResults(ar);
	}

	public void setResults(JSONArray results) {
		this.results = results;
	}

	public JSONArray getResults() {
		return results;
	}
	
	public GoogleParser(JSONObject result)
	{
		super(result);
	}
	
	public News getNews(JSONObject obj) throws JSONException, ParseException
	{
		News news=null;		
		String content=obj.getString(GoogleConstants.GO_OUTPUT_CONTENT);
		String publisher=obj.getString(GoogleConstants.GO_OUTPUT_PUBLISHER);
		String publishedDate=obj.getString(GoogleConstants.GO_OUTPUT_PUBLISHEDDATE);
		SimpleDateFormat dateParser=new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		Date date=dateParser.parse(publishedDate);
		String url=obj.getString(GoogleConstants.GO_OUTPUT_URL);
		String location=obj.getString(GoogleConstants.GO_OUTPUT_LOCATION);
		String language=obj.getString(GoogleConstants.GO_OUTPUT_LANGUAGE);
		String title=obj.getString(GoogleConstants.GO_OUTPUT_TITLE);
		news=new News(content,publisher,date,url,location,language,title);
		return news;
	}
}
