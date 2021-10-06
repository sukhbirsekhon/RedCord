package com.enterprise.redcord;

import com.enterprise.redcord.dao.IMessageDAO;
import com.enterprise.redcord.dao.ITopicDAO;
import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import com.enterprise.redcord.service.IMessageService;
import com.enterprise.redcord.service.ITopicService;
import com.enterprise.redcord.service.MessageServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RedCordApplicationTests {

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
        messageEntry.setMessageId(1);
        messageEntry.setMessage("My First Posted Message");
    }

    private void thenCreateNewMessageRecordAndReturnIt() throws Exception {
        Message createdMessage = messageService.saveMessage(messageEntry);
        assertEquals(messageEntry, createdMessage);
    }


    @Test
    void saveTopicThenValidate() throws Exception  {
        whenSaveTopic();
        thenAssertSaved();
    }

    private void whenSaveTopic() throws Exception  {

        topic.setTopicId(1);
        topic.setUserId(1);
        topic.setTitle("My 1st Topic");
        topic.setMessage("First or last WaaaaOOOOO");
        Mockito.when(topicDAO.save(topic)).thenReturn(topic);
    }

    private void thenAssertSaved() throws Exception  {
        String message = topic.getMessage();
        assertEquals("First or last WaaaaOOOOO", message);
    }

}
