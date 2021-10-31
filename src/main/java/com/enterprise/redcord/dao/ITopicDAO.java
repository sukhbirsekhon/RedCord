package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ITopicDAO {

    /**
     * Save a new Topic
     * @param topic a new topic
     */
    Topic saveTopic(Topic topic) throws InterruptedException, ExecutionException;


    /**
     * Retrieve topic by id
     * @param id of a topic
     */
    List<Message> fetchTopicById(String id) throws ExecutionException, InterruptedException;


    /**
     * Retrieve topic by name
     * @param searchTopic a name of a topic
     */
    String fetchTopicByName(String searchTopic) throws ExecutionException, InterruptedException;


    /**
     * Return all topics.
     * @return a collection of all topics.
     */
    List<Topic> fetchAllTopics() throws ExecutionException, InterruptedException;
}