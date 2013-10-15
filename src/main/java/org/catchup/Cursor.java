package org.catchup;
import java.util.Map;


public class Cursor {

	private Map<String,String> pages;
	private long estimateResultCount;
	private long currentPageIndex;
	private String moreResultsURL;
	
	public Cursor(Map<String,String> pages,long estimatedResultCount,long currentPageIndex,String moreResultsURL){
		
		this.pages=pages;
		this.estimateResultCount=estimatedResultCount;
		this.currentPageIndex=currentPageIndex;
		this.moreResultsURL=moreResultsURL;		
	}
	
	public Map<String,String> getPages(){
		return pages;
	}
	
	public long getEstimatedResultsCount(){
		return estimateResultCount;
	}
	public long getCurrentPageIndex(){
		return currentPageIndex;
	}
	public String getMoreResultsURL(){
		return moreResultsURL;
	}
	public String toString(){
		StringBuilder builder=new StringBuilder();
		builder.append("{");
		builder.append(" Pages: "+this.pages.toString());
		builder.append(" Estimated Results Count: "+this.estimateResultCount);
		builder.append(" Current Page Index: "+this.currentPageIndex);
		builder.append(" More Results URL: "+this.moreResultsURL);
		
		builder.append("}");
		return builder.toString();
	}
	
}
