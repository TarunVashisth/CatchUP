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
			GoogleImage image){
		
		super(content,publisher,dateOfPublication,url,location,language,title);
		this.relatedNews=relatedNews;
		this.titleNoFormating=titleNoFormating;
		this.unescapedURL=unescapedURL;
		this.clusterURL=clusterURL;
		this.searchClass=searchClass;
		this.cursor=cursor;
		this.image=image;
	}
	
	public GoogleNews(GoogleNews that){
		super(that.getContent(),
			that.getPublisher(),
			that.getDateOfPublication(),
			that.getUrl(),
			that.getLocation(),
			that.getLanguage(),
			that.getTitle());
			
		this.relatedNews=that.getRelatedNews();
		
		this.titleNoFormating=that.getTitleNoFormatting();
	
		this.unescapedURL=that.getUnescapedURL();
	
		this.clusterURL=that.getClusterURL();
	
		this.searchClass=that.getSearchClass();
	
		this.cursor=that.getCursor();

		this.image=that.getImage();
		
	
	
	}

	public List<News> getRelatedNews(){
		return this.relatedNews;
	}
	public String getTitleNoFormatting(){
		return this.titleNoFormating;
	}
	public String getUnescapedURL(){
		return this.unescapedURL;
	}
	public String getClusterURL(){
		return this.clusterURL;
	}
	public String getSearchClass(){
		return this.searchClass;
	}
	public Cursor getCursor(){
		return this.cursor;
	}
	public GoogleImage getImage(){
		return this.image;
	}
	
	
	@Override
	public String toString(){
		StringBuilder builder=new StringBuilder();
		builder.append("{");
		builder.append(super.toString());
		
		//GoogleNews Fields appended here
		
		builder.append(" Related News: "+this.relatedNews.toString());
		builder.append(" Title No Formatting: "+this.titleNoFormating);
		builder.append(" Unescaped URL: "+this.unescapedURL);
		builder.append(" Cluster URL: "+this.clusterURL);
		builder.append(" Search Class: "+this.searchClass);
		builder.append(" Cursor: "+this.cursor.toString());
		builder.append(" Image: "+this.image.toString());
		
		builder.append("}");
		return builder.toString();		
		}
	
}
