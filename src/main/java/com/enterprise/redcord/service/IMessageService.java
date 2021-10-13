package com.enterprise.redcord.service;

import com.enterprise.redcord.dto.Message;

import java.util.List;
import java.util.concurrent.ExecutionException;


public interface IMessageService {

    Message saveMessage(Message message) throws Exception;

    List<Message> fetchAllMessages() throws ExecutionException, InterruptedException;
}
