package com.enterprise.redcord.dto;


import lombok.Data;

public @Data
class Topic {
     private String topicId;
     private int userId;
     private String topicName;
     private String topicDescription;
}
