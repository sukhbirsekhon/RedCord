package com.enterprise.redcord.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.jasypt.util.password.BasicPasswordEncryptor;

public @Data
class User{

    @SerializedName("userId") private Integer userId;
    @SerializedName("userName") private String userName;
    @SerializedName("password") private String password;
    @SerializedName("email") private String email;
    @SerializedName("status") private String status;


    public void setPassword(String userPassword) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(userPassword);
        this.password = encryptedPassword;

    }

}

