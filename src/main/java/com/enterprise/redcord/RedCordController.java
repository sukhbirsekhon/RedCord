package com.enterprise.redcord;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import com.enterprise.redcord.service.IMessageService;
import com.enterprise.redcord.service.ITopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RedCordController {

    Logger logger = LoggerFactory.getLogger(RedCordController.class);

    @Autowired
    ITopicService topicService;
    @Autowired
    IMessageService messageService;

    /**
     * Handle the root (/) endpoint and return a start page
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        Message messageEntry = new Message();

        logger.trace("Accessed index method in RedCordController.");

        model.addAttribute(messageEntry);
        return "start";
    }

    
    @RequestMapping("/saveTopic")
    public String saveTopic(Topic topic) {
       logger.trace("Accessed savedTopic method in RedCordController.");

       try {
           topicService.save(topic);
       } catch(Exception e) {
           logger.error("Error in saveTopic method: " + e.getMessage());
           e.printStackTrace();
       }
       return "start";
    }

    @RequestMapping("/saveMessage")
    public String saveMessage(Message messageEntry) {
        logger.trace("Accessed saveMessage method in RedCordController.");

        try {
            messageService.saveMessage(messageEntry);
        } catch(Exception e) {
            logger.error("Error in saveMessage method: " + e.getMessage());
            e.printStackTrace();
        }
        return "start";
    }

    @GetMapping("/allMessages")
    @ResponseBody
    public List<Message> fetchAllMessages() {
        logger.trace("Accessed fetchAllMessages method in RedCordController.");

        try {
            return messageService.fetchAllMessages();
        } catch (Exception e) {
            logger.error("Error in fetchAllMessages method: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
