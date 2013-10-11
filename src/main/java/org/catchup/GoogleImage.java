package org.catchup;

public class GoogleImage extends Image{

	
	private String titleNoFormating;
	private String originalContextURL;
	private String tbURL;
	private String tbWidth;
	private String tbHeight;
	
	
	public GoogleImage(String title,String url,String publisher,
			
			String titleNoFormating,
			String originalContextURL,
			String tbURL,
			String tbWidth,
			String tbHeight
			){
		super(title,url,publisher);
		
		this.titleNoFormating=titleNoFormating;
		this.originalContextURL=originalContextURL;
		this.tbURL=tbURL;
		this.tbWidth=tbWidth;
		this.tbHeight=tbHeight;
	}
	
	public String getTitleNoFormatting(){
		return titleNoFormating;
	}
	public String getOriginalContextURL(){
		return originalContextURL;
	}
	
	public String getTBUrl(){
		return tbURL;
	}
	
	public String getTBWidth(){
		return tbWidth;
	}
	public String getTBHeight(){
		return tbHeight;
	}
	
	
}
