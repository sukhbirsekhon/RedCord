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
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        Message messageEntry = new Message();
        model.addAttribute(messageEntry);
        return "start";
    }
    
    
    
    @RequestMapping("/saveTopic")
    public String saveTopic(Topic topic) {
       try {
           topicService.saveTopic(topic);
       }catch(Exception e){
           e.printStackTrace();
        }
        return "start";
    }

    @RequestMapping("/saveMessage")
    public String saveMessage(Message messageEntry) {
        try {
            messageService.saveMessage(messageEntry);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "start";
    }

    @GetMapping("/allMessages")
    @ResponseBody
    public List<Message> fetchAllMessages() {
        return messageService.fetchAllMessages();
    }



}
