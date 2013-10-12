package org.catchup;

import java.util.Date;
/**
 * 
 * @author ayubi
 *
 *This class forms the base implementation of all the News class. The fields are generic and will be 
 *present in any News class sub classed from it. All the parameters are checked for null and are guaranteed to 
 *be present.
 *it can be compared and sorted according to date. The equals method checks for the equality of all the
 *fields.
 *Note: The compareTo method will not necessarily return zero for equal News objects. This is by design
 *to facilitate sorting according to date.
 *For sorting by any other field, the third party class need to implement their own Comparator.
 *I have tried to make this class immutable. All the information needed to create the object
 *is provided at creation time. The instance can't be modified hence. This will facilitate
 *synchronization, performance, thread safety and will avoid everything that comes along with mutability.
 *For more: Effective Java :Item 15(Minimize Mutability)
 *
 */

public abstract class News implements Comparable<News>{

	private String content;
	private String publisher;
	private Date dateOfPublication;
	private String url;
	private String location;
	private String language;
	private String title;
	
	/**
	 * 
	 * @param content The content of the news item
	 * @param publisher The publishing agency person paper or any other source
	 * @param dateOfPublication The date of publication
	 * @param url The url of the news item
	 * @param location The geographic location of the news item
	 * @param language The language of the news item.
	 * @param title The title or the headlines
	 */
	
	public News(String content,
				String publisher,
				Date dateOfPublication,
				String url,
				String location,
				String language,
				String title
				) {
		
			this.content=content;
			this.publisher=publisher;
			this.dateOfPublication=dateOfPublication;
			this.url=url;
			this.location=location;
			this.language=language;
			this.title=title;
	}

	/**
	 * 
	 * @param that Another news object, working as copy constructor
	 */
	
	public News(News that){
		

			this.content=that.getContent();
		
			this.publisher=that.getPublisher();
		
			this.dateOfPublication=that.getDateOfPublication();
		
			this.url=getUrl();
		
			this.location=that.getLocation();
		
			this.language=that.getLanguage();

			this.title=that.getTitle();
	}

	public String getContent(){
		return this.content;
	}
	public String getPublisher(){
		return this.publisher;
	}
	public Date getDateOfPublication(){
		return this.dateOfPublication;
	}
	public String getUrl(){
		return this.url;
	}
	public String getLocation(){
		return this.location;
	}
	public String getLanguage(){
		return this.language;
	}
	public String getTitle(){
		return this.title;
	}
	
	
	
	
	@Override
	public String toString(){
		StringBuilder builder=new StringBuilder();
		builder.append("{");
		builder.append(" News title: "+this.title);
		builder.append(" News Content: "+this.content);
		builder.append(" News Publisher: "+this.publisher);
		builder.append(" Date of Publication: "+this.dateOfPublication);
		builder.append(" News URL: "+this.url);
		builder.append(" News Location: "+this.location);
		builder.append(" News Language: "+this.language);
		builder.append("}");
		return builder.toString();		
		}
	
	 /**
	   * Define equality of state.
	   */
	   @Override
	 public boolean equals(Object athat) {
	     if (this == athat) return true;
	     if (!(athat instanceof News)) return false;

	     News that = (News)athat;
	     return
	       ( this.title.equals(that.title) ) &&
	       ( this.content.equals(that.content) ) &&
	       ( this.publisher.equals(that.publisher) ) &&
	       ( this.dateOfPublication.equals(that.dateOfPublication) ) &&
	       ( this.url.equals(that.url) ) &&
	       ( this.location.equals(that.location) )&&
	         ( this.language.equals(that.language) );
	   }
	
	   /**
	    * A class that overrides equals must also override hashCode.
	    * 
	    */
	    @Override 
	      public int hashCode() {    
	      return this.toString().hashCode();
	    }

	public int compareTo(News that) {
		return this.dateOfPublication.compareTo(that.dateOfPublication);
		
	}
	 
	 
}
