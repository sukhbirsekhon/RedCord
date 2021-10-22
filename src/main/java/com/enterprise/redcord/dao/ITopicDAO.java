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


    List<Message> fetchTopicById(String id) throws ExecutionException, InterruptedException;

    String fetchTopicByName(String searchTopic) throws ExecutionException, InterruptedException;
}
