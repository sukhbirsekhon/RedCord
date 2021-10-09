package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Topic;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * TopicDaoStub class that is implementing the TopicDAO interface
 * saveTopic, and fetchAllTopics methods. Meant to save and list possible topics
 */
@Repository
@Component
public class TopicDAOStub implements ITopicDAO {

    Map<Integer, Topic> allTopics = new HashMap<>();

    @Override
    public Topic saveTopic(Topic topic) throws Exception {
        allTopics.put(topic.getTopicId(), topic);
        return topic;
    }

    @Override
    public List<Topic> fetchAllTopics() {
        return null;
    }
}
