package com.enterprise.redcord;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import com.enterprise.redcord.service.IMessageService;
import com.enterprise.redcord.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Message message = new Message();
        model.addAttribute(message);
        return "start";
    }
    
    
    
    @RequestMapping("/saveTopic")
    public String index(Topic topic) {
       try {
           topicService.save(topic);
       }catch(Exception e){
           e.printStackTrace();
        }
        return "start";
    }





}
