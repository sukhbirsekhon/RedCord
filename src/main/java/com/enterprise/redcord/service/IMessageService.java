package com.enterprise.redcord.service;

import com.enterprise.redcord.dto.Message;

import java.util.List;
import java.util.concurrent.ExecutionException;


public interface IMessageService {

    Message saveMessage(Message message) throws Exception;

    List<Message> fetchAllMessages() throws ExecutionException, InterruptedException;

    /**
     * Retrieve message by id
     * @param id is the entry to fetch.
     * @return the specified message by its id
     */
    List<Message> fetchById(String id) throws ExecutionException, InterruptedException;

    /**
     * Delete a message by id
     * @param id is the entry to delete.
     */
    void delete(String id) throws Exception;

}
