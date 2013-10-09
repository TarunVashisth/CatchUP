package org.catchup;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class UserRequirements {

	/**
	 * Required arguments 
	 */
	
	String queryString;
	Date toDate;
	Date fromDate;
	
	
	/**
	 * Optional arguments that can be set or left unset for the default value to be used
	 * 
	 * host language: English(US)
	 * location:US
	 * newsEdition:US
	 * resultsPerPage:8(This argument supplies an integer from 1–8 indicating the number of results to return per page.)
	 * resultsOrdering:d(sort by date)
	 * startIndex:0
	 * topicQuantifier:h
	 * 
	 * 	h - specifies the top headlines topic
		w - specifies the world topic
		b - specifies the business topic
		n - specifies the nation topic
		t - specifies the science and technology topic
		el - specifies the elections topic
		p - specifies the politics topic
		e - specifies the entertainment topic
		s - specifies the sports topic
		m - specifies the health topic
	 * 
	 * userip:""
	 */

	String hostLanguage;
	String location;
	String newsEdition;
	long resultsPerPage;
	String resultsOrdering;
	long startIndex;
	String topicQuantifier;
	String userip;
	
	private UserRequirements(UserRequirementsBuilder builder){
		//required
		this.queryString=builder.queryString;
		this.fromDate=builder.fromDate;
		this.toDate=builder.toDate;
		
		//optional
		this.hostLanguage=builder.hostLanguage;
		this.location=builder.location;
		this.newsEdition=builder.newsEdition;
		this.resultsPerPage=builder.resultsPerPage;
		this.resultsOrdering=builder.resultsOrdering;
		this.startIndex=builder.startIndex;
		this.topicQuantifier=builder.topicQuantifier;
		this.userip=builder.userip;
		
		
	}
	
	
	
	
	public static class UserRequirementsBuilder{
		
		//required
		
		String queryString;
		Date toDate;
		Date fromDate;
		
		
		//optional
		String hostLanguage=GoogleConstants.DDEFAULT_HOST_LANGUAGE;
		String location=GoogleConstants.DDEFAULT_USER_LOCATION;
		String newsEdition=GoogleConstants.DDEFAULT_NEWS_EDITION;
		long resultsPerPage=GoogleConstants.DDEFAULT_RESULTS_PERPAGE;
		String resultsOrdering=GoogleConstants.DDEFAULT_RESULTS_ORDERING;
		long startIndex=GoogleConstants.DDEFAULT_START_INDEX;
		String topicQuantifier=GoogleConstants.DDEFAULT_TOPIC_QUANTIFIER;
		String userip=GoogleConstants.GO_USER_IP;
		
		
		/**
		 * 
		 * @param query: The query string to be searched.
		 * @param d1	:The first date.
		 *
		 * @param d2	: The last date. d1<=d2 
		 */
		
		public UserRequirementsBuilder(String query, Date d1,Date d2){
			
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
		
		public UserRequirementsBuilder(String query, long range){
			
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
				throw new IllegalArgumentException("Date Range is Negative, please provide a positive number!!!");
		}
		
		
		 public UserRequirementsBuilder hostLanguage(String hostLanguage) {
		      if(!hostLanguage.equals(""))
			  this.hostLanguage = hostLanguage;
		      
		      else
					throw new IllegalArgumentException("hostLanguage(Host language) is null!!!");

		      
		      return this;
		    }

		 public UserRequirementsBuilder location(String location) {
		      if(!location.equals(""))
			  this.location = location;

		      else
					throw new IllegalArgumentException("location(Host location) is null!!!");

		      
		      return this;
		    }
		 public UserRequirementsBuilder newsEdition(String newsEdition) {
		      if(!newsEdition.equals(""))
			  this.newsEdition = newsEdition;
		      
		      else
					throw new IllegalArgumentException("newsEdition(News Edition) is null!!!");

		      return this;
		    }
		 public UserRequirementsBuilder resultsPerPage(long resultsPerPage) {
		      if(resultsPerPage>0)
			  this.resultsPerPage = resultsPerPage;
		      
		      else
					throw new IllegalArgumentException("resultsPerPage(results per page) is negative");

		      return this;
		    }
		 public UserRequirementsBuilder resultsOrdering(String resultsOrdering) {
		      if(!resultsOrdering.equals(""))
			  this.resultsOrdering = resultsOrdering;
		      
		      else
					throw new IllegalArgumentException("resultsOrdering(Results ordering) is null");

		      return this;
		    }

		 public UserRequirementsBuilder startIndex(long startIndex) {
		      if(startIndex>0)
			  this.startIndex = startIndex;
		      
		      else
					throw new IllegalArgumentException("startIndex (Start Index)is negative!!!");

		      return this;
		    }
		 
		 public UserRequirementsBuilder topicQuantifier(String topicQuantifier) {
		      if(!topicQuantifier.equals(""))
			  this.topicQuantifier = topicQuantifier;
		      
		      else
					throw new IllegalArgumentException("topicQuantifier(Topic Quantifier) is null!!!");

		      return this;
		    }

		 public UserRequirementsBuilder userip(String userip) {
		      
			 
			 if(!(userip.equals(""))&&validateIP(userip))
			  this.userip = userip;
			 
		      else
					throw new IllegalArgumentException("userip (User IP Address) is either null or invalid!!!");

		      return this;
		    }
		 
		 
		    public UserRequirements build() {
		      return new UserRequirements(this);
		    }
		
		
		  private boolean validateIP(String ip){
			  String[] ipVals=userip.split(".");
			  boolean result=true;
			  
			  if(ipVals.length!=4)
				  result=false;
			  for(String i:ipVals){
				  Integer j=Integer.parseInt(i);
				  if((j<0||j>255)){
					  result=false;
					  break;
				  }
				}
			  
				 return result;
		  }
		    
		    
		/**
		 * 
		 * @param query
		 * @return cleaned query i.e the spaces replaced with %20
		 */
		private String queryCleaner(String query){
			
			String cleanedQuery=query.replaceAll(" ", "%20");
			return cleanedQuery;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//TODO What about other requirements like language, geo location , results per page?
	//Another constructor which takes another Profile class and creates an object of UserRequirements.
	//What about different sub options of topic?
	//We can use Builder Pattern?
	
	
	/**
	 * Testing the above methods
	 * 
	 */
	public static void main(String...args)throws Exception{
		//UserRequirements ur=new UserRequirements("Barack Obama's New Foreign Policy", 3);
		//UserRequirements ur1=new UserRequirements("Barack Obama", new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH).parse(""),new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH).parse(ur.toDate.toString()));

		UserRequirements ur = new UserRequirements.UserRequirementsBuilder("barack obama",3).resultsOrdering("d").build();
      
		
		
		System.out.println(ur.queryString);

		System.out.println(ur.fromDate);

		System.out.println(ur.toDate);

		//System.out.println(ur1.queryString);
		//System.out.println(ur1.fromDate);

		//System.out.println(ur1.toDate);

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