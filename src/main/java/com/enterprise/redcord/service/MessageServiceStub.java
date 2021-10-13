package com.enterprise.redcord.service;

import com.enterprise.redcord.dao.IMessageDAO;
import com.enterprise.redcord.dto.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Component
public class MessageServiceStub implements IMessageService{

    @Autowired
    private IMessageDAO messageDAO;

    public MessageServiceStub(){

    }

    public MessageServiceStub(IMessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @Override
    public Message saveMessage(Message messageEntry) throws Exception {
        return messageDAO.saveMessage(messageEntry);
    }

    @Override
    public List<Message> fetchAllMessages() throws ExecutionException, InterruptedException {
        return messageDAO.fetchAllMessages();
    }
}
