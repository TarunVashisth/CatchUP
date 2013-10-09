package org.catchup;

/**
 * 
 * @author vashisth
 * This Class consists of all the Constants which are required for query formation from google apis.
 */
public interface GoogleConstants {

	public static final String GO_DEFAULT_PATH = "https://ajax.googleapis.com/ajax/services/search/news?";
	public static final String GO_VERSION= "v";
	public static final String GO_QUERY= "q";
	public static final String GO_USER_IP="userip";
	
	
	public static final String DDEFAULT_HOST_LANGUAGE="en";
	public static final String DDEFAULT_USER_LOCATION="us";
	public static final String DDEFAULT_NEWS_EDITION="us";
	public static final long DDEFAULT_RESULTS_PERPAGE=8;
	public static final String DDEFAULT_RESULTS_ORDERING="d";
	public static final long DDEFAULT_START_INDEX=0;
	public static final String DDEFAULT_TOPIC_QUANTIFIER="h";
	
	
}
