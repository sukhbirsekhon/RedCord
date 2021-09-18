package com.enterprise.redcord.dto;


import lombok.Data;

public @Data
class Topic {
     private int TopicID;
     private int UserID;
     private String Title;
     private String Message;
}
