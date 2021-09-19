package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IMessageDAO {

    Message save(Message message) throws Exception;

    List<Message> fetchAllMessages();
}
