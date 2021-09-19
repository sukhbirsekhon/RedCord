package com.enterprise.redcord;

import com.enterprise.redcord.dao.ITopicDAO;
import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import com.enterprise.redcord.service.ITopicService;
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
    @Test
    void contextLoads() {
    }
    private Topic topic = new Topic();

    @Test
    void save_fetch() throws Exception  {
        saveTopic();
        assertSaved();
    }

    private void saveTopic() throws Exception  {
        Topic worldFirst = new Topic();
        topic.setTopicId(1);
        topic.setUserId(1);
        topic.setTitle("My 1st Topic");
        topic.setMessage("First or last WaaaaOOOOO");
        Mockito.when(topicDAO.save(topic)).thenReturn(topic);
    }

    private void assertSaved() throws Exception  {
        String message = topic.getMessage();
        assertEquals("First or last WaaaaOOOOO", message);
    }

}
