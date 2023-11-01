package com.example.interviewproject.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitBuilder {

    private static Retrofit instance;

    public static Retrofit getInstance() {
        if(instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl("https://api.spacexdata.com/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  instance;
    }
}
