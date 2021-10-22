package com.enterprise.redcord.service;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ITopicService {

    Topic saveTopic(Topic topic) throws Exception;

    List<Message> fetchTopicById(String id) throws ExecutionException, InterruptedException;

    String fetchByTopicName(String searchTopic) throws ExecutionException, InterruptedException;
}
