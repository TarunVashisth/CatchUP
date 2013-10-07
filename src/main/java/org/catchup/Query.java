package org.catchup;

/**
 * 
 * @author vashisth
 * Every Provider has to extend this class so that customized query can be created for each provider 
 */
public abstract class Query {
	private String version;
	private String topic;
	private String ip;
	
	public Query(String version, String topic, String ip)
	{
		this.version=version;
		this.topic=topic;
		this.ip=ip;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}
	
	public boolean isTopicClean(String topic)
	{
		return !(topic.contains(" "));
	}
	
	public void cleanTopic(String topic)
	{
		this.topic=topic.replaceAll(" ", "%20");
	}

	public abstract String returnQuery();
}
