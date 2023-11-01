package com.example.interviewproject.data.api;

import com.example.interviewproject.model.SpaceXLaunchResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("launches")
    Call<ArrayList<SpaceXLaunchResponse>> getSpaceLaunchData();
}
