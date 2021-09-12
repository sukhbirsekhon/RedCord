package com.enterprise.redcord.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data
class Topic {
    @SerializedName("TopicID") private Integer TopicID;
    @SerializedName("Title") private String Title;
    @SerializedName("Message") private String Message;
}
