package com.enterprise.redcord.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static Gson gson;
    private static OkHttpClient client;
    private static String BASE_URL = "https://redcord-cad62-default-rtdb.firebaseio.com/";

    public static Retrofit getRetrofitInstance(){
        if(gson == null) {
            gson = new GsonBuilder()
                    .setLenient()
                    .create();
        }

        if(client == null) {
            client = new OkHttpClient();
        }


        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
