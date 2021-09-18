package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;

import java.util.HashMap;
import java.util.Map;

public class MessageDAOStub implements IMessageDAO{

    Map<Integer, Message> allMessages = new HashMap<>();

    @Override
    public Message save(Message topic) throws Exception {
        allMessages.put(topic.getTopicID(), topic);
        return topic;
    }
}
