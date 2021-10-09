package com.enterprise.redcord.service;

import com.enterprise.redcord.dto.Topic;

import java.util.List;

public interface ITopicService {

    Topic saveTopic(Topic topic) throws Exception;

    List<Topic> fetchAllTopics();
}
