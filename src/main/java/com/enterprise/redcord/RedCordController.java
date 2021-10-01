package com.enterprise.redcord;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import com.enterprise.redcord.service.IMessageService;
import com.enterprise.redcord.service.ITopicService;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class RedCordController {

    @Autowired
    ITopicService topicService;
    @Autowired
    IMessageService messageService;

    /**
     * Handle the root (/) endpoint
     * @return the start.html location
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("messageEntry", new Message());
        return "start";
    }

    /**
     * Handle the root (/saveTopic) endpoint
     * @return the start.html location
     */
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
     * Handle the /saveMessage POST method endpoint
     * @return the start.html location
     */
    @PostMapping(value="/saveMessage")
    public String saveMessage(@ModelAttribute("messageEntry") Message messageEntry, Model model) {
        Message newMessage = null;
        try {
            newMessage = messageService.saveMessage(messageEntry);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "start";
    }

    /**
     * Handle the /allMessages GET method endpoint
     * @return the JSON data page with all entries present
     */
/*    @GetMapping("/allMessages")
    @ResponseBody
    public List<Message> fetchAllMessages() {
        return messageService.fetchAllMessages();
    }*/

    @GetMapping("/allMessages")
    @ResponseBody
    public List<Message> fetchAllMessages() throws ExecutionException, InterruptedException {
        return messageService.fetchAllMessages();
    }


}
