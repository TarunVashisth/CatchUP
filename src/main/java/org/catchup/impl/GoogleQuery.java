package org.catchup.impl;

import org.catchup.GeneralQueryConstants;
import org.catchup.GoogleConstants;
import org.catchup.Query;

public class GoogleQuery extends Query{

	public GoogleQuery(String version, String topic, String ip) {
		super(version, topic, ip);
	}

	@Override
	public String returnQuery() {
		if(!this.isTopicClean(this.getTopic()))
		{
			this.cleanTopic(this.getTopic());
		}
		return GoogleConstants.GO_DEFAULT_PATH + GoogleConstants.GO_VERSION + GeneralQueryConstants.QUERY_EQUALISER+
		this.getVersion() + GeneralQueryConstants.QUERY_BINDER + GoogleConstants.GO_QUERY +GeneralQueryConstants.QUERY_EQUALISER
		+this.getTopic()+GeneralQueryConstants.QUERY_BINDER+GoogleConstants.GO_USER_IP+this.getIp();
	}
	
}
