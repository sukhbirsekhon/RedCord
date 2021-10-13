package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;
import java.util.*;



@Component
public class MessageDAOStub implements IMessageDAO{

    //Map<Integer, Message> allMessages = new HashMap<>();

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

}
