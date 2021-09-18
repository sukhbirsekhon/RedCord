package com.enterprise.redcord.service;

import com.enterprise.redcord.dao.IMessageDAO;
import com.enterprise.redcord.dao.ITopicDAO;
import com.enterprise.redcord.dto.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceStub implements IMessageService{

    @Autowired
    private IMessageDAO messageDAO;

    public MessageServiceStub(IMessageDAO messageDAO) {
        this.messageDAO = messageDAO;

    }
    @Override
    public Message save(Message message) throws Exception {
        return messageDAO.save(message);
    }
}
