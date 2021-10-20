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

    /**
     * Save a new message
     * @param id is the entry to fetch.
     * @return the specified message by its id
     */
    List<Message> fetchById(String id) throws ExecutionException, InterruptedException;

    /**
     * Delete a message
     * @param id is the message to delete.
     */
    void delete(String id);
}
