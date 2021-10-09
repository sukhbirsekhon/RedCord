package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;

import java.util.List;

public interface ITopicDAO {

    Topic saveTopic(Topic topic) throws Exception;

    List<Topic> fetchAllTopics();

}
