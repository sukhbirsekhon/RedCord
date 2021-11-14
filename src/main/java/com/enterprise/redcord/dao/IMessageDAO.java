package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IMessageDAO {

    /**
     * Saves a new Message Entry.
     * @param message is the message entry to save.
     */
    Message saveMessage(Message message) throws Exception;

    /**
     * Returns all message entries.
     * @return a collection of all message entries.
     */
    List<Message> fetchAllMessages() throws ExecutionException, InterruptedException;


    /**
     * Retrieves a message by id.
     * @param id is the id of the message to be retrieved
     * @return the specified message by its id
     */
    List<Message> fetchById(String id) throws ExecutionException, InterruptedException, IOException;


    /**
     * Retrieves message entries by search text, results are determined by message title
     * @param searchEntry is the search text of the message title to query.
     * @return the specified message entries that match the search text
     */
    List<Message> fetchEntry(String searchEntry) throws ExecutionException, InterruptedException, IOException;


    /**
     * Deletes a message with message id
     * @param id is the id of the message to be deleted.
     */
    void delete(String id);


    /**
     * Retrieve all messages with topic id
     * @param id is the id of a topic.
     */
    List<Message> fetchByTopicId(String id) throws ExecutionException, InterruptedException;


    /**
     * Updates an existing message entry with new user inputs
     * @param messageId is the id of the message being updated.
     * @param messageTitle is the new title to be updated.
     * @param message is the new message to be updated.
     */
    List<Message> updateEntryById(String messageId, String messageTitle, String message) throws ExecutionException, InterruptedException;
}