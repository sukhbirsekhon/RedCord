package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;
import com.enterprise.redcord.dto.Topic;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Repository
@Component
public class TopicDAOStub implements ITopicDAO {

    Map<String, Topic> allTopics = new HashMap<>();

    @Override
    public Topic saveTopic(Topic topic) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference document = dbFirestore.collection("Topics").document();
        topic.setTopicId(document.getId());
        ApiFuture<WriteResult> collectionsApiFuture = document.set(topic);
        return topic;
    }


    @Override
    public List<Message> fetchTopicById(String id) throws ExecutionException, InterruptedException {
        Map<String, Object> allTopics = new HashMap<>();
        //Message foundMessage = new Message();
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> collectionsApiFuture = dbFirestore.collection("Topics").get();
        List<QueryDocumentSnapshot> documents = collectionsApiFuture.get().getDocuments();
        for(QueryDocumentSnapshot document : documents){
            if(document.getId().equals(id)){
                //return document;
                allTopics.put(document.getId(), document.getData());
            }
        }
        return new ArrayList(allTopics.values());
    }

    @Override
    public String fetchTopicByName(String searchTopic) throws ExecutionException, InterruptedException {
        Map<String, Object> allTopics = new HashMap<>();
        String topicId = "";

        Firestore dbFirestore = FirestoreClient.getFirestore();
        Query collectionsQuery = dbFirestore.collection("Topics").whereEqualTo("topicName", searchTopic);
        ApiFuture<QuerySnapshot> collectionsApiFuture = collectionsQuery.get();
        List<QueryDocumentSnapshot> documents = collectionsApiFuture.get().getDocuments();

        for(QueryDocumentSnapshot document : documents){
            //allTopics.put(document.getId(), document.getData());
            //return document;
            topicId = document.getId();
        }


        return topicId;
    }

}
