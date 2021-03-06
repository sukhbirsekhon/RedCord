package com.enterprise.redcord.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data
class User{

    @SerializedName("userId") private Integer userId;
    @SerializedName("userName") private String userName;
    @SerializedName("password") private String password;
    @SerializedName("email") private String email;
    @SerializedName("status") private String status;

}

