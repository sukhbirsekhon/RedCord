package com.enterprise.redcord.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Message Class
 */
public @Data
class Message {
     private int messageId;
     private int userId;
     private String message;
}
