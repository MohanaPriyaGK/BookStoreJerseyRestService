package org.gk.restful.messenger.dao;

import java.util.HashMap;
import java.util.Map;

import org.gk.restful.messenger.model.Message;

public class MessageDAO {

	private static Map<Long,Message> MessageMap = new HashMap<>();
	
	public MessageDAO() {
		Message m1 = new Message(1, "HelloWord", "gk");
		Message m2 = new Message(2, "HelloJersey", "gk");

		MessageMap.put(m1.getId(), m1);
		MessageMap.put(m2.getId(), m2);
	}
	
	public Map<Long, Message> getMessageMap() {
		return MessageMap;
	}

}
