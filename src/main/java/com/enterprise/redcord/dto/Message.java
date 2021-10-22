package com.enterprise.redcord.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data
class Message {
     @SerializedName("messageId")
     private String messageId;
     @SerializedName("userId")
     private int userId;
     @SerializedName("title")
     private String title;
     @SerializedName("message")
     private String message;
     @SerializedName("topicId")
     private String topicId;


     public String toString(){
          return title + "";
     }
}
