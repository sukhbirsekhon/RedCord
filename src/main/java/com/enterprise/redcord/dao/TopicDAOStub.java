package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Topic;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TopicDAOStub implements ITopicDAO {

    Map<Integer, Topic> allTopics = new HashMap<>();

    @Override
    public Topic save(Topic topic) throws Exception {
        allTopics.put(topic.getTopicID(), topic);
        return topic;
    }
}
