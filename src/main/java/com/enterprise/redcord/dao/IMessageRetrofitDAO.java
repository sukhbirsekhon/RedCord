package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface IMessageRetrofitDAO {

    @GET("projects/redcord-cad62-default-rtdb/databases/(default)/documents/Messages/title")
            Call<List<Message>> getMessage(@Query("searchEntry") String searchEntry);

    @GET("/allMessages")
    List<Message> getAllMessages();
}
