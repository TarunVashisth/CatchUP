package org.catchup;

import java.text.ParseException;

import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

public abstract class Parser {
	
	private JSONObject result; 
	
	public Parser(JSONObject result)
	{
		this.setResult(result);
	}
	
	public Parser(){}
	
	public void setResult(JSONObject result) {
		this.result = result;
	}
	
	public JSONObject getResult() {
		return result;
	}
	
	public News getNews(JSONObject obj) throws JSONException, ParseException
	{
		News news=null;		
		return news;
	}
	
	
}
