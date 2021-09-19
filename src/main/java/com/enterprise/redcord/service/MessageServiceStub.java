package com.enterprise.redcord.service;

import com.enterprise.redcord.dao.IMessageDAO;
import com.enterprise.redcord.dao.ITopicDAO;
import com.enterprise.redcord.dto.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MessageServiceStub implements IMessageService{

    @Autowired
    private IMessageDAO messageDAO;

//    public MessageServiceStub(IMessageDAO messageDAO) {
//        this.messageDAO = messageDAO;
//
//    }
    @Override
    public Message save(Message messageEntry) throws Exception {
        return messageDAO.save(messageEntry);
    }

    @Override
    public List<Message> fetchAllMessages() {
        return messageDAO.fetchAllMessages();
    }


}
