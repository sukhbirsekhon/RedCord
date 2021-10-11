package com.enterprise.redcord;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import com.enterprise.redcord.service.IMessageService;
import com.enterprise.redcord.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RedCordController {

    @Autowired
    ITopicService topicService;
    @Autowired
    IMessageService messageService;

    /**
     * Handle the root (/) endpoint and return a start page
     * @return /start
     */
    @RequestMapping("/")
    public String index(Model model) {
        Message messageEntry = new Message();
        model.addAttribute(messageEntry);
        return "start";
    }


    /**
     * @param topic from data containing user created Topic
     * @return /start
     */
    //Endpoint called
    @RequestMapping("/saveTopic")
    public String saveTopic(Topic topic) {
       try {
           topicService.save(topic);
       }catch(Exception e){
           e.printStackTrace();
        }
        return "start";
    }

    /**
     * @param messageEntry Message created via form on index page
     * @return /start
     */
    @RequestMapping("/saveMessage")
    public String saveMessage(Message messageEntry) {
        try {
            messageService.saveMessage(messageEntry);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "start";
    }


    /**
     * The /allMessages enpoint returns a JSON file containing all Message data stored.
     * @return JSON page containing all Message data via fetchAllMessages()
     */
    @GetMapping("/allMessages")
    @ResponseBody
    public List<Message> fetchAllMessages() {
        return messageService.fetchAllMessages();
    }



}
