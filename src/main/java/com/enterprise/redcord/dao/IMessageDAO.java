package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IMessageDAO {

    /**
     * Save a new Message Entry
     * @param message the entry to save.
     */
    Message saveMessage(Message message) throws Exception;

    /**
     * Return all message entries.
     * @return a collection of all message entries.
     */
    List<Message> fetchAllMessages() throws ExecutionException, InterruptedException;
}
