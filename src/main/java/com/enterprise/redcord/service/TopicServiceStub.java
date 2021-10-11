package com.enterprise.redcord.service;

import com.enterprise.redcord.dao.ITopicDAO;
import com.enterprise.redcord.dto.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class TopicServiceStub implements ITopicService{

    @Autowired
    private ITopicDAO topicDAO;

    public TopicServiceStub(){

    }

    public TopicServiceStub(ITopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }

    @Override
    public Topic save(Topic topic) throws Exception {
        return topicDAO.save(topic);
    }
}
