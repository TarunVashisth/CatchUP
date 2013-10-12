package org.catchup;
import java.util.Date;

/**
 * 
 * @author ayubi
 *
 */
public class UserRequirements {

	/**
	 * Required arguments 
	 */
	
	private String queryString;
	private Date toDate;
	private Date fromDate;
	
	
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

	private String hostLanguage;
	private String location;
	private String newsEdition;
	private long resultsPerPage;
	private String resultsOrdering;
	private long startIndex;
	private String topicQuantifier;
	private String userip;
	
	public String getQueryString() {
		return queryString;
	}

	public Date getToDate() {
		return toDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public String getHostLanguage() {
		return hostLanguage;
	}

	public String getLocation() {
		return location;
	}

	public String getNewsEdition() {
		return newsEdition;
	}

	public long getResultsPerPage() {
		return resultsPerPage;
	}	

	public String getResultsOrdering() {
		return resultsOrdering;
	}

	public long getStartIndex() {
		return startIndex;
	}

	public String getTopicQuantifier() {
		return topicQuantifier;
	}

	public String getUserip() {
		return userip;
	}

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
		
		private String queryString;
		private Date toDate;
		private Date fromDate;
		
		
		//optional
		private String hostLanguage=GoogleConstants.GO_DEFAULT_HOST_LANGUAGE;
		private String location=GoogleConstants.GO_DEFAULT_USER_LOCATION;
		private String newsEdition=GoogleConstants.GO_DEFAULT_NEWS_EDITION;
		private long resultsPerPage=GoogleConstants.GO_DEFAULT_RESULTS_PERPAGE;
		private String resultsOrdering=GoogleConstants.GO_DEFAULT_RESULTS_ORDERING;
		private long startIndex=GoogleConstants.GO_DEFAULT_START_INDEX;
		private String topicQuantifier=GoogleConstants.GO_DEFAULT_TOPIC_QUANTIFIER;
		private String userip=GoogleConstants.GO_USER_IP;
		
		
		/**
		 * 
		 * @param query: The query string to be searched.
		 * @param d1	:The first date.
		 *
		 * @param d2	: The last date. d1<=d2 
		 */
		
		public UserRequirementsBuilder(String queryString, Date toDate,Date fromDate){
			
				this.queryString=queryString;
				this.fromDate=toDate;
				this.toDate=fromDate;
			
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
			
			this.queryString=query;
			long millisInADay=60*60*24*1000;
			Date today=new Date();
			this.toDate=today;
			long todayInMillis=today.getTime();
			long millisOfFromDate=todayInMillis-(range*millisInADay);
			this.fromDate=new Date(millisOfFromDate);
		}
		
		public UserRequirementsBuilder hostLanguage(String hostLanguage) {
			  this.hostLanguage = hostLanguage;
		      return this;
		    }

		 public UserRequirementsBuilder location(String location) {
			  this.location = location;
		      return this;
		    }
		 
		 public UserRequirementsBuilder newsEdition(String newsEdition) {
			  this.newsEdition = newsEdition;
		      return this;
		    }
		 public UserRequirementsBuilder resultsPerPage(long resultsPerPage) {
			  this.resultsPerPage = resultsPerPage;
		      return this;
		    }
		 
		 public UserRequirementsBuilder resultsOrdering(String resultsOrdering) {
			  this.resultsOrdering = resultsOrdering;
		      return this;
		    }

		 public UserRequirementsBuilder startIndex(long startIndex) {
			  this.startIndex = startIndex;
		      return this;
		    }
		 
		 public UserRequirementsBuilder topicQuantifier(String topicQuantifier) {
			  this.topicQuantifier = topicQuantifier;
		      return this;
		    }

		 public UserRequirementsBuilder userip(String userip) {
			  this.userip = userip;
		      return this;
		    }
		 
		 	/**
		 	 * Removing it since it is only required for Immuatable objects
		 	 * @return
		 	 */
		    public UserRequirements build() {
		      return new UserRequirements(this);
		    }
		
	}
		
	//TODO What about other requirements like language, geo location , results per page?
	//Another constructor which takes another Profile class and creates an object of UserRequirements.
	//What about different sub options of topic?
	//We can use Builder Pattern?
	//ref link:http://stackoverflow.com/questions/328496/when-would-you-use-the-builder-pattern
	
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