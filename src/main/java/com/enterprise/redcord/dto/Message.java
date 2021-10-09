package com.enterprise.redcord.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Message dto
 * Holds message class variable information, topicId, messageId,userId, message
 */
public @Data
class Message {
     private int topicId;
     private int messageId;
     private int userId;
     private String message;
}
