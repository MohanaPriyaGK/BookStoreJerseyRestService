package org.gk.restful.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gk.restful.messenger.dao.MessageDAO;
import org.gk.restful.messenger.model.Message;

public class MessageService {
	
	MessageDAO messageDAO = new MessageDAO();

	private Map<Long, Message> MessageMap = messageDAO.getMessageMap();

	public List<Message> getAllMessages() {
		if( 0 == MessageMap.size()) {
			return null;
		}
		List<Message> messageList = new ArrayList<>();
		MessageMap.forEach((k,v)-> messageList.add(v));
		return messageList;
	}

	public Message getMessage(long id) {
		if (id <= 0 || null == MessageMap.get(id)) {
			return null;
		}
		Message mesg = MessageMap.get(id);
		return mesg;
	}

	public Message addMessage(Message message) {
		message.setId(MessageMap.size() + 1);
		MessageMap.put((long) (MessageMap.size() + 1), message);
		return message;
	}

	public Message updateMessage(Long messageId,Message message) {
		message.setId(messageId);
		if (null != message && 0 != message.getId() && null != MessageMap.get(messageId)) {
			
			MessageMap.put(messageId, message);
		}
		return message;
	}

	public void removeMessage(Long messageId) {
		MessageMap.remove(messageId);
	}
	
}
