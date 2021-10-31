package com.enterprise.redcord.service;

import com.enterprise.redcord.dto.Message;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;


public interface IMessageService {

    /**
     * saves newly created message
     * @param message is the entry to save
     * @return returns the message entry
     */
    Message saveMessage(Message message) throws Exception;


    /**
     * Retrieves all messages
     * @return all messages
     */
    List<Message> fetchAllMessages() throws ExecutionException, InterruptedException;


    /**
     * Retrieve message by id
     * @param id is the entry to fetch.
     * @return the specified message by its id
     */
    List<Message> fetchById(String id) throws ExecutionException, InterruptedException, IOException;


    /**
     * Retrieve message by id
     * @param id is the entry to fetch.
     * @return the specified message by its id
     */
    List<Message> fetchByTopicId(String id) throws ExecutionException, InterruptedException, IOException;


    /**
     * Retrieve message by search, results are determined by message title
     * @param searchEntry is the entry to fetch.
     * @return the specified message by combined title words
     */
    List<Message> fetchEntry(String searchEntry) throws ExecutionException, InterruptedException, IOException;


    /**
     * Delete a message by id
     * @param id is the entry to delete.
     */
    void delete(String id) throws Exception;
}