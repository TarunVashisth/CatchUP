package org.catchup;

/**
 * 
 * @author ayubi
 *
 */
public abstract class Image {

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
	
	public String toString(){
		StringBuilder builder=new StringBuilder();
		builder.append("{");
		builder.append(" Image title: "+this.title);
		builder.append(" Image URL: "+this.url);
		builder.append(" Image Publisher: "+this.publisher);
		builder.append("}");
		return builder.toString();
	}
}
