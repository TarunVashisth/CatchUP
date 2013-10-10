package org.catchup;
import java.util.Date;
import java.util.List;


public class GoogleNews extends News {

	List<News> relatedNews;
	String titleNoFormating;
	String unescapedURL;
	String clusterURL;
	String searchClass;
	Cursor cursor;
	GoogleImage image;

	/**
	 * 
	 * @param content
	 * @param publisher
	 * @param dateOfPublication
	 * @param url
	 * @param location
	 * @param language
	 * @param title
	 * @param relatedNews
	 * @param titleNoFormating
	 * @param unescapedURL
	 * @param clusterURL
	 * @param searchClass
	 * @param cursor
	 * @param image
	 */
	
	public GoogleNews(String content,
			String publisher,
			Date dateOfPublication,
			String url,
			String location,
			String language,
			String title,
			List<News> relatedNews,
			String titleNoFormating,
			String unescapedURL,
			String clusterURL,
			String searchClass,
			Cursor cursor,
			GoogleImage image
			) {
		
		super(content,publisher,dateOfPublication,url,location,language,title);
		this.relatedNews=relatedNews;
		this.titleNoFormating=titleNoFormating;
		this.unescapedURL=unescapedURL;
		this.clusterURL=clusterURL;
		this.searchClass=searchClass;
		this.cursor=cursor;
		this.image=image;
	}
	
	//Add Copy Constructor
	//Add accessor(get) methods
	//Add toString() method
	//Add hashcode mthod, compareTo is fine no need to override
	//Add exception handling for some fields
		
		
		
		
}
