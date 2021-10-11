package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;
import org.springframework.stereotype.Component;

import java.util.List;


public interface IMessageDAO {

    Message saveMessage(Message message) throws Exception;

    List<Message> fetchAllMessages();
}
