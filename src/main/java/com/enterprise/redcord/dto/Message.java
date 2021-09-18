package com.enterprise.redcord.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data
class Message {
     private int TopicID;
     private int UserID;
     private String Message;
}
