package com.enterprise.redcord.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data
class Message {
    @SerializedName("MessageID") private Integer TopicID;
    @SerializedName("Message") private String Message;
}
