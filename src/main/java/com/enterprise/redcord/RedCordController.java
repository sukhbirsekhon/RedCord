package com.enterprise.redcord;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import com.enterprise.redcord.service.IMessageService;
import com.enterprise.redcord.service.ITopicService;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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
/*    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("messageEntry", new Message());
        return "start";
    }*/
    @RequestMapping("/")
    public String index(@RequestParam(value="", required = false, defaultValue="None") String searchEntry, Model model) {
        List<Message> messages = null;
        try {
            messages = messageService.fetchAllMessages();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        model.addAttribute("messages", messages);
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

    @GetMapping("/newMessage")
    public String newMessage(Model model){
        model.addAttribute("messageEntry", new Message());
        return "newMessage";
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
    @GetMapping("/allMessages")
    @ResponseBody
    public List<Message> fetchAllMessages() throws ExecutionException, InterruptedException {
        return messageService.fetchAllMessages();
    }

    /**
     * Handle the /searchJournalEntry GET method endpoint
     * @return results of the user input for search field
     */
    @GetMapping("/searchMessageEntry")
    public String searchEntry(@RequestParam(value="searchEntry", required = false, defaultValue="None") String searchEntry, Model model) {
        try {
            List<Message> messages = messageService.fetchEntry(searchEntry);
            model.addAttribute("messages", messages);
            return "searchedMessages";
        } catch (ExecutionException e) {
            e.printStackTrace();
            return "error";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "error";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }


    /**
     * Handle the /journalEntryById GET method endpoint
     * @return the JSON data page with only the requested journal entry present
     */
    @GetMapping("/messageById")
    public ResponseEntity fetchMessageById(@RequestParam Map<String, String> requestParams) {
        String messageId = "";
        try {
            messageId = requestParams.get("messageId");
            List<Message> foundMessageEntry = messageService.fetchById(messageId);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(foundMessageEntry, headers, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Handle the /deleteJournalEntry GET Method endpoint
     * @return the JSON data page with all entries present excluding the deleted entry
     */
    @PostMapping(value="/deleteMessage")
    public ResponseEntity deleteMessage(@RequestParam Map<String, String> requestParams) {
        String messageId = "";
        try {
            messageId = requestParams.get("messageId");
            messageService.delete(messageId);
            return new ResponseEntity(messageService.fetchAllMessages(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
