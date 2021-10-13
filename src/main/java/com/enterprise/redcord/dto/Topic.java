package com.enterprise.redcord.dto;


import lombok.Data;

public @Data
class Topic {

     private int topicId;
     private int userId;
     private String title;
     private String message;

}
