package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Topic;

public interface ITopicDAO {

    /**
     * Save a new Topic
     * @param topic a new topic
     */
    Topic save(Topic topic) throws Exception;

}
