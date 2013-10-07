package org.catchup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class UserRequirements {

	String queryString;
	Date toDate;
	Date fromDate;
	
	/**
	 * 
	 * @param query: The query string to be searched.
	 * @param d1	:The first date.
	 *
	 * @param d2	: The last date. d1<=d2 
	 */
	
	
	public UserRequirements(String query, Date d1,Date d2){
		
		if(!query.equals(""))
			this.queryString=query.contains(" ")?queryCleaner(query):query;
			else
				throw new IllegalArgumentException("Query String is NULL!!!");
		if(!(d1==null||d2==null)){
			this.fromDate=d1;
			this.toDate=d2;
		}
		else
			throw new IllegalArgumentException("One of the dates supplied are NULL!!!");
		
	}
	/**
	 * 
	 * @param query: The query string to be searched.
	 * @param range: An integer specifying the number of days to be searched backwards for aggregating the news item
	 * I have not used an enum or HashMap to specify range e.g. last three days=3 because of loose coupling between
	 * client code and UserRequirements class. The client has to be map the String with with number of days to be searched
	 * backwards. This class has to know only the range of days. With this, any number of days can be supplied here to
	 * be searched.
	 * 
	 * 
	 */
	
	public UserRequirements(String query, long range){
		
		if(!query.equals(""))
		this.queryString=query.contains(" ")?queryCleaner(query):query;
		else
			throw new IllegalArgumentException("Query String is NULL!!!");
		
		if(range>0){
			long millisInADay=60*60*24*1000;
			Date today=new Date();
			this.toDate=today;
			long todayInMillis=today.getTime();
		
			long fromDate=todayInMillis-range*(millisInADay);
			this.fromDate=new Date(fromDate);
	
		}
		else
			throw new IllegalArgumentException("Range is Negative, please provide a positive number!!!");
	}
	/**
	 * 
	 * @param query
	 * @return cleaned query ie the spaces replaced with %20
	 */
	private String queryCleaner(String query){
		
		String cleanedQuery=query.replaceAll(" ", "%20");
		return cleanedQuery;
	}
	/**
	 * Testing the above methods
	 * 
	 */
	public static void main(String...args)throws Exception{
		UserRequirements ur=new UserRequirements("Barack Obama's New Foreign Policy", 3);
		UserRequirements ur1=new UserRequirements("Barack Obama", new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH).parse(""),new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH).parse(ur.toDate.toString()));

		
		System.out.println(ur.queryString);

		System.out.println(ur.fromDate);

		System.out.println(ur.toDate);

		System.out.println(ur1.queryString);
		System.out.println(ur1.fromDate);

		System.out.println(ur1.toDate);

	/*
	 * Sample Output:
Barack%20Obama
Fri Oct 04 18:51:44 IST 2013
Mon Oct 07 18:51:44 IST 2013
Barack%20Obama
Fri Oct 04 18:51:44 IST 2013
Mon Oct 07 18:51:44 IST 2013	
	 */

	}

}