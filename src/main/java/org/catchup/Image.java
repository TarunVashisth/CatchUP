package org.catchup;

/**
 * 
 * @author ayubi
 *
 */
public class Image {

	private String title;
	private String url;
	private String publisher;
	
	
	public Image(String title,String url,String publisher){
		this.title=title;
		this.url=url;
		this.publisher=publisher;
	}
	
	public String getTitle(){
		return title;
	}
	public String getURL(){
		return url;
		
	}
	public String getPublisher(){
		return publisher;
	}
}
