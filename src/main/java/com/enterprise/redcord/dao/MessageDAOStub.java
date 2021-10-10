package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.service.MessageServiceStub;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MessageDAOStub implements IMessageDAO{

    Map<Integer, Message> allMessages = new HashMap<>();

    @Override
    public Message saveMessage(Message messageEntry) {
        List<Message> allMessageList = new ArrayList(allMessages.values());
        int latestMessageId = 0;
        int allMessageSize = allMessageList.size();
        if(allMessageSize > 0){
            Message lastMessage = allMessageList.get(allMessageSize - 1);
            latestMessageId = lastMessage.getMessageId();
        }
        messageEntry.setMessageId(latestMessageId + 1);
        try {
            allMessages.put(messageEntry.getMessageId(), messageEntry);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return messageEntry;
    }

    @Override
    public List<Message> fetchAllMessages() {
        return new ArrayList(allMessages.values());
    }
}
