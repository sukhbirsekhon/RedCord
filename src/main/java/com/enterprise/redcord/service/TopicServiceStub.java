package com.enterprise.redcord.service;

import com.enterprise.redcord.dao.ITopicDAO;
import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;


@Service
@Component
public class TopicServiceStub implements ITopicService{

    @Autowired
    private ITopicDAO topicDAO;

    public TopicServiceStub(){

    }

    public TopicServiceStub(ITopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }

    @Override
    public Topic saveTopic(Topic topic) throws Exception {
        return topicDAO.saveTopic(topic);
    }

    @Override
    public List<Message> fetchTopicById(String id) throws ExecutionException, InterruptedException {
        return topicDAO.fetchTopicById(id);
    }

    @Override
    public String fetchByTopicName(String searchTopic) throws ExecutionException, InterruptedException {
        return topicDAO.fetchTopicByName(searchTopic);
    }

    @Override
    public List<Topic> fetchAllTopics() throws ExecutionException, InterruptedException {
        return topicDAO.fetchAllTopics();
    }

}
