package com.enterprise.redcord;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import com.enterprise.redcord.service.IMessageService;
import com.enterprise.redcord.service.ITopicService;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Controller
public class RedCordController {

    Logger logger = LoggerFactory.getLogger(RedCordController.class);

    @Autowired
    ITopicService topicService;

    @Autowired
    IMessageService messageService;


    /**
     * Handles the root (/) endpoint
     * Sets the root (/) page with object attributes
     * @return the start.html location
     */
    @RequestMapping( "/")
    public String index(@ModelAttribute("topicEntry") String topicName, Model model) throws IOException {
        String topicId = null;
        List<Message> messages = null;
        List<Topic> topics = null;
        try {
            topicId = topicService.fetchByTopicName(topicName);
            messages = messageService.fetchByTopicId(topicId);
            topics = topicService.fetchAllTopics();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.trace("Accessed index method in RedCordController.");
        model.addAttribute("messages", messages);
        model.addAttribute("topics", topics);
        model.addAttribute("messageEntry", new Message());
        model.addAttribute("topicEntry", new Topic());
        return "start";
    }


    /**
     * Handles the /saveTopic endpoint
     * Saves a new topic with provided topic information from the database through the message service and DAO
     * @return a redirect to the root (/) endpoint
     */
    @RequestMapping("/saveTopic")
    public String saveTopic(Topic topic) {
       logger.trace("Accessed savedTopic method in RedCordController.");
       try {
           topicService.saveTopic(topic);
       }catch(Exception e){
           logger.error("Error in saveTopic method: " + e.getMessage());
           e.printStackTrace();
       }
       return "redirect:/";
    }


    /**
     * Handles the /newMessage GET method endpoint
     * Sets the newMessage.html page with object attributes
     * @return the newMessage.html location
     */
    @GetMapping("/newMessage")
    public String newMessage(Model model) {
        List<Topic> topics = null;
        try {
            topics = topicService.fetchAllTopics();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        model.addAttribute("topics", topics);
        model.addAttribute("messageEntry", new Message());
        model.addAttribute("topic", new Topic());
        return "newMessage";
    }


    /**
     * Handles the /saveMessage POST method endpoint
     * Saves a message entry with provided message information in the model attributes from the database through the message service and DAO
     * @return a redirect to the root (/) endpoint
     */
    @PostMapping(value="/saveMessage")
    public String saveMessage(@ModelAttribute("topicEntry") String topicName, @ModelAttribute("messageEntry") Message messageEntry, Model model) {
        logger.trace("Accessed saveMessage method in RedCordController.");
        String topicId = null;
        Message newMessage = null;
        try {
            topicId = topicService.fetchByTopicName(topicName);
            messageEntry.setTopicId(topicId);
            newMessage = messageService.saveMessage(messageEntry);
        }catch(Exception e){
            logger.error("Error in saveMessage method: " + e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/";
    }


    /**
     * Handles the /allMessages GET method endpoint
     * Retrieves all message entries from the database through the message service and DAO
     * @return the JSON data page with all entries present
     */
    @GetMapping("/allMessages")
    @ResponseBody
    public List<Message> fetchAllMessages() throws ExecutionException, InterruptedException {
        logger.trace("Accessed fetchAllMessages method in RedCordController.");
        try {
            return messageService.fetchAllMessages();
        } catch (Exception e) {
            logger.error("Error in fetchAllMessages method: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Handles the /searchMessageEntry GET method endpoint
     * Retrieves all message entries with matching search text from the database through the message service and DAO
     * @return all message entries that are a result of the user input for the search field
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
     * Handles the /messageById GET method endpoint
     * Retrieves a message entry with provided message information in the requestParams from the database through the message service and DAO
     * @return the JSON data page with the entries present matching the message id
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
     * Handles the /messageByTopicId GET Method endpoint
     * Retrieves a message entry with provided topic id from the database through the message service and DAO
     * @return the JSON data page with the entries present matching the topic id
     */
    @GetMapping("/messageByTopicId")
    public ResponseEntity fetchMessageByTopicId(@RequestParam Map<String, String> requestParams) {
        String topicId = "";
        try {
            topicId = requestParams.get("topicId");
            List<Message> foundMessageEntry = messageService.fetchByTopicId(topicId);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(foundMessageEntry, headers, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Handles the /deleteMessage POST Method endpoint
     * Deletes a message entry with provided message information in the requestParams from the database through the message service and DAO
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


    /**
     * Handles the /deleteMessage/{messageId}/ POST Method endpoint
     * Deletes a message entry with provided message id from the database through the message service and DAO
     * @return the JSON data page with all entries present excluding the deleted entry
     */
    @PostMapping(value="/deleteMessage/{messageId}/")
    public String deleteMessageById(@PathVariable("messageId") String messageId) {
        logger.trace("Accessed deleteMessageById method in RedCordController.");
        try {
            messageService.delete(messageId);
        } catch(Exception e){
            logger.error("Error in deleteMessageById method: " + e.getMessage());
        }
        return "redirect:/";
    }


    /**
     * Handles the /messageThread GET Method endpoint
     * Retrieves a message entry with provided message id from the database through the message service and DAO
     * @return the messageThread page populated with the messages object
     */
    @GetMapping("/messageThread/{messageId}/")
    public ModelAndView messageThread(@PathVariable("messageId") String messageId) throws IOException, ExecutionException, InterruptedException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("messageThread");
        List<Message> messages = messageService.fetchById(messageId);
        modelAndView.addObject("messages", messages);
        modelAndView.addObject("messageUpdate", new Message());
        return  modelAndView;
    }


    /**
     * Handles the /updateMessageThread/{messageId}/ POST Method endpoint
     * Updates the message entry in the database through the message service and DAO
     * @return a redirect to the messageThread page populated with the updated messages object
     */
    @PostMapping("/updateMessageThread/{messageId}/")
    public String updateMessageThread(@RequestParam("title") String messageTitle, @RequestParam("message") String message, @PathVariable("messageId") String messageId, Model model) throws IOException, ExecutionException, InterruptedException {
        logger.trace("Accessed updateMessageThread method in RedCordController.");
        List<Message> updateMessage = null;
        try {
            updateMessage = messageService.updateEntryById(messageId, messageTitle, message);
        }catch(Exception e){
            logger.error("Error in updateMessageThread method: " + e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/messageThread/{messageId}/";
    }


    /**
     * Handles the /cancelUpdateMessageThread/{messageId}/ POST Method endpoint
     * Cancels the update initiation and reverts message back to previous saved version
     * @return a redirect to the messageThread page populated with the unaltered message object
     */
    @PostMapping("/cancelUpdateMessageThread/{messageId}/")
    public String cancelUpdateMessageThread(@PathVariable("messageId") String messageId, Model model) {
        return "redirect:/messageThread/{messageId}/";
    }
}
