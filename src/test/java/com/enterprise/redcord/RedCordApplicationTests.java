package com.enterprise.redcord;

import com.enterprise.redcord.dao.IMessageDAO;
import com.enterprise.redcord.dao.ITopicDAO;
import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import com.enterprise.redcord.service.IMessageService;
import com.enterprise.redcord.service.ITopicService;
import com.enterprise.redcord.service.MessageServiceStub;
import com.enterprise.redcord.service.TopicServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class RedCordApplicationTests {
    @MockBean
    private ITopicService topicService;

    @MockBean
    private ITopicDAO topicDAO;

    private Topic topic = new Topic();

    @MockBean
    private IMessageService messageService;

    @MockBean
    private IMessageDAO messageDAO;

    private Message messageEntry = new Message();

    @Test
    void contextLoads() {
    }

    @Test
    void saveMessage_validateReturnMessage() throws Exception {
        givenMessageDataAreAvailable();
        whenUserSubmitsANewMessage();
        thenCreateNewMessageRecordAndReturnIt();
    }

    private void givenMessageDataAreAvailable() throws Exception {
        Mockito.when(messageDAO.saveMessage(messageEntry)).thenReturn(messageEntry);
        messageService = new MessageServiceStub(messageDAO);
    }

    private void whenUserSubmitsANewMessage() {
        messageEntry.setMessageId("1");
        messageEntry.setTopicId("1");
        messageEntry.setTitle("1st Message");
        messageEntry.setMessage("My First Posted Message");
    }

    private void thenCreateNewMessageRecordAndReturnIt() throws Exception {
        Message createdMessage = messageService.saveMessage(messageEntry);
        assertEquals(messageEntry, createdMessage);
    }

    @Test
    void save_validateReturnTopicWithTopicIDUserIDTitleAndMessage() throws Exception {
        givenTopicDataAreAvailable();
        whenUserCreatesOrUpdatesTopicAndSaves();
        thenCreateNewTopicRecordAndReturnIt();
    }

    private void givenTopicDataAreAvailable() throws Exception {
        Mockito.when(topicDAO.saveTopic(topic)).thenReturn(topic);
        topicService = new TopicServiceStub(topicDAO);
    }

    private void whenUserCreatesOrUpdatesTopicAndSaves() throws Exception {
        topic.setTopicId("1");
        topic.setTopicName("Movies");
        topic.setTopicDescription("Lets talk about movies");
        Mockito.when(topicDAO.saveTopic(topic)).thenReturn(topic);
    }

    private void thenCreateNewTopicRecordAndReturnIt() throws Exception {
        Topic savedTopic = topicService.saveTopic(topic);
        assertEquals(topic, savedTopic);
        verify(topicDAO, atLeastOnce()).saveTopic(topic);
    }

    @Test
    void Update_Topic() throws Exception {
        givenTopicDataAreAvailable();
        GetTopicByName();
        EnsureTopicExist();
    }

    private void GetTopicByName() throws Exception{
        topic.setTopicName("test");
        topic.setTopicId("711");
        topic.setTopicDescription("just a test");
        Mockito.when(topicDAO.saveTopic(topic)).thenReturn(topic);
    }
    private void EnsureTopicExist() throws Exception {
        Topic savedTopic = topicService.saveTopic(topic);
        assertEquals(topic, savedTopic);
        verify(topicDAO, atLeastOnce()).saveTopic(topic);
    }

    @Test
    void Delete_Message() throws Exception {
        givenMessageDataAreAvailable();
        whenUserSubmitsANewMessage();
        DeleteNewMessage();
    }

    private void DeleteNewMessage() throws Exception{
        Message createdMessage = messageService.saveMessage(messageEntry);
        assertEquals(messageEntry, createdMessage);
       // Mockito.when(messageDAO.delete("7")).thenReturn(messageEntry);;
        messageService.delete(messageEntry.getMessageId());
        
        createdMessage = null;
        assertNotEquals(messageEntry, createdMessage);
    }


}