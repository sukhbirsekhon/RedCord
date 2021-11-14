package com.enterprise.redcord.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

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

    // @ManyToOne
    // @JoinColumn(name="topicId")
     private Topic topic;

     public String toString(){
          return title + "";
     }
}
