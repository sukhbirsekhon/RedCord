package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

@Component
public class MessageDAOStub implements IMessageDAO{

    @Override
    public Message saveMessage(Message messageEntry) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference document = dbFirestore.collection("Messages").document();
        messageEntry.setMessageId(document.getId());
        ApiFuture<WriteResult> collectionsApiFuture = document.set(messageEntry);
        return messageEntry;
    }


    @Override
    public List<Message> fetchAllMessages() throws ExecutionException, InterruptedException {
        Map<String, Object> allMessages = new HashMap<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> collectionsApiFuture = dbFirestore.collection("Messages").get();
        List<QueryDocumentSnapshot> documents = collectionsApiFuture.get().getDocuments();
        for(QueryDocumentSnapshot document : documents){
            allMessages.put(document.getId(), document.getData());
        }
        return new ArrayList(allMessages.values());
    }


    @Override
    public List<Message> fetchById(String id) throws ExecutionException, InterruptedException {
        Map<String, Object> allMessages = new HashMap<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> collectionsApiFuture = dbFirestore.collection("Messages").get();
        List<QueryDocumentSnapshot> documents = collectionsApiFuture.get().getDocuments();
        for(QueryDocumentSnapshot document : documents){
            if(document.getId().equals(id)){
                allMessages.put(document.getId(), document.getData());
            }
        }
        return new ArrayList(allMessages.values());
    }


    @Override
    public List<Message> fetchEntry(String searchEntry) throws ExecutionException, InterruptedException, IOException {
        Map<String, Object> allMessages = new HashMap<>();
        Message foundMessages = new Message();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference messages = dbFirestore.collection("Messages");
        Query query = messages.whereGreaterThanOrEqualTo("title", searchEntry).whereLessThanOrEqualTo("title", searchEntry + "\uf8ff");
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        for(DocumentSnapshot document : querySnapshot.get().getDocuments()){
            allMessages.put(document.getId(), document.getData());
        }
        return new ArrayList(allMessages.values());
    }


    @Override
    public void delete(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("Messages").document(id).delete();
    }


    @Override
    public List<Message> fetchByTopicId(String id) throws ExecutionException, InterruptedException {
        Map<String, Object> allMessages = new HashMap<>();
        if(id != null && id != "") {
            Firestore dbFirestore = FirestoreClient.getFirestore();
            Query collectionsQuery = dbFirestore.collection("Messages").whereEqualTo("topicId", id);
            ApiFuture<QuerySnapshot> collectionsApiFuture = collectionsQuery.get();
            List<QueryDocumentSnapshot> documents = collectionsApiFuture.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                allMessages.put(document.getId(), document.getData());
            }
            return new ArrayList(allMessages.values());
        }
        else{
            return this.fetchAllMessages();
        }
    }

    @Override
    public List<Message> updateEntryById(String messageId, String messageTitle, String message) throws ExecutionException, InterruptedException {
        Map<String, Object> allMessages = new HashMap<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference docRef = dbFirestore.collection("Messages").document(messageId);
        ApiFuture<WriteResult> futureTitle = docRef.update("title", messageTitle);
        ApiFuture<WriteResult> futureMessage = docRef.update("message", message);
        return fetchById(messageId);
    }
}