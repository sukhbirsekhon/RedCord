package com.enterprise.redcord.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data
class User{
    @SerializedName("UserID") private Integer UserID;
    @SerializedName("UserName") private String UserName;
    @SerializedName("Password") private String Password;
    @SerializedName("Email") private String Email;
    @SerializedName("Status") private String Status;
}

