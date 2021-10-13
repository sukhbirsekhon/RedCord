package com.enterprise.redcord.dao;

import retrofit2.http.GET;

public interface IMessageRetrofitDAO {

    @GET("")
    void getMessage();
}
